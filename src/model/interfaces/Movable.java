package model.interfaces;

import engine.interfaces.Vector;

public interface Movable {
	public void move(Vector direction);
	public boolean isGoingLeft();
	public boolean isGoingRight();
	public boolean isGoingUp();
	public boolean isGoingDown();
}
