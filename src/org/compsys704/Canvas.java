package org.compsys704;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Canvas extends JPanel {
	//BufferedImage arm1;
	//BufferedImage arm2;
	//BufferedImage p1;
	//BufferedImage p2;
	//BufferedImage loader;
	BufferedImage Conveyor;
	BufferedImage RotaryTable;
	BufferedImage Capper;
	BufferedImage Filler;
	
	public Canvas(){
		try {
			Conveyor = ImageIO.read(new File("res/Conveyor.PNG"));
			RotaryTable = ImageIO.read(new File("res/RotaryTable.PNG"));
			Capper = ImageIO.read(new File("res/Capper.PNG"));
			Filler = ImageIO.read(new File("res/Filler.PNG"));
//			arm1 = bi.getSubimage(0, 0, 64, 256);
//			arm2 = bi.getSubimage(71, 0, 48, 256);
//			loader = ImageIO.read(new File("res/loader.png"));
//			bi = ImageIO.read(new File("res/pusher.png"));
//			p1 = bi.getSubimage(0, 0, 238, 68);
//			p2 = bi.getSubimage(238, 0, 172, 68);
//			cap = ImageIO.read(new File("res/cap.png"));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);;
		}
	}
	
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		//conveyor
		g.drawImage(Conveyor, 45, 20, null);
		if(States.bottleAtPos1) {
			g.setColor(Color.green);
		}else {
			g.setColor(Color.red);
		}
		g.fillOval(35, 50, 15, 15);
		
		if(States.bottleLeftPos5) {
			g.setColor(Color.green);
		}else {
			g.setColor(Color.red);
		}
		g.fillOval(35, 90, 15, 15);
		
		if(States.motConveyorOn) {
			g.setColor(Color.green);
		}else {
			g.setColor(Color.red);
		}
		g.fillOval(440, 70, 15, 15);
		
		//RotaryTable
		g.drawImage(RotaryTable, 23, 150, null);
		if(States.tableAlignedWithSensor) {
			g.setColor(Color.green);
		}else {
			g.setColor(Color.red);
		}
		g.fillOval(15, 175, 15, 15);
		
		if(States.bottleAtPos5) {
			g.setColor(Color.green);
		}else {
			g.setColor(Color.red);
		}
		g.fillOval(35, 235, 15, 15);
		
		if(States.capsonBottleAtPos1) {
			g.setColor(Color.green);
		}else {
			g.setColor(Color.red);
		}
		g.fillOval(35, 295, 15, 15);
		
		if(States.rotaryTableTrigger) {
			g.setColor(Color.green);
		}else {
			g.setColor(Color.red);
		}
		g.fillOval(440, 235, 15, 15);
		
		//Capper
		g.drawImage(Capper, 44, 350, null);
		
		//Filler
		g.drawImage(Filler, 50, 550, null);
	}
}
