package the_game;

import java.util.ArrayList;
import java.util.Random;





public class ObjectMananger {
	long enemyTimer=0;
	int enemySpawnTime=1000;
	
	
	ArrayList<Bullets> b = new ArrayList<Bullets>();
	
	public void addBullets(Bullets AN1) {
		b.add(AN1);
		
	}
	
	public void manageEnemies(){
        if(System.currentTimeMillis() - enemyTimer >= enemySpawnTime){
                addBullets(new Bullets(new Random().nextInt(DTB.width), 0, 50, 50));

enemyTimer = System.currentTimeMillis();
        }
	
	
}
}
