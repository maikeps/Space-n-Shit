package engine.physics;

import engine.interfaces.Position;
import engine.interfaces.Vector;

public class Position2D implements Position{

	private Component2D component;
	
	public Position2D(double x, double y){
		component = new Component2D(x, y);
	}
	
	public Position2D(Component2D component){
		this.component = component;
	}
	
	@Override
	public void applyVector(Vector vector) {
		component.setX(component.getX()+vector.getComponent().getX());
		component.setY(component.getY()+vector.getComponent().getY());
	}

	public Component2D getComponent() {
		return component;
	}
	
	@Override
	public boolean isEquals(Position other) {
		return (component.getX() == other.getComponent().getX() && component.getY() == other.getComponent().getY());
	}
	
	public Position clone(){
		return new Position2D(component.getX(), component.getY());
	}

	@Override
	public String toString(){
		return "["+getComponent().getX()+", "+getComponent().getY()+"]";
	}
}
