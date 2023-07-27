package classes;

import java.awt.*;

public class Rectangle extends Shape{
	//atributos 
	//atributos que apenas retângulo precisa ter
	private int width;
	private int height;
	
	//construtores
	public Rectangle(Color color, int posX, int posY, int width, int height) {
		super(color, posX, posY);
		this.width= width;
		this.height= height;
	}
	//métodos específicos 

	@Override
	public void draw(Graphics g) {
		g.setColor(super.getColor());
		g.fillRect(super.getPosX(), super.getPosY(), this.width, this.height);
		
	}
	
	public void changeDir(int limXmin, int limXmax, int limYmin, int limYmax){
		if(super.getPosX()+this.width>=limXmax
			||super.getPosX()<= limXmin) {
			super.setSpeedX(super.getSpeedX()*-1);
			super.setColor(super.colorGenerate());
		}
		
		if(super.getPosY()+this.height>=limYmax
				||super.getPosY()<= limYmin) {
				super.setSpeedY(super.getSpeedY()*-1);
				super.setColor(super.colorGenerate());
			}
	}
	
	//métodos de acesso

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	
	

}
