package HomeWork1_4$5;

public class Dot {
	private int x;
	private int y;
	private int size;
	private boolean visible;

	public Dot(int x, int y, int size) {
		this.x = x;
		this.y = y;
		this.size = size;
		visible = true;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getSize() {
		return size;
	}
}
