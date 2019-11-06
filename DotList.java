package HomeWork1_4$5;

import java.util.ArrayList;

public class DotList {
	private ArrayList<Dot> dots;
	private int width;
	private int height;
	private int current = 0;
	private boolean allClear;

	public DotList(int width, int height, int dotSize, int distance) {
		super();
		dots = new ArrayList<Dot>();
		this.width = width;
		this.height = height;
		genDots(dotSize, distance);
		allClear = false;
	}

	public void genDots(int dotSize, int distance) {
		int x = 0, y = 0;
		while (x < width) {
			dots.add(new Dot(x, y, dotSize));
			x += distance;
		}
		if (x != width) {
			y += x-width;
			x = width;
		}

		while (y < height) {
			dots.add(new Dot(x, y, dotSize));
			y += distance;
		}
		if (y != height) {
			x -= y-height;
			y = height;
		}

		while (x > 0) {
			dots.add(new Dot(x, y, dotSize));
			x -= distance;
		}
		if (x != 0) {
			y += x;
			x = 0;
		}

		while (y > 0) {
			dots.add(new Dot(x, y, dotSize));
			y -= distance;
		}
		if (y != 0) {
			dots.remove(dots.size() - 1);
		}
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public ArrayList<Dot> getDots() {
		return dots;
	}

	public Dot getCurrent() {
		return dots.get(current);
	}

	public void clearCurrent() {
		dots.get(current++).setVisible(false);
		if (current >= dots.size()) {
			current = 0;
			allClear = true;
		}
	}

	public boolean isAllClear() {
		return allClear;
	}

	public void resetDots() {
		for (int i = 0; i < dots.size(); i++) {
			dots.get(i).setVisible(true);
		}
		current = 0;
		allClear = false;
	}
}
