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

public class Canvas_Caploader extends JPanel {

	BufferedImage background;
		Canvas_Caploader(){
			try {
				background = ImageIO.read(new File("res/CapLoaderDetail.PNG"));
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
		}
}