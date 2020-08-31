package org.compsys704;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class CapLoader extends JFrame {
	private JPanel panel;
	
	public CapLoader() {
		panel = new Canvas();
		panel.setPreferredSize(new Dimension(500, 800));
		panel.setBackground(Color.WHITE);
		JButton enable = new JButton("Enable");
		enable.addActionListener(new SignalClient(Ports.PORT_LOADER_PLANT, Ports.ENABLE_SIGNAL));
		JButton remBottle = new JButton("Remove bottle");
		remBottle.addActionListener(new SignalClient(Ports.PORT_LOADER_PLANT, Ports.REMOVE_BOTTLE_SIGNAL));
		JButton put_bottle = new JButton("Put bottle");
		put_bottle.addActionListener(new SignalClient(Ports.PORT_LOADER_PLANT, Ports.PLACE_BOTTLE_SIGNAL));
		JButton put_5 = new JButton("Put pos 5");
		put_bottle.addActionListener(new SignalClient(Ports.PORT_LOADER_PLANT, Ports.PUT_BOTTLE_POS_5_SIGNAL));
		
		JPanel ss = new JPanel();
		ss.add(enable);
		ss.add(remBottle);
		ss.add(put_bottle);
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		this.add(panel,c);
		c.gridx = 0;
		c.gridy = 1;
		this.add(ss,c);

		this.setTitle("Cap Loader");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		System.out.println("Started");
	}

	public static void main(String[] args) {
		CapLoader cl = new CapLoader();
		cl.pack();
		cl.setVisible(true);
		System.out.println("Begin");
		SignalServer<LoaderVizWorker> server = new SignalServer<LoaderVizWorker>(Ports.PORT_LOADER_VIZ, LoaderVizWorker.class);
		new Thread(server).start();
		while(true){
			try {
				cl.repaint();
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
