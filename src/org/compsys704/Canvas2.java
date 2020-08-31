package org.compsys704;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Canvas2 extends JPanel {
	//BufferedImage arm1;
	//BufferedImage arm2;
	//BufferedImage p1;
	//BufferedImage p2;
	//BufferedImage loader;
	BufferedImage background;
	enum State {
		POS1, POS2, POS4, POS5, OUT, BEF
	}
	
	State previousState;
	int x, y;
	int xMax, yMax;
	int yDir;
	int xDir;
	
	public Canvas2(){
		try {
			background = ImageIO.read(new File("res/Background.PNG"));
			previousState = State.BEF;
			x = 0;
			y = 280;
			yMax = 280;
			xMax = 0;
			yDir = 1;
			xDir = 1;
		} catch (IOException e) {
			e.printStackTrace();
			//System.exit(1);;
		}
	}
	
	@Override
	protected void paintComponent(Graphics g){
		//try {
		super.paintComponent(g);
		//conveyor
		g.drawImage(background, 5, 5, null);
		
		
		
		g.setColor(Color.green);
		
		x++;
		y+=yDir;
		
		if(x > xMax) {
			x = xMax;
		}
		
		if(yDir > 0){
			if(y > yMax){
				y=yMax;
			}
		}else if(yDir < 0){
			if(y < yMax){
				y=yMax;
			}
		}
		
		
		g.fillOval(x, y, 30, 30);
		
//		if(previousState == State.BEF && States.bottleAtPos1) {
//			g.fillOval(75, 280, 30, 30);
//		}else if(previousState == State.POS2) {
//			g.fillOval(100, 190, 30, 30);
//		}else if(previousState == State.POS4) {
//			g.fillOval(315, 190, 30, 30);
//		}else if(previousState == State.POS5) {
//			g.fillOval(350, 280, 30, 30);
//		}else if(previousState == State.OUT) {
//			
//		}
		System.out.println(" x: " + x + " y: " + y);
		
		if(States.bottleAtPos1) {
			previousState = State.POS1;
			yMax = 280;
			xMax = 75;
			yDir = 0;
			xDir = 1;
		}else if(States.bottleAtPos2) {
			previousState = State.POS2;
			yMax = 190;
			xMax = 100;
			yDir = -1;
			xDir = 1;
		}else if(States.bottleAtPos4) {
			previousState = State.POS4;
			yMax = 190;
			xMax = 315;
			yDir = 0;
			xDir = 1;
		}else if(States.bottleAtPos5) {
			previousState = State.POS5;
			yMax = 280;
			xMax = 350;
			yDir = -1;
			xDir = 1;
		}else if(States.bottleLeftPos5) {
			previousState = State.OUT;
			yMax = 1000;
			xMax = 1000;
			yDir = 0;
			if(x == 1000) {
				xDir = 0;
				y = 280;
				x = 0;
				previousState = State.BEF;
			}
		}
		//}catch (InterruptedException e) {
		//	e.printStackTrace();
		//}
	}
}
