package HomeWork1_4$5;

import javax.swing.JFrame;

public class PacmanPanelTest {

	public static void main(String[] args) {
		JFrame f = new JFrame("Dot Panel");
		PacmanPanel p = new PacmanPanel(600,600);
		f.add(p);
		f.pack();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);

	}

}
