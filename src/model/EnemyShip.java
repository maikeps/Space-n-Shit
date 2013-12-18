package model;

import java.util.Random;

import model.interfaces.Movable;
import model.interfaces.Shootable;
import engine.GameObject;
import engine.interfaces.Vector;
import engine.physics.Dimension2D;
import engine.physics.Position2D;
import engine.physics.Vector2D;

public class EnemyShip extends GameObject implements Movable, Shootable, Diable{

	private Position2D positionToStop;
	private int hp;
	public boolean isDead;
	public boolean canShoot;
	private int gunCooldown;
	private int gunBaseCooldown;

	public EnemyShip(Position2D position, Dimension2D dimension, float speed, Game game, int hp) {
		super(position, dimension, speed, game);
		this.hp = hp;
		gunBaseCooldown = 20;
		Random random = new Random();
		positionToStop = new Position2D(position.getComponent().getX(), random.nextInt((int)game.screenDimension.getHeight()*70/100));
	}

	@Override
	public void update() {
		move(new Vector2D(0, speed));
		shoot();
		gunCooldown--;
	}

	@Override
	public void shoot() {
		if(gunCooldown <= 0 && canShoot){
			Bullet bullet = new Bullet((Position2D) position.clone(), new Dimension2D(5, 20), 25, 10, game, this);
			bullet.setDirection(new Vector2D(0, bullet.getSpeed()));
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
		if(position.getComponent().getY() < positionToStop.getComponent().getY()){
			position.applyVector(direction);
		}
	}

	@Override
	public void loseHp(int amount) {
		hp -= amount;
		if(hp <= 0){
			isDead = true;
		}
	}
	
	public int getHp(){
		return hp;
	}
}
