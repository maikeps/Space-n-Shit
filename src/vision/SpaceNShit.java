package vision;

import java.util.ArrayList;
import java.util.List;

import model.Game;
import model.PlayerShip;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import engine.GameObject;
import engine.physics.Dimension2D;
import engine.physics.Position2D;
import engine.physics.Vector2D;

public class SpaceNShit extends BasicGameState{

	public static final int ID = 1;
	
	public Game spaceShooterGame;
	public List<Drawer> drawers;
	
	@Override
	public void init(GameContainer gc, StateBasedGame game)
			throws SlickException {
		this.spaceShooterGame = new Game(new Dimension2D(gc.getWidth(), gc.getHeight()));
		updateDrawers();
	}

	@Override
	public void render(GameContainer gc, StateBasedGame game, Graphics g)
			throws SlickException {
		for(Drawer drawer : drawers){
			drawer.draw(gc, game, g);
		}
	}

	@Override
	public void update(GameContainer gc, StateBasedGame game, int delta)
			throws SlickException {
		getInput(gc);
		this.spaceShooterGame.update();
		updateDrawers();
	}

	private void updateDrawers() {
		drawers = new ArrayList<Drawer>();
		for(GameObject gameObject : spaceShooterGame.getGameObjects()){
			drawers.add(new Drawer((Position2D)gameObject.getPosition(), (Dimension2D)gameObject.getDimension()));
		}
	}
	
	public void getInput(GameContainer gc){
		Input input = gc.getInput();
		PlayerShip player = spaceShooterGame.getPlayer();

		if(input.isKeyDown(input.KEY_LEFT)){
			player.move(new Vector2D(-player.getSpeed(), 0));
		}else if(input.isKeyDown(input.KEY_RIGHT)){
			player.move(new Vector2D(player.getSpeed(), 0));
		}
		
		if(input.isKeyDown(input.KEY_SPACE)){
			player.shoot();
		}
	}

	@Override
	public int getID() {
		return ID;
	}
}
