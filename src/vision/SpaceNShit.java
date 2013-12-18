package vision;

import model.Game;
import model.PlayerShip;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import engine.interfaces.Vector;
import engine.physics.Dimension2D;
import engine.physics.Vector2D;

public class SpaceNShit extends BasicGameState{

	public static final int ID = 1;
	
	public Game spaceShooterGame;
	public Drawer drawer;
	
	@Override
	public void init(GameContainer gc, StateBasedGame game)
			throws SlickException {
		this.spaceShooterGame = new Game(new Dimension2D(gc.getWidth(), gc.getHeight()));
		drawer = new Drawer();
	}

	@Override
	public void render(GameContainer gc, StateBasedGame game, Graphics g)
			throws SlickException {
		drawer.draw(g);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame game, int delta)
			throws SlickException {
		getInput(gc);
		this.spaceShooterGame.update();
		drawer.updateImages(spaceShooterGame.getGameObjects());
	}
	
	public void getInput(GameContainer gc){
		Input input = gc.getInput();
		PlayerShip player = spaceShooterGame.getPlayer();

		Vector direction = new Vector2D(0, 0);
		if(input.isKeyDown(input.KEY_LEFT)){
			direction = new Vector2D(-player.getSpeed(), 0);
		}else if(input.isKeyDown(input.KEY_RIGHT)){
			direction = new Vector2D(player.getSpeed(), 0);
		}
		player.move(direction);
		
		if(input.isKeyDown(input.KEY_SPACE)){
			player.shoot();
		}
	}

	@Override
	public int getID() {
		return ID;
	}
}
