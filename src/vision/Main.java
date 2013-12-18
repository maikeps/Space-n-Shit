package vision;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Main extends StateBasedGame{
	
	public Main(String title) {
		super(title);
	}

	public static void main(String[] args){
		try {
			AppGameContainer app = new AppGameContainer(new Main("Space 'n Shit"));
			app.setDisplayMode(800, 600, false);
			app.setTargetFrameRate(60);
			app.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initStatesList(GameContainer arg0) throws SlickException {
		addState(new SpaceNShit());
	}
}
