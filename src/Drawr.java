import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Drawr extends JPanel implements ActionListener, KeyListener, MouseListener {
	Timer speed;
	Manager master;
	Font font;
	Font font2;
	Font font3;
	final static int MENU_STATE = 0;
	final static int GAME_STATE = 1;
	final static int END_STATE = 2;
	static int currentState = MENU_STATE;
	boolean drawOnce = false;
	int sgbLBx = (Commence.width / 5);
	int sgbHBx = (Commence.width / 5) + 200;
	int sgbHBy = Commence.height * 2 / 3;
	int sgbLBy = (Commence.height * 2 / 3) + 40;
	// JButton butn;

	public Drawr() {
		speed = new Timer(1000 / 150, this);
		font = new Font("Monaco", Font.PLAIN, 24);
		// butn = new JButton();
		// butn.setBounds((Commence.width / 5), Commence.height * 2 / 3, 200, 40);
		// butn.setVisible(true);
		// this.add(butn);
	}

	public void startGame() {
		speed.start();
		master = new Manager(this);
	}

	void drawGameState(Graphics connect) {
		master.draw(connect);
	}

	void drawMenuState(Graphics connect) {
		setBackground(Color.darkGray);
		int startx = (Commence.width / 5);
		int starty = (Commence.height / 3) - (Commence.height / 5) + (Commence.height / 8);
		connect.setFont(font);
		connect.setColor(Color.cyan);
		connect.drawString("mini clicker", startx, starty);
		connect.drawString("click start", startx,
				(Commence.height / 5) + (Commence.height / 12) + (Commence.height / 8));
		connect.setColor(Color.green);
		connect.drawRect(startx, Commence.height * 2 / 3, 200, 40);
		connect.drawString("START", startx + 68, (Commence.height * 2 / 3) + 29);
		/* startbutton.setBounds(startx, Commence.height * 2 / 3, 200, 40); */

	}

	void drawEndState(Graphics connect) {

	}

	void updateEndState() {

	}

	void updateGameState() {
		master.update();
	}

	void updateMenuState() {

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

	private void fullRestart() {
		currentState = MENU_STATE;
		// reset all variables
		startGame();
	}

	protected void paintComponent(Graphics delta) {
		if (currentState == MENU_STATE) {
			drawMenuState(delta);
		} else if (currentState == GAME_STATE) {
			drawGameState(delta);
		} else if (currentState == END_STATE) {
			drawEndState(delta);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/*
		 * if (e.getSource() == startbutton) { System.out.println("Start!"); } else {
		 */
		repaint();
		if (currentState == MENU_STATE) {
			updateMenuState();
		} else if (currentState == GAME_STATE) {
			updateGameState();
		} else if (currentState == END_STATE) {
			updateEndState();
			/* } */
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("oh.");
		// TODO Auto-generated method stub
		if (((e.getXOnScreen() >= sgbLBx) && (e.getXOnScreen() <= sgbHBx))
				&& ((e.getYOnScreen() >= sgbHBy) && (e.getYOnScreen() <= sgbLBy))) {
			System.out.println("START!");
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
