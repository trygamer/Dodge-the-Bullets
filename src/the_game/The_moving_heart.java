package the_game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class The_moving_heart extends GameObjectDTB {
static Graphics g;
static int x =new Random().nextInt(DTB.width);
	
	static int y = new Random().nextInt(DTB.height);
	
	
	public The_moving_heart() {
		super(x, y,10,10);
		// TODO Auto-generated constructor stub
	}


public void update() {
	super.update();
}


	

	


public void draw( Graphics g){
	if(ObjectManangerDTB.vLives<=5) {
		
		if(ObjectManangerDTB.tired == false) {
	 x =new Random().nextInt(DTB.width);
		
		 y = new Random().nextInt(DTB.height);
	g.drawImage(ObjectManangerDTB.vLiveImg, x, y, 10, 10, null);
		}
	}
	g.setColor(Color.RED);
	g.drawRect(collisionBox.x, collisionBox.y, collisionBox.width, collisionBox.height);

}










public void resetposition(Graphics c) {


	
}

}