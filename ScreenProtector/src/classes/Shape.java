package classes;
import java.awt.*;
import java.util.Random;

public abstract class Shape {
	
	//atributos
	private Color color;
	private int posX;
	private int posY;
	private int speedX;
	private int speedY;
	
	//construtor com parâmetros
	public Shape (Color color, int posX, int posY) {
		this.color=color;
		this.posX=posX;
		this.posY=posY;	
		this.speedX=2;
		this.speedY=2;
	}

	//métodos de acesso(getters and setters)

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getSpeedX() {
		return speedX;
	}

	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}

	public int getSpeedY() {
		return speedY;
	}

	public void setSpeedY(int speedY) {
		this.speedY = speedY;
	}
	
	//métodos específicos 
	public void move() {
		this.posX+=this.speedX;
		this.posY+=this.speedY;
	}
	
	public Color colorGenerate() {
		int r,g,b;
		Random rand = new Random();
		
		r= rand.nextInt(255);
		g= rand.nextInt(255);
		b= rand.nextInt(255);
		
		return new Color(r,g,b);
	}
	
	
	//métodos abstratos 
	public abstract void draw(Graphics g);
	/*método que coloca-se na classe, mas não implementa ele, 
	quem implementa são as classes filhas
	
	para que a classe seja abstrata, é necessário abstrair a classe inteira*/

	public abstract void changeDir(int limXmin, int limXmax, int limYmin, int limYmax);
		// TODO Auto-generated method stub
		
	
}
