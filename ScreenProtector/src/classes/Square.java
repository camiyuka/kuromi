package classes;

import java.awt.Color;

public class Square extends Rectangle {
	
	public Square(Color color, int posX, int posY, int size){
	super(color, posX, posY, size, size);
}
	@Override //Override sobreescreve o método do pai
	public void setWidth (int size) {
		super.setWidth(size);
		super.setHeight(size);
	}
	
	@Override
	public void setHeight (int size) {
		super.setWidth(size);
		super.setHeight(size);
	}
	
}