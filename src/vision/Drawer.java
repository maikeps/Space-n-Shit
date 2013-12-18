package vision;


import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

import engine.physics.Dimension2D;
import engine.physics.Position2D;

public class Drawer{
	
	public Position2D position;
	public Dimension2D dimension;
	
	public Drawer(Position2D position, Dimension2D dimension){
		this.position = position;
		this.dimension = dimension;
	}
	
	public void draw(GameContainer gc, StateBasedGame game, Graphics g){
		g.fillRect((int)position.getComponent().getX(), (int)position.getComponent().getY(), (int)dimension.getWidth(), (int)dimension.getHeight());
	}
}
