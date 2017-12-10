import java.awt.Graphics;
import java.awt.Rectangle;

public class Objectal {
	int x;
	int y;
	int width;
	int height;
	boolean isAlive = true;
	Rectangle collisionArea = new Rectangle(x, y, width, height);

	public Objectal(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public void update() {
		collisionArea.setBounds(x, y, width, height);
	}

	public void draw(Graphics g) {

	}

}
