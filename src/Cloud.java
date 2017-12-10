import java.awt.Color;
import java.awt.Graphics;

public class Cloud extends Objectal {
	Drawr etch;
	int level;
	double clicksDone = 0.0;
	double pointsworth;
	double clicksRequired;
	int pointsEarned;
	double clicksTotalNeededToUpgrade;
	int proposedLevel;
	boolean upgradable;
	double clicksBank;
	Color dcolor;
	Color lvl1color = Color.CYAN;
	Color lvl2color = Color.BLUE;
	Color lvl3color = Color.MAGENTA;
	Color lvl4color = Color.BLACK;
	Color lvl5color = Color.GREEN;
	Color lvl6color = Color.ORANGE;
	Color lvl7color = Color.YELLOW;
	Color lvl8color = Color.LIGHT_GRAY;
	Color lvl9color = Color.DARK_GRAY;
	Color lvl10color = Color.yellow;
	Color lvl11color = Color.red;
	Color lvl12color = Color.pink;
	Color lvl13color = Color.orange;
	Color lvl14color = Color.lightGray;
	Color lvl15color = Color.darkGray;
	Color lvl16color = Color.CYAN;
	Color lvl17color = Color.blue;
	Color lvl18color = Color.green;
	Color lvl19color = Color.magenta;
	Color lvl20color = Color.white;

	public Cloud(int x, int y, int width, int height, int number, Drawr etch) {
		super(x, y, width, height);
		clicksBank = 0.0;
		level = 1;
		pointsEarned = number;
		this.etch = etch;
		pointsworth = setPointsWorth(level);
		clicksTotalNeededToUpgrade = setClicksRequiredToUprade(level);
		upgradable = false;
	}

	@Override
	public void update() {
		super.update();
		setCloudColor(level);
		pointsworth = setPointsWorth(level);
		clicksTotalNeededToUpgrade = setClicksRequiredToUprade(level);
		if (clicksBank - clicksTotalNeededToUpgrade >= 0) {
			System.out.println("UPGRADABLE");
			upgradable = true;
		}

	}

	void upgrade(/* int numOfClouds */) {
		// if ((numOfClouds % levelUpNumRequirement == 0) && upgradableOnce) {
		// upgradableOnce = false;
		// levelcheckmarker++;
		// levelUpNumRequirement = (int) levelUpNumRequirement * 1.5;
		// }
		upgradable = false;
		clicksBank -= clicksTotalNeededToUpgrade;
		level++;

	}

	private double setPointsWorth(int levelly) {
		switch (levelly) {
		case 1:
			return 1;

		case 2:
			return 5;

		case 3:
			return 10;

		case 4:
			return 50;

		case 5:
			return 100;

		case 6:
			return 200;

		case 7:
			return 500;

		case 8:
			return 2000;

		case 9:
			return 5000;

		case 10:
			return 10000;

		case 11:
			return 50000;

		case 12:
			return 200000;

		case 13:
			return 750000;

		case 14:
			return 2000000;

		case 15:
			return 50000000;

		case 16:
			return 1000000000;

		case 17:
			return 25000000000.0;

		case 18:
			return 500000000000.0;

		case 19:
			return 1000000000000.0;

		case 20:
			return 5000000000000000.0;

		default:
			Error tgle = new Error("\n Level is greater than 20. It is: " + level);
			tgle.printStackTrace();
			break;
		}
		return 0;
	}

	private double setClicksRequiredToUprade(int levelly) {
		switch (levelly) {
		case 1:
			return 10;

		case 2:
			return 100;

		case 3:
			return 500;

		case 4:
			return 1000;

		case 5:
			return 10000;

		case 6:
			return 500000;

		case 7:
			return 2000000;

		case 8:
			return 50000000;

		case 9:
			return 1500000000;

		case 10:
			return 500000000000.0;

		case 11:
			return 5500000000000.0;

		case 12:
			return 100000000000000.0;

		case 13:
			return 5000000000000000.0;

		case 14:
			return 15000000000000000.0;

		case 15:
			return 55000000000000000.0;

		case 16:
			return 955000000000000000.0;

		case 17:
			return 5555000000000000000.0;

		case 18:
			return 5555000000000000000.0;
		// 5 septillion

		case 19:
			return 999555000000000000000.0;

		case 20:
			return 999555999000000000000000.0;

		default:
			Error tgle = new Error("\n Level is greater than 20. It is: " + level);
			tgle.printStackTrace();
			break;
		}
		return 0;
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
			Error tgle = new Error("\n Level is greater than 20. It is: " + level);
			tgle.printStackTrace();
			break;
		}
	}

	public void draw(Graphics g) {
		g.setColor(dcolor);
		g.fillRect(x, y, width, height);
		g.setColor(Color.BLACK);
		g.fillRect(5, 5, 2000, 240);
		g.setFont(etch.megafont);
		g.setColor(Color.WHITE);
		g.drawString("Level: " + level + "    Clicks: " + clicksDone + "    Bank: " + clicksBank, 10, 100);
		g.drawString("Upgradable: " + upgradable + "    Clicks To Next Upgrade: "
				+ (clicksTotalNeededToUpgrade - clicksBank), 10, 200);
	}

}
