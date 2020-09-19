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

import org.compsys704.Canvas2.State;

public class Canvas_Rotary extends JPanel {

	BufferedImage background;
		Canvas_Rotary(){
			try {
				background = ImageIO.read(new File("res/RotaryDetail.PNG"));
			} catch (IOException e) {
				e.printStackTrace();
				//System.exit(1);;
			}
		}
		
		@Override
		protected void paintComponent(Graphics g){
			//try {
			super.paintComponent(g);
			g.drawImage(background, 0, 0,null);
			if(States.bottleAtPos1) {
				g.setColor(Color.green);
			}else {
				g.setColor(Color.red);
			}
			g.fillOval(112, 183, 15, 15);
			if(States.bottleAtPos2) {
				g.setColor(Color.green);
			}else {
				g.setColor(Color.red);
			}
			g.fillOval(142, 103, 15, 15);
			if(States.bottleAtPos3) {
				g.setColor(Color.green);
			}else {
				g.setColor(Color.red);
			}
			g.fillOval(232, 62, 15, 15);
			if(States.bottleAtPos4) {
				g.setColor(Color.green);
			}else {
				g.setColor(Color.red);
			}
			g.fillOval(322, 103, 15, 15);
			if(States.bottleAtPos5) {
				g.setColor(Color.green);
			}else {
				g.setColor(Color.red);
			}
			g.fillOval(352, 183, 15, 15);
			if(States.rotaryTableTrigger) {
				g.setColor(Color.green);
			}else {
				g.setColor(Color.red);
			}
			g.fillOval(232, 183, 15, 15);
			if(States.tableAlignedWithSensor) {
				g.setColor(Color.green);
			}else {
				g.setColor(Color.red);
			}
			g.fillOval(77, 289, 15, 15);
			if(States.capsonBottleAtPos1) {
				g.setColor(Color.green);
			}else {
				g.setColor(Color.red);
			}
			g.fillOval(252, 289, 15, 15);
			if(States.bottleLeftPos5) {
				g.setColor(Color.green);
			}else {
				g.setColor(Color.red);
			}
			g.fillOval(77, 314, 15, 15);
			if(States.motConveyorOn) {
				g.setColor(Color.green);
			}else {
				g.setColor(Color.red);
			}
			g.fillOval(252, 314, 15, 15);
		}
}
