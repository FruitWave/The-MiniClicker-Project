import java.awt.Color;
import java.awt.Graphics;

public class Cloud extends Objectal {
	Drawr etch;
	final int level;
	final int pointsworth;
	static int levelcheckmarker = 1;
	int evolveLevelsAmbassador;
	static boolean upgradableOnce = false;
	static double levelUpNumRequirement = 10;
	Color dcolor;
	Color lvl1color = new Color(0, 255, 10);
	Color lvl2color = new Color(10, 10, 10);
	Color lvl3color = new Color(20, 10, 10);
	Color lvl4color = new Color(0, 0, 255);
	Color lvl5color = new Color(20, 20, 20);
	Color lvl6color = new Color(20, 20, 30);
	Color lvl7color = new Color(255, 0, 0);
	Color lvl8color = new Color(30, 40, 30);
	Color lvl9color = new Color(40, 40, 40);
	Color lvl10color = new Color(255, 255, 0);
	Color lvl11color = new Color(60, 80, 40);
	Color lvl12color = new Color(60, 80, 100);
	Color lvl13color = new Color(0, 255, 255);
	Color lvl14color = new Color(120, 140, 100);
	Color lvl15color = new Color(120, 140, 160);
	Color lvl16color = new Color(255, 0, 255);
	Color lvl17color = new Color(180, 200, 160);
	Color lvl18color = new Color(180, 200, 220);
	Color lvl19color = new Color(240, 200, 220);
	Color lvl20color = new Color(255, 255, 255);

	public Cloud(int x, int y, int width, int height, int number, Drawr etch) {
		super(x, y, width, height);
		evolveLevels(number);
		level = levelcheckmarker;
		evolveLevelsAmbassador = number;
		setCloudColor(level);
		this.etch = etch;
		pointsworth = level * 2;
	}

	@Override
	public void update() {
		super.update();
		evolveLevels(evolveLevelsAmbassador);
	}

	void evolveLevels(int numOfClouds) {
		if ((numOfClouds % levelUpNumRequirement == 0) && upgradableOnce) {
			upgradableOnce = false;
			levelcheckmarker++;
			levelUpNumRequirement = (int) levelUpNumRequirement * 1.5;
		}

	}

	public void setCloudColor(int lchkmrkr) {
		switch (lchkmrkr) {
		case 1:
			dcolor = lvl1color;
			break;
		case 2:
			dcolor = lvl2color;
			break;
		case 3:
			dcolor = lvl3color;
			break;
		case 4:
			dcolor = lvl4color;
			break;
		case 5:
			dcolor = lvl5color;
			break;
		case 6:
			dcolor = lvl6color;
			break;
		case 7:
			dcolor = lvl7color;
			break;
		case 8:
			dcolor = lvl8color;
			break;
		case 9:
			dcolor = lvl9color;
			break;
		case 10:
			dcolor = lvl10color;
			break;
		case 11:
			dcolor = lvl11color;
			break;
		case 12:
			dcolor = lvl12color;
			break;
		case 13:
			dcolor = lvl13color;
			break;
		case 14:
			dcolor = lvl14color;
			break;
		case 15:
			dcolor = lvl15color;
			break;
		case 16:
			dcolor = lvl16color;
			break;
		case 17:
			dcolor = lvl17color;
			break;
		case 18:
			dcolor = lvl18color;
			break;
		case 19:
			dcolor = lvl19color;
			break;
		case 20:
			dcolor = lvl20color;
			break;
		default:
			break;
		}
	}

	public void draw(Graphics g) {
		g.setColor(dcolor);
		g.fillRect(x, y, width, height);
		g.setColor(Color.BLACK);
		g.fillRect(5, 5, 1000, 120);
		g.setFont(etch.megafont);
		g.setColor(Color.WHITE);
		g.drawString("Level: " + level + "    Score: " + etch.master.score, 10, 100);
	}

}
