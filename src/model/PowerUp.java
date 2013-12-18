package model;

import model.interfaces.Pickable;
import engine.GameObject;
import engine.physics.Dimension2D;
import engine.physics.Position2D;

public class PowerUp extends GameObject implements Pickable{

	public PowerUp(Position2D position, Dimension2D dimension, float speed, Game game) {
		super(position, dimension, speed, game);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void applyEffect(GameObject gameObject) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}
