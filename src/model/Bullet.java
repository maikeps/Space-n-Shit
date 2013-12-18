package model;

import model.interfaces.Movable;
import model.interfaces.Shootable;
import engine.GameObject;
import engine.interfaces.Vector;
import engine.physics.Dimension2D;
import engine.physics.Position2D;
import engine.physics.Vector2D;

public class Bullet extends GameObject implements Movable{

	private Vector2D direction;
	private Shootable shooter;
	private int damage;
	
	public Bullet(Position2D position, Dimension2D dimension, float speed, int damage, Game game, Shootable shooter) {
		super(position, dimension, speed, game);
		this.shooter = shooter;
		direction = new Vector2D(0, 0);
		this.damage = damage;
	}

	@Override
	public void move(Vector direction) {
		position.applyVector(direction);
	}

	@Override
	public void update() {
		move(direction);
	}

	public void setDirection(Vector2D direction) {
		this.direction = direction;
	}

	public Shootable getShooter() {
		return shooter;
	}

	public int getDamage() {
		return damage;
	}
}
