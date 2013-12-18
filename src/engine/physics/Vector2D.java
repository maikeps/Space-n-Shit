package engine.physics;

import engine.interfaces.Vector;

public class Vector2D implements Vector{

	private Component2D component;
		
	public Vector2D(double x, double y){
		component = new Component2D(x, y);
	}
	
	public Vector2D(Component2D start, Component2D end){
		double x = end.getX()-start.getX();
		double y = end.getY()-start.getY();
		component = new Component2D(x, y);
	}
	
	public Vector2D(){
		component = new Component2D(0, 0);
	}
	
	public Vector2D(Component2D component){
		this.component = component;
	}
	
	@Override
	public double module() {
		double x = component.getX();
		double y = component.getY();
		return Math.sqrt(x*x+y*y);
	}
	
	/*
	 * (non-Javadoc)
	 * @see physics.Vector#projection()
	 * returns the projection of this vector into the other
	 */
	@Override
	public Vector projection(Vector other) {
		//u = this
		//v = other
		//proj u->v = [(u.v)/(v.v)].v
		double numerator = dotProduct(other);
		double dividend = other.dotProduct(other);
		return other.multiply(numerator/dividend);
	}

	@Override
	public Vector add(Vector other) {
		component.setX(component.getX()+other.getComponent().getX());
		component.setY(component.getY()+other.getComponent().getY());
		return this;
	}

	@Override
	public Vector subtract(Vector other) {
		component.setX(component.getX()-other.getComponent().getX());
		component.setY(component.getY()-other.getComponent().getY());
		return this;
	}

	@Override
	public Vector multiply(double scalar) {
		component.setX(component.getX()*scalar);
		component.setY(component.getY()*scalar);
		return this;
	}

	@Override
	public double getAngleBetween(Vector other) {
		double cosTetha = dotProduct(other)/(module()*other.module());
		return Math.toDegrees(Math.acos(cosTetha));
	}
	
	@Override
	public double dotProduct(Vector other) {
		return (component.getX()*other.getComponent().getX() + component.getY()*other.getComponent().getY());
	}
	
	@Override
	public Component2D getComponent() {
		return component;
	}
	
}
