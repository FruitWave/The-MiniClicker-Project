import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Drawr extends JPanel implements ActionListener, KeyListener {

	Timer speed;
	static int currentState = 0;
	final static int MENU_STATE = 0;
	final static int GAME_STATE = 1;
	final static int END_STATE = 2;

	Drawr() {
		speed = new Timer(1000 / 150, this);
	}

	public static void startGame() {
		speed.start();
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	private void updateEndState() {

	}

	private void updateGameState() {

	}

	private void updateMenuState() {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		System.out.println("action performed");
		if (currentState == MENU_STATE) {
			updateMenuState();
		} else if (currentState == GAME_STATE) {
			updateGameState();
		} else if (currentState == END_STATE) {
			updateEndState();
		} /*
			 * else if (currentState == INSTRUCTIONS_STATE) { updateInfoState(); }
			 */
	}
}
