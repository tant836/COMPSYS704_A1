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

public class Canvas_Filler extends JPanel {

	BufferedImage background;
		Canvas_Filler(){
			try {
				background = ImageIO.read(new File("res/FillerDetail.PNG"));
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
			if(States.bottleAtPos2) {
				g.setColor(Color.green);
			}else {
				g.setColor(Color.red);
			}
			g.fillOval(113, 323, 15, 15);
			
			if(States.dosUnitEvac) {
				g.setColor(Color.green);
			}else {
				g.setColor(Color.red);
			}
			g.fillOval(3, 413, 15, 15);
			
			if(States.dosUnitFilled) {
				g.setColor(Color.green);
			}else {
				g.setColor(Color.red);
			}
			g.fillOval(153, 413, 15, 15);
			
			if(States.valveInjectorOnOff) {
				g.setColor(Color.green);
			}else {
				g.setColor(Color.red);
			}
			g.fillOval(113, 63, 15, 15);
			
			if(States.valveInletOnOff) {
				g.setColor(Color.green);
			}else {
				g.setColor(Color.red);
			}
			g.fillOval(113, 183, 15, 15);
			
			if(States.dosUnitValveRetract) {
				g.setColor(Color.green);
			}else {
				g.setColor(Color.red);
			}
			g.fillOval(3, 383, 15, 15);
			
			if(States.dosUnitValveExtend) {
				g.setColor(Color.green);
			}else {
				g.setColor(Color.red);
			}
			g.fillOval(153, 383, 15, 15);
			
			//Liquid type
			g.setColor(Color.black);
			g.setFont( new Font(Font.SANS_SERIF, Font.BOLD,  14));
			
			if(States.noz1) {
				g.drawString("Liquid 1", 7, 33);
			}
			g.setColor(Color.black);
			g.setFont( new Font(Font.SANS_SERIF, Font.BOLD,  14));
			
			if(States.noz2) {
				g.drawString("Liquid 2", 7, 33);
			}
			
			
			g.setColor(Color.black);
			g.setFont( new Font(Font.SANS_SERIF, Font.BOLD,  14));
			
			if(States.noz3) {
				g.drawString("Liquid 3", 7, 33);
			}
			
			g.setColor(Color.black);
			g.setFont( new Font(Font.SANS_SERIF, Font.BOLD,  14));
			
			if(States.noz4) {
				g.drawString("Liquid 4", 7, 33);
			}
			
		}
}
