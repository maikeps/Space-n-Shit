package engine;

import model.Game;
import engine.interfaces.BoundingBox;
import engine.interfaces.Dimension;
import engine.interfaces.Position;
import engine.interfaces.Vector;
import engine.physics.BoundingBox2D;
import engine.physics.Dimension2D;
import engine.physics.Position2D;

public abstract class GameObject {
	
	protected BoundingBox boundingBox;
	protected float speed;
	protected Position position;
	protected Dimension dimension;
	public Game game;
	
	public GameObject(Position2D position, Dimension2D dimension, float speed, Game game){
		this.position = position;
		this.dimension = dimension;
		this.speed = speed;
		this.game = game;
		this.boundingBox = new BoundingBox2D(position, dimension);
	}
	
	public abstract void update();
	
	public BoundingBox getBoundingBox() {
		return boundingBox;
	}

	public float getSpeed() {
		return speed;
	}

	public Position getPosition() {
		return position;
	}

	public Dimension getDimension() {
		return dimension;
	}

	public void setBoundingBox(BoundingBox boundingBox) {
		this.boundingBox = boundingBox;
	}
}
