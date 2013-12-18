package engine.interfaces;

public interface Position {

	public void applyVector(Vector vector);
	public Component getComponent();
	public boolean isEquals(Position other);
	public Position clone();
}
