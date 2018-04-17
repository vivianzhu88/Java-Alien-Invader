package alienInvader;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.net.SocketOption;

import resources.DrawingBoard;
import resources.SoundPlayer;

public class Coordinator {

	public static boolean gameOn = true;
	public static int score;
	public static final int SCREEN_WIDTH;
	public static final String R_PATH = "jrJava/alienInvader5_polymorphism/";
	
	static {
		SCREEN_WIDTH = 2*2*200;
	}
	
	
	public static void main(String[] args) {
		
		DrawingBoard board = new DrawingBoard(200, 0, SCREEN_WIDTH, 750);
		Graphics canvas = board.getCanvas();
		
		Ship ship = new Ship(400, 590);
		
		board.addKeyListener(ship); 
		board.addMouseMotionListener(ship); 
		
		board.setBackgroundImage(R_PATH + "bg.png"); 
		SoundPlayer bgSound = new SoundPlayer(R_PATH + "bgMusic.wav");
		bgSound.playLoop();
		
		Font font = new Font("Arial", Font.BOLD, 12);
		canvas.setFont(font); 
		
		while(gameOn){
			AlienManager.create(ship);
			AlienManager.move();
			TorpedoManager.move();
			MissileManager.move();
			
			board.clear();
			ship.draw(canvas);
			AlienManager.draw(canvas);
			TorpedoManager.draw(canvas);
			MissileManager.draw(canvas);
			
			canvas.setColor(Color.white); 
			canvas.drawString("score: " + score, 10, 20);
			
			board.repaint(); 
			
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) { }  
		
		}
	
		bgSound.stop();
	}

}




