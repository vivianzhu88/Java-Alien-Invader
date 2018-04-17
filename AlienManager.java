package alienInvader;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class AlienManager {

	
	private static Alien[] aliens = new Alien[20];
	private static Image[] images, imagesAlt;
	
	
	static {
		images = new Image[3];
		images[0] = new ImageIcon(Coordinator.R_PATH + "blueAlien_1.png").getImage();
		images[1] = new ImageIcon(Coordinator.R_PATH + "greenAlien_1.png").getImage();
		images[2] = new ImageIcon(Coordinator.R_PATH + "orangeAlien_1.png").getImage();
		
		imagesAlt = new Image[3];
		imagesAlt[0] = new ImageIcon(Coordinator.R_PATH + "blueAlien_2.png").getImage();
		imagesAlt[1] = new ImageIcon(Coordinator.R_PATH + "greenAlien_2.png").getImage();
		imagesAlt[2] = new ImageIcon(Coordinator.R_PATH + "orangeAlien_2.png").getImage();
	}
	
	
	public static void create(Ship target){
		if(Math.random()>0.1) return;
		
		for(int i=0; i<aliens.length; i++){
			if(aliens[i]==null){
				int x = (int)(Math.random()*801);
				int y = 0;
				int vx = (int)(Math.random()*11) - 5;
				int vy = (int)(Math.random()*5) + 3;
				//Color bodyColor = new Color((int)(Math.random()*200), (int)(Math.random()*200), (int)(Math.random()*200));
				//int grayScale = (int)(Math.random()*150);
				//Color eyeColor = new Color(grayScale, grayScale, grayScale);
				int rand = (int)(Math.random()*images.length);
				
				double rand2 = Math.random();
				
				if(rand2>5.0/6) aliens[i] = new RealNastyAlien(x, y, vx, vy, images[rand], imagesAlt[rand], target);
				else if(rand2>4.0/6) aliens[i] = new CloningAlien(x, y, vx, vy, images[rand], imagesAlt[rand], target);
				else if(rand2>3.0/6) aliens[i] = new CloakAlien(x, y, vx, vy, images[rand], imagesAlt[rand], target);
				else if(rand2>2.0/6) aliens[i] = new NastyAlien(x, y, vx, vy, images[rand], imagesAlt[rand], target);
				else if(rand2>1.0/6) aliens[i] = new MultiShootAlien(x, y, vx, vy, images[rand], imagesAlt[rand], target);
				else aliens[i] = new SimpleAlien(x, y, vx, vy, images[rand], imagesAlt[rand], target);
				
				break;
			}
		}
	}
	
	
	public static void add(Alien alien){
		for(int i=0; i<aliens.length; i++){
			if(aliens[i]==null){
				aliens[i] = alien;
				return;
			}
		}
	}
	
	
	public static void remove(Alien alien){
		for(int i=0; i<aliens.length; i++){
			if(aliens[i]==alien) aliens[i] = null;
		}
	}
	
	
	public static void move(){
		for(int i=0; i<aliens.length; i++){
			if(aliens[i]!=null) aliens[i].move();
		}
	}
	
	
	public static void draw(Graphics canvas){
		for(int i=0; i<aliens.length; i++){
			if(aliens[i]!=null) aliens[i].draw(canvas);
		}
	}
	
	
	public static boolean isHit(Torpedo torpedo){
		for(int i=0; i<aliens.length; i++){
			if(aliens[i]!=null && aliens[i].isHit(torpedo)) return true;
		}
		return false;
	}
	
} 













