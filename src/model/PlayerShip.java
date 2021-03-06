package model;

import model.interfaces.Diable;
import model.interfaces.Movable;
import model.interfaces.Shootable;
import engine.GameObject;
import engine.interfaces.Vector;
import engine.physics.Dimension2D;
import engine.physics.Position2D;
import engine.physics.Vector2D;

public class PlayerShip extends GameObject implements Movable, Shootable, Diable{
	
	private int hp;
	private boolean isDead;
	private int gunCooldown;
	private int gunBaseCooldown;
	private Vector direction;
	
	public PlayerShip(Position2D position, Dimension2D dimension, float speed, Game game, int hp) {
		super(position, dimension, speed, game);
		this.hp = hp;
		gunBaseCooldown = 10;
		direction = new Vector2D(0, 0);
	}

	@Override
	public void update() {
		gunCooldown--;
	}

	@Override
	public void shoot() {
		if(gunCooldown <= 0){
			Bullet bullet = new Bullet((Position2D) position.clone(), new Dimension2D(5, 20), 25, 10, game, this);
			bullet.setDirection(new Vector2D(0, -bullet.getSpeed()));
			game.addBullet(bullet);
			resetCooldown();
		}
	}

	@Override
	public void resetCooldown() {
		gunCooldown = gunBaseCooldown;
	}

	@Override
	public void move(Vector direction) {
		this.direction = direction; 
		position.applyVector(direction);
	}

	@Override
	public void loseHp(int amount) {
		hp -= amount;
		if(hp <= 0){
			isDead = true;
		}
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
