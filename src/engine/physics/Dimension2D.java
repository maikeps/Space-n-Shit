package engine.physics;

import engine.interfaces.Dimension;

public class Dimension2D implements Dimension{

	private double width;
	private double height;
	
	public Dimension2D(double width, double height){
		this.width = width;
		this.height = height;
	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}
	
	@Override
	public String toString(){
		return "["+width+", "+height+"]";
	}
}
