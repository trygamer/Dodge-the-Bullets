package the_game;

import java.awt.Graphics;
import java.util.Random;

public class The_moving_heart extends GameObjectDTB {

	The_moving_heart(int x, int y, int height, int width) {
		super(x, y, 10, 10);
		this.x = new Random().nextInt(DTB.width);

		this.y = new Random().nextInt(DTB.height);
		// TODO Auto-generated constructor stub
	}

	public void update() {
		super.update();
	}

	public void draw(Graphics g) {
		if (ObjectManangerDTB.vLives <= 5) {

			if (ObjectManangerDTB.tired == false) {
				x = new Random().nextInt(DTB.width);

				y = new Random().nextInt(DTB.height);

				ObjectManangerDTB.tired = true;
			}
		}
		g.drawImage(ObjectManangerDTB.vLiveImg, x, y, 10, 10, null);

	}

	public void resetposition(Graphics c) {

	}

}