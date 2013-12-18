package vision;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import vision.interfaces.Drawable;

public class Animation implements Drawable{

	private Image image;
	
	public Animation(String ref){
		try {
			image = new Image(ref);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void draw(Graphics g) {
		image.draw();
	}

	@Override
	public Image getImage() {
		return image;
	}

}
