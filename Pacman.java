package HomeWork1_4$5;

import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;

public class Pacman {
	private int diameter;
	private int x;
	private int y;
	private int eyeX;
	private int eyeY;
	private int startAngle;
	private int arcAngle;
	private int direction;
	private int eyeSize;
	public static final int LEFT = 0;
	public static final int RIGHT = 1;
	public static final int UP = 2;
	public static final int DOWN = 3;
	private final int MAX_ANGLE = 30;
	private final int CHANGE_ANGLE = 90;
	private boolean isOpan;

	public Pacman() {
		this(30);
	}

	public Pacman(int radiuus) {
		this(radiuus * 2, 0, 0, 1);
	}

	public Pacman(int diameter, int x, int y, int direction) {
		// Arc2D.Double(x,y,diameter,diameter,30,300,Arc2D.PIE);
		this.diameter = diameter;
		this.x = x;
		this.y = y;
		this.direction = direction;
		arcAngle = 300;
		eyeSize = diameter/12;
		if (this.direction == RIGHT) {
			eyeX = x + (diameter / 2);
			eyeY = y + (diameter / 2) - (eyeSize * 2);

			startAngle = 30;
		} else if (this.direction == DOWN) {
			eyeX = x + (diameter / 2) + eyeSize;
			eyeY = y + (diameter / 2);

			startAngle = 300;
		} else if (this.direction == LEFT) {
			eyeX = x + (diameter / 2) - eyeSize;
			eyeY = y + (diameter / 2) - (eyeSize * 2);

			startAngle = 210;
		} else if (this.direction == UP) {
			eyeX = x + (diameter / 2) + eyeSize;
			eyeY = y + (diameter / 2) - eyeSize;

			startAngle = 120;
		}
	}

	public int getDiameter() {
		return diameter;
	}

	public void setDiameter(int diameter) {
		this.diameter = diameter;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getEyeX() {
		return eyeX;
	}

	public int getEyeY() {
		return eyeY;
	}

	public int getEyeSize() {
		return eyeSize;
	}

	public int getStartAngle() {
		return startAngle;
	}

	public int getEndAngle() {
		return arcAngle;
	}

	public void move() {
		move(1);
	}

	public void move(int range) {
		int cout = 0;
		if (this.direction == RIGHT) {
			x += range;
			eyeX += range;
			cout = 0;
		} else if (this.direction == DOWN) {
			y += range;
			eyeY += range;
			cout = 3;
		} else if (this.direction == LEFT) {
			x -= range;
			eyeX -= range;
			cout = 2;
		} else if (this.direction == UP) {
			y -= range;
			eyeY -= range;
			cout = 1;
		}
		if (isOpan) {
			startAngle ++;
			arcAngle -= 2;
			if (startAngle > (CHANGE_ANGLE * cout) + MAX_ANGLE && arcAngle < 300)
				isOpan = false;
		} else {
			startAngle --;
			arcAngle += 2;
			if (startAngle < CHANGE_ANGLE * cout && arcAngle > 360)                                      
				isOpan = true;
		}
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
		if (this.direction == RIGHT) {
			eyeX = x + (diameter / 2);
			eyeY = y + (diameter / 2) - (eyeSize * 2);                                          

			startAngle = 30;
		} else if (this.direction == DOWN) {
			eyeX = x + (diameter / 2) + eyeSize;
			eyeY = y + (diameter / 2);

			startAngle = 300;
		} else if (this.direction == LEFT) {
			eyeX = x + (diameter / 2) - eyeSize;
			eyeY = y + (diameter / 2) - (eyeSize * 2);

			startAngle = 210;
		} else if (this.direction == UP) {
			eyeX = x + (diameter / 2) + eyeSize;
			eyeY = y + (diameter / 2) - eyeSize;

			startAngle = 120;
		}
		arcAngle = 300;
	}

	public Arc2D.Double getPecman() {
		return new Arc2D.Double(x, y, diameter, diameter, startAngle, arcAngle, Arc2D.PIE);
	}

	public Ellipse2D.Double getEyePecman() {
		return new Ellipse2D.Double(eyeX, eyeY, eyeSize, eyeSize);
	}
}
