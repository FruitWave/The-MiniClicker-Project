import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Commence {

	JFrame frame;
	static final int width = 1920;
	static final int height = 1080;
	Drawr etch;

	// constructor
	public Commence() {
		frame = new JFrame();
		etch = new Drawr();

		setup();
	}

	public static void main(String[] args) {
		Commence christmas = new Commence();
	}

	void setup() {
		frame.add(etch);
		frame.setTitle("MiniClicker");
		frame.addKeyListener(etch);
		frame.setSize(width, height);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		etch.startGame();
		frame.addMouseListener(etch);
	}
}
