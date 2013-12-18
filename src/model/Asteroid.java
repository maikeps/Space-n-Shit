package model;

import model.interfaces.Movable;
import model.interfaces.Splittable;
import engine.GameObject;
import engine.interfaces.Vector;
import engine.physics.Dimension2D;
import engine.physics.Position2D;

public class Asteroid extends GameObject implements Movable, Splittable{

	public Asteroid(Position2D position, Dimension2D dimension, float speed, Game game) {
		super(position, dimension, speed, game);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void split() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move(Vector direction) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
