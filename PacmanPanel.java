package HomeWork1_4$5;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import javax.swing.JPanel;
import javax.swing.Timer;

import org.omg.Messaging.SyncScopeHelper;

import HomeWork1_1.DotList;

public class PacmanPanel extends JPanel implements ActionListener {
	private Pacman p;
	private Timer time;
	private DotList dots;
	private int width;
	private int height;
	private boolean toggle;
	public PacmanPanel(int width, int heigh) {
		super();
		this.width = width;
		this.height = heigh;
		setPreferredSize(new Dimension(width, heigh));
		p = new Pacman();
		dots = new DotList(width - (p.getDiameter()), heigh - (p.getDiameter()), 5, 20);
		time = new Timer(10, this);
		// time.start();
		addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if (!toggle)
					time.start();
				else
					time.stop();
				toggle = !toggle;
			}
		});
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		g2.setColor(Color.PINK);
		for (int i = 0; i < dots.getDots().size(); i++) {
			Ellipse2D.Double e = new Ellipse2D.Double(dots.getDots().get(i).getX() + (p.getDiameter() / 2),
					dots.getDots().get(i).getY() + (p.getDiameter() / 2), dots.getCurrent().getSize(),
					dots.getCurrent().getSize());
			if (dots.getDots().get(i).isVisible())
				g2.fill(e);
		}

		g2.setColor(Color.yellow);
		g2.fill(p.getPecman());
		g2.setColor(Color.blue);
		g2.draw(p.getPecman());
		g2.setColor(Color.black);
		g2.fill(p.getEyePecman());

		if (dots.isAllClear()) {
			Font font = new Font ("Tahoma", Font.BOLD , 40);
			FontMetrics titleMetrics = g2.getFontMetrics(font);
			int titleHeight = titleMetrics.getHeight();
			int titleWidth = titleMetrics.stringWidth("The End!");
			g2.setColor(Color.pink);
			g2.setFont(new Font ("Tahoma", Font.BOLD , 40));
			g2.drawString("The End!", (getWidth()-titleWidth)/2, (getHeight()+titleHeight-20)/2);
			g2.draw(new Rectangle((getWidth()-titleWidth)/2, (getHeight()-titleHeight)/2, titleWidth, titleHeight));
			g2.drawLine(getWidth()/2, 0, getWidth()/2, getHeight());
			g2.drawLine(0, getHeight()/2, getWidth(), getHeight()/2);
			repaint();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (dots.isAllClear()) {
			dots.resetDots();
		}
		if (p.getDirection() == 0 && p.getX() <= 0) {
			p.setDirection(2);
		} else if (p.getDirection() == 1 && p.getX() >= width - p.getDiameter()) {
			p.setDirection(3);
		} else if (p.getDirection() == 2 && p.getY() <= 0) {
			p.setDirection(1);
		} else if (p.getDirection() == 3 && p.getY() >= height - p.getDiameter()) {
			p.setDirection(0);
		}
		if (dots.getCurrent().getX() == p.getX() && dots.getCurrent().getY() == p.getY()) {
			if (!dots.isAllClear()) {
				dots.clearCurrent();
			}
			if (dots.isAllClear()) {
				if (e.getSource() instanceof Timer)
					((Timer) e.getSource()).stop();
			}
		}
		p.move();
		repaint();
	}
}
