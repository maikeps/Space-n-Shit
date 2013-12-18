package engine.physics;

import org.newdawn.slick.geom.Rectangle;

import engine.interfaces.BoundingBox;
import engine.interfaces.Dimension;
import engine.interfaces.Position;

public class BoundingBox2D implements BoundingBox{

	public Position position;
	public Dimension dimension;
	
	public BoundingBox2D(double x, double y, double width, double height){
		position = new Position2D(x, y);
		dimension = new Dimension2D(width, height);
	}
	
	public BoundingBox2D(Position position, Dimension dimension){
		this.position = position;
		this.dimension = dimension;
	}
	
	@Override
	public boolean collide(BoundingBox other) {
		return (!(position.getComponent().getX()+dimension.getWidth() < other.getPosition().getComponent().getX() ||
				  position.getComponent().getX() > other.getPosition().getComponent().getX()+other.getDimension().getWidth() ||
				  position.getComponent().getY()+dimension.getHeight() < other.getPosition().getComponent().getY() ||
				  position.getComponent().getY() > other.getPosition().getComponent().getY()+other.getDimension().getHeight()));
	}

	@Override
	public boolean collideFromAbove(BoundingBox other) {
		
		return false;
	}

	@Override
	public boolean collideFromBottom(BoundingBox other) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean collideFromLeft(BoundingBox other) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean collideFromRight(BoundingBox other) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Dimension getDimension() {
		return dimension;
	}

	@Override
	public Position getPosition() {
		return position;
	}
}
