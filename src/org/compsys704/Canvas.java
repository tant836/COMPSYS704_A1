package org.compsys704;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
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
	BufferedImage CapLoader;
	
	public Canvas(){
		try {
			Conveyor = ImageIO.read(new File("res/Conveyor.PNG"));
			RotaryTable = ImageIO.read(new File("res/RotaryTable.PNG"));
			Capper = ImageIO.read(new File("res/Capper.PNG"));
			Filler = ImageIO.read(new File("res/Filler.PNG"));
			CapLoader = ImageIO.read(new File("res/CapLoader.PNG"));
		} catch (IOException e) {
			e.printStackTrace();
			//System.exit(1);;
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
		if(States.bottleAtPos4) {
			g.setColor(Color.green);
		}else {
			g.setColor(Color.red);
		}
		g.fillOval(35, 370, 15, 15);
		
		if(States.gripperZAxisLowered) {
			g.setColor(Color.green);
		}else {
			g.setColor(Color.red);
		}
		g.fillOval(35, 400, 15, 15);
		
		if(States.gripperZAxisLifted) {
			g.setColor(Color.green);
		}else {
			g.setColor(Color.red);
		}
		g.fillOval(35, 430, 15, 15);
		
		if(States.gripperTurnHomePos) {
			g.setColor(Color.green);
		}else {
			g.setColor(Color.red);
		}
		g.fillOval(35, 460, 15, 15);
		
		if(States.gripperTurnFinalPos) {
			g.setColor(Color.green);
		}else {
			g.setColor(Color.red);
		}
		g.fillOval(35, 490, 15, 15);
		
		if(States.cylPos5ZaxisExtend) {
			g.setColor(Color.green);
		}else {
			g.setColor(Color.red);
		}
		g.fillOval(438, 370, 15, 15);
		
		if(States.gripperTurnRetract) {
			g.setColor(Color.green);
		}else {
			g.setColor(Color.red);
		}
		g.fillOval(438, 400, 15, 15);
		
		if(States.gripperTurnExtend) {
			g.setColor(Color.green);
		}else {
			g.setColor(Color.red);
		}
		g.fillOval(438, 430, 15, 15);
		
		if(States.capGripperPos5Extend) {
			g.setColor(Color.green);
		}else {
			g.setColor(Color.red);
		}
		g.fillOval(438, 460, 15, 15);
		
		if(States.cylClampBottleExtend) {
			g.setColor(Color.green);
		}else {
			g.setColor(Color.red);
		}
		g.fillOval(438, 490, 15, 15);
		
		//Filler
		g.drawImage(Filler, 50, 550, null);
		if(States.bottleAtPos2) {
			g.setColor(Color.green);
		}else {
			g.setColor(Color.red);
		}
		g.fillOval(40, 587, 15, 15);
		
		if(States.dosUnitEvac) {
			g.setColor(Color.green);
		}else {
			g.setColor(Color.red);
		}
		g.fillOval(40, 615, 15, 15);
		
		if(States.dosUnitFilled) {
			g.setColor(Color.green);
		}else {
			g.setColor(Color.red);
		}
		g.fillOval(40, 647, 15, 15);
		
		if(States.valveInjectorOnOff) {
			g.setColor(Color.green);
		}else {
			g.setColor(Color.red);
		}
		g.fillOval(439, 573, 15, 15);
		
		if(States.valveInletOnOff) {
			g.setColor(Color.green);
		}else {
			g.setColor(Color.red);
		}
		g.fillOval(439, 600, 15, 15);
		
		if(States.dosUnitValveRetract) {
			g.setColor(Color.green);
		}else {
			g.setColor(Color.red);
		}
		g.fillOval(439, 630, 15, 15);
		
		if(States.dosUnitValveExtend) {
			g.setColor(Color.green);
		}else {
			g.setColor(Color.red);
		}
		g.fillOval(439, 660, 15, 15);
		
		//Liquid type
		g.setColor(Color.black);
		g.setFont( new Font(Font.SANS_SERIF, Font.BOLD,  14));
		g.drawString("Liquid 1: ", 60, 720);
		if(States.noz1) {
			g.setColor(Color.green);
		}else {
			g.setColor(Color.red);
		}
		g.fillOval(120, 707, 15, 15);
		
		g.setColor(Color.black);
		g.setFont( new Font(Font.SANS_SERIF, Font.BOLD,  14));
		g.drawString("Liquid 2:", 160, 720);
		if(States.noz2) {
			g.setColor(Color.green);
		}else {
			g.setColor(Color.red);
		}
		g.fillOval(220, 707, 15, 15);
		
		g.setColor(Color.black);
		g.setFont( new Font(Font.SANS_SERIF, Font.BOLD,  14));
		g.drawString("Liquid 3: ", 260, 720);
		if(States.noz3) {
			g.setColor(Color.green);
		}else {
			g.setColor(Color.red);
		}
		g.fillOval(320, 707, 15, 15);
		
		g.setColor(Color.black);
		g.setFont( new Font(Font.SANS_SERIF, Font.BOLD,  14));
		g.drawString("Liquid 4:", 360, 720);
		if(States.noz4) {
			g.setColor(Color.green);
		}else {
			g.setColor(Color.red);
		}
		g.fillOval(420, 707, 15, 15);
		
		//CapLoader
		g.drawImage(CapLoader, 550, 460, null);
		if(States.PUSHER_RETRACTED) {
			g.setColor(Color.green);
		}else {
			g.setColor(Color.red);
		}
		g.fillOval(537, 478, 15, 15);
		if(States.PUSHER_EXTENDED) {
			g.setColor(Color.green);
		}else {
			g.setColor(Color.red);
		}
		g.fillOval(537, 508, 15, 15);
		if(States.GRIPPED) {
			g.setColor(Color.green);
		}else {
			g.setColor(Color.red);
		}
		g.fillOval(537, 538, 15, 15);
		if(States.ARM_AT_SOURCE) {
			g.setColor(Color.green);
		}else {
			g.setColor(Color.red);
		}
		g.fillOval(537, 568, 15, 15);
		if(States.ARM_AT_DEST) {
			g.setColor(Color.green);
		}else {
			g.setColor(Color.red);
		}
		g.fillOval(537, 598, 15, 15);
		if(States.MAG_EMPTY) {
			g.setColor(Color.green);
		}else {
			g.setColor(Color.red);
		}
		g.fillOval(537, 628, 15, 15);
		if(States.bottleAtPos3) {
			g.setColor(Color.green);
		}else {
			g.setColor(Color.red);
		}
		g.fillOval(537, 658, 15, 15);
		
		if(States.pusherExtend) {
			g.setColor(Color.green);
		}else {
			g.setColor(Color.red);
		}
		g.fillOval(947, 478, 15, 15);
		if(States.vacOn) {
			g.setColor(Color.green);
		}else {
			g.setColor(Color.red);
		}
		g.fillOval(947, 527, 15, 15);
		if(States.armSource) {
			g.setColor(Color.green);
		}else {
			g.setColor(Color.red);
		}
		g.fillOval(947, 553, 15, 15);
		if(States.armDest) {
			g.setColor(Color.green);
		}else {
			g.setColor(Color.red);
		}
		g.fillOval(947, 610, 15, 15);
		
	}
}
