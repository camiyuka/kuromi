package classes;
import java.awt.*;
import javax.swing.*;

public class Image {
	//atributos 
	private ImageIcon img;
	private int posX, posY, width, height;
	SoundEffect sound;

	//construtores
	public Image (String url, int posX, int posY) {
		this.img= new ImageIcon(this.getClass().getResource(url));
		this.posX= posX;
		this.posY= posY;
		this.width=img.getIconWidth();
		this.height=img.getIconHeight();
		this.sound=null;
	}
	
	public Image (String url, int posX, int posY, String sound, boolean loop) {
		this.img= new ImageIcon(this.getClass().getResource(url));
		this.posX= posX;
		this.posY= posY;
		this.width=img.getIconWidth();
		this.height=img.getIconHeight();
		this.sound= new SoundEffect(sound,loop);
	}
	
	//métodos específicos 
	public void draw(Graphics g) {
		
		g.drawImage(img.getImage(),this.posX, 
				this.posY,this.width,
				this.height,null);
	}
	
	public void scale(double scale) {
		this.width*=scale;
		this.height*=scale;
	}
	
	//métodos de acesso
	public void moveX(int inc) {
		this.posX+=inc;
	}
	public void moveY(int inc) {
		this.posY+=inc;
	}

	public ImageIcon getImg() {
		return img;
	}

	public void setImg(ImageIcon img) {
		this.img = img;
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
	
	public void getColision(int width, int height) {
		//colisão com a carra lateral esquerda, direta, inferior e superior
		if(this.posX+this.width>width) {
			this.posX= width-this.width;
			this.sound.play();
		
		}
		if(this.posX<0) {
			this.posX=0;
			this.sound.play();
		}
		
		if(this.posY+this.height>height) {
			this.posY= height-this.height;
			this.sound.play();
		}
		if(this.posY<0) {
			this.posY=0;
			this.sound.play();
		}
	}
}


