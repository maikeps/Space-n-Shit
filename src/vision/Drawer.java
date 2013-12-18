package vision;

import java.util.ArrayList;
import java.util.List;

import model.Bullet;
import model.EnemyShip;
import model.PlayerShip;

import org.newdawn.slick.Graphics;

import vision.interfaces.Drawable;
import engine.GameObject;
import engine.physics.BoundingBox2D;
import engine.physics.Dimension2D;



public class Drawer{
	
	public List<Drawable> drawableList;
	
	public Drawer(){
		drawableList = new ArrayList<Drawable>();
	}
	
	public void updateImages(ArrayList<GameObject> objects){
		drawableList.clear();
		for(GameObject gameObject : objects){
			String ref = "res/spaceship.png";
			if(gameObject instanceof PlayerShip){
				ref = "res/spaceship.png";
				if(((PlayerShip) gameObject).isGoingLeft()){
					ref = "res/spaceship_left.png";
				}else if(((PlayerShip) gameObject).isGoingRight()){
					ref = "res/spaceship_right.png";
				}	
			}else if(gameObject instanceof EnemyShip){
				ref = "res/enemyship.png";
			}else if(gameObject instanceof Bullet){
				ref = "res/bullet.png";
			}
			drawableList.add(new StaticImage(ref, gameObject.getPosition()));
			
			gameObject.setBoundingBox(new BoundingBox2D(gameObject.getPosition(), new Dimension2D(drawableList.get(drawableList.size()-1).getImage().getWidth(), drawableList.get(drawableList.size()-1).getImage().getHeight())));
		}
	}
	
	public void draw(Graphics g){
		for(Drawable drawable : drawableList){
			drawable.draw(g);
		}
	}
}
