package engine.interfaces;

public interface BoundingBox {
	public boolean collide(BoundingBox other);
	public boolean collideFromAbove(BoundingBox other);
	public boolean collideFromBottom(BoundingBox other);
	public boolean collideFromLeft(BoundingBox other);
	public boolean collideFromRight(BoundingBox other);
	public Dimension getDimension();
	public Position getPosition();
}
