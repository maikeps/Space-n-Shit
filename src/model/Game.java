package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.interfaces.Playable;
import engine.GameObject;
import engine.physics.BoundingBox2D;
import engine.physics.Dimension2D;
import engine.physics.Position2D;

public class Game implements Playable{

	private PlayerShip player;
	private List<EnemyShip> enemies;
	private List<Bullet> bullets;
	private List<Asteroid> asteroids;
	
	public Dimension2D screenDimension;
	
	public Game(Dimension2D screenDimension){
		this.screenDimension = screenDimension;
		initialize();
	}

	private void initialize() {
		enemies = new ArrayList<EnemyShip>();
		bullets = new ArrayList<Bullet>();
		asteroids = new ArrayList<Asteroid>();
		
		Dimension2D playerDimension = new Dimension2D(20, 50);
		Position2D playerPosition = new Position2D(screenDimension.getWidth()/2-playerDimension.getWidth()/2, screenDimension.getHeight()*90/100-playerDimension.getHeight()/2);
		float playerVelocity = 10;
		createPlayer(playerPosition, playerDimension, playerVelocity);
		
		createEnemies();
	}

	private void createEnemies() {
		Dimension2D enemyDimension = new Dimension2D(20, 50);
		float enemyVelocity = 2.5f;
		Random random = new Random();
		for(int i = 0; i < random.nextInt(50)+50; i++){
			int x = (random.nextInt((int)(screenDimension.getWidth()-enemyDimension.getWidth()-5))+5);
			int y = -(random.nextInt((int)(25*screenDimension.getHeight())));
			Position2D enemyPosition = new Position2D(x, y);
			EnemyShip enemy = new EnemyShip(enemyPosition, enemyDimension, enemyVelocity, this, 25);
			enemies.add(enemy);
		}
	}

	@Override
	public void update() {
		player.update();
		for(EnemyShip enemy : enemies){
			if(enemy.getBoundingBox().collide(new BoundingBox2D(new Position2D(0, 0), screenDimension))){
				enemy.canShoot = true;
			}
			enemy.update();
		}
		for(Bullet bullet : bullets){
			bullet.update();
		}
		for(Asteroid asteroid : asteroids){
			asteroid.update();
		}
		
		handleCollisions();
		removeDeadShips();
	}
	
	private void removeDeadShips() {
		for(int i = 0; i < enemies.size(); i++){
			if(enemies.get(i).isDead){
				enemies.remove(i);
			}
		}
	}

	private void handleCollisions() {
		for(int i = 0; i < bullets.size(); i++){
			Bullet bullet = bullets.get(i);
			boolean bulletHit = false;
			if(bullet.getShooter() == player){
				for(Asteroid asteroid : asteroids){
					if(bullet.getBoundingBox().collide(asteroid.getBoundingBox())){
						asteroid.split();
						bulletHit = true;
					}
				}
			
				for(EnemyShip enemy : enemies){
					if(bullet.getBoundingBox().collide(enemy.getBoundingBox())){
						enemy.loseHp(bullet.getDamage());
						bulletHit = true;
					}
				}
			}else{
				if(bullet.getBoundingBox().collide(player.getBoundingBox())){
					player.loseHp(bullet.getDamage());
					bulletHit = true;
				}
			}
			if(bulletHit || !bullet.getBoundingBox().collide(new BoundingBox2D(new Position2D(0, 0), screenDimension))){
				bullets.remove(i);
				bulletHit = false;
			}
		}
	}

	private void createPlayer(Position2D playerPosition, Dimension2D playerDimension, float playerVelocity) {
		player = new PlayerShip(playerPosition, playerDimension, playerVelocity, this, 500);
	}

	public void addBullet(Bullet bullet) {
		bullets.add(bullet);
	}
	
	public ArrayList<GameObject> getGameObjects(){
		ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();
		
		gameObjects.add(player);
		gameObjects.addAll(enemies);
		gameObjects.addAll(bullets);
		gameObjects.addAll(asteroids);
		
		return gameObjects;
	}
	
	public PlayerShip getPlayer(){
		return player;
	}
}
