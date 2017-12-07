import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class Manager {
	ArrayList<Objectal> objects;
	long enemyTimer = 0;
	int enemySpawnTime = 1;
	int numclouds = 0;
	Drawr etch;
	int mousex;
	int mousey;
	int drawrmx;
	int drawrmy;
	public Point drawrMousepoint;
	public static int score;

	public Manager(Drawr etch) {
		objects = new ArrayList<Objectal>();
		this.etch = etch;
	}

	public void addObject(Objectal o) {
		objects.add(o);
	}

	public void update() {
		mousex = drawrmx;
		mousey = drawrmy;
		// System.out.println("Mousepoint: " + drawrMousepoint);
		for (int i = 0; i < objects.size(); i++) {
			Objectal o = objects.get(i);
			o.update();
		}
		checkCollision();
		purgeObjects();
	}

	public void draw(Graphics g) {
		for (int i = 0; i < objects.size(); i++) {
			Objectal o = objects.get(i);
			o.draw(g);
		}
	}

	private void purgeObjects() {
		for (int i = 0; i < objects.size(); i++) {
			if (!objects.get(i).isAlive) {
				objects.remove(i);
			}
		}
	}

	public void manageEnemies() {
		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			Cloud.upgradableOnce = true;
			numclouds++;
			addObject(new Cloud(new Random().nextInt(Commence.width), new Random().nextInt(Commence.height), 100, 100,
					numclouds, etch));
			enemyTimer = System.currentTimeMillis();
		}
	}

	public void checkCollision() {
		for (int i = 0; i < objects.size(); i++) {
			// for (int j = i + 1; j < objects.size(); j++) {
			Objectal o1 = objects.get(i);
			// Objectal o2 = objects.get(j);
			if (o1 instanceof Cloud) {
				if (o1.collisionArea.contains(drawrMousepoint)) {
					System.out.println(score);
					score++;
					mousex = -1000;
					mousey = -1000;
					o1.isAlive = false;
				}
			}

			// if (o1.collisionArea.intersects(o2.collisionArea)) {
			//
			// }
			// }
		}
	}

}
