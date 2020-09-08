package org.compsys704;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;

public class CapLoader extends JFrame {
	private JPanel panel;
	private JPanel panel2;
	
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
		
		JPanel ss = new JPanel();
		ss.add(enable);
		ss.add(remBottle);
		ss.add(put_bottle);
		
		
		JTabbedPane tabbedPane = new JTabbedPane();

		tabbedPane.addTab("tab1", panel);
		
		panel2 = new Canvas2();
		panel2.setPreferredSize(new Dimension(500, 800));
		panel2.setBackground(Color.WHITE);
		
		tabbedPane.addTab("tab2", panel2);
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		this.add(tabbedPane,c);
		
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
