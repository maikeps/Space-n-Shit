package engine.interfaces;

import engine.physics.Component2D;

public interface Vector {
	public double module();
	public Vector projection(Vector other);
	public Vector add(Vector other);
	public Vector subtract(Vector other);
	public Vector multiply(double scalar);
	public double getAngleBetween(Vector other);
	public double dotProduct(Vector other);
	public Component2D getComponent();
}
