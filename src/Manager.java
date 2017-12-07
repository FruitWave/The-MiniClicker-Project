import java.awt.Graphics;
import java.util.ArrayList;

public class Manager {
	ArrayList<Objectal> objects;
	long enemyTimer = 0;
	int enemySpawnTime = 1;
	Drawr etch;

	public Manager(Drawr etch) {
		objects = new ArrayList<Objectal>();
		this.etch = etch;
	}

	public void addObject(Objectal o) {
		objects.add(o);
	}

	public void update() {

		for (int i = 0; i < objects.size(); i++) {
			Objectal o = objects.get(i);
			o.update();
		}
		// checkCollision();
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
}
