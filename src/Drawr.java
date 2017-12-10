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
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.event.MouseInputListener;

import org.w3c.dom.events.EventTarget;
import org.w3c.dom.views.AbstractView;

@SuppressWarnings("serial")
public class Drawr extends JPanel implements ActionListener, KeyListener, MouseInputListener {
	Timer speed;
	Manager master;
	Font font;
	Font megafont;
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
	Cloud firstButton;
	boolean fbShown = false;
	static BufferedImage santahat;

	public Drawr() {
		speed = new Timer(1, this);
		font = new Font("Monaco", Font.PLAIN, 24);
		megafont = new Font("Monaco", Font.PLAIN, 48);
		try {
			santahat = ImageIO.read(this.getClass().getResourceAsStream("Santa's hat.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		if (!fbShown) {

			fbShown = true;
			firstButton = new Cloud(Commence.width / 2, Commence.height / 2, 200, 139, 1, this);
			master.addObject(firstButton);
		}
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
		master.manageEnemies();

	}

	void updateMenuState() {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_U) {
			// for (Objectal cloudly : master.objects) {
			// if (cloudly instanceof Cloud) {
			// if (((Cloud) cloudly).upgradable) {
			// ((Cloud) cloudly).upgrade();
			if (firstButton.upgradable) {
				firstButton.upgrade();
			}
			// }
			// }
			// }
		} else if (e.getKeyCode() == KeyEvent.VK_C) {
			// for (Objectal cloudly : master.objects) {
			// if (cloudly instanceof Cloud) {
			// ((Cloud) cloudly).clicksDone++;
			// }
			// }

			firstButton.clicksDone += 100;
			firstButton.clicksBank += 100;
		}
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
		System.out.println("oh.");
		if ((((e.getX() >= sgbLBx) && (e.getX() <= sgbHBx)) && ((e.getY() >= sgbHBy) && (e.getY() <= sgbLBy)))
				&& currentState == MENU_STATE) {
			System.out.println("START!");
			currentState = GAME_STATE;

		}
		master.drawrmx = e.getX();
		master.drawrmy = e.getY();
		master.drawrMousepoint = e.getPoint();
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mouseDragged(MouseEvent e) {

	}

	@Override
	public void mouseMoved(MouseEvent e) {

	}

}
