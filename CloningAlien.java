package alienInvader;

import java.awt.Image;

public class CloningAlien extends SimpleAlien {

	protected int distance;
	protected int requiredDistance;
	protected boolean hasCloned;
	
	
	public CloningAlien(int x, int y, int vx, int vy, Image image, Image imageAlt, Ship target){
		super(x, y, vx, vy, image, imageAlt, target);
		
		requiredDistance = (int)(100 + 201*Math.random());
	}
	
	
	public void move(){ 
		x += vx;
		y += vy;
		distance += vy;
		
		if(distance>requiredDistance && !hasCloned){
			hasCloned = true;
			AlienManager.add(new CloningAlien(x, y, -vx, vy, image, imageAlt, target));
		}
		
		if(y>720) AlienManager.remove(this); 
		
		if(x<0+width/2 || x>800-width/2) vx *= -1;
		
		shootMissile();
	
		isCollided = target.isHit(this);
	}
	
	
}










