package vision;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import vision.interfaces.Drawable;
import engine.interfaces.Position;

public class StaticImage implements Drawable{

	private Image image;
	private Position position;
	
	public StaticImage(String ref, Position position){
		try {
			image = new Image(ref);
		} catch (SlickException e) {
			e.printStackTrace();
		}
		this.position = position;
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawImage(image, (float)position.getComponent().getX(), (float)position.getComponent().getY());
	}

	public Image getImage(){
		return image;
	}
}
