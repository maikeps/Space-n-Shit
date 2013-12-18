package model;

import model.interfaces.Movable;
import model.interfaces.Splittable;
import engine.GameObject;
import engine.interfaces.Vector;
import engine.physics.Dimension2D;
import engine.physics.Position2D;
import engine.physics.Vector2D;

public class Asteroid extends GameObject implements Movable, Splittable{

	private Vector direction;
	
	public Asteroid(Position2D position, Dimension2D dimension, float speed, Game game) {
		super(position, dimension, speed, game);
		direction = new Vector2D(0, 0);
	}

	@Override
	public void split() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move(Vector direction) {
		this.direction = direction;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isGoingLeft() {
		return direction.getComponent().getX() < 0;
	}

	@Override
	public boolean isGoingRight() {
		return direction.getComponent().getX() > 0;
	}

	@Override
	public boolean isGoingUp() {
		return direction.getComponent().getY() < 0;
	}

	@Override
	public boolean isGoingDown() {
		return direction.getComponent().getY() > 0;
	}
}
