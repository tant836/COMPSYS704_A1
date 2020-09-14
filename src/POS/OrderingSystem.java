package POS;

import javax.swing.JFrame;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

import org.compsys704.LoaderVizWorker;
import org.compsys704.Ports;
import org.compsys704.SignalClient;
import org.compsys704.SignalServer;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class OrderingSystem extends JFrame {
	public OrderingSystem() {
		
		JButton btnNewButton = new JButton("Place Order");

		getContentPane().add(btnNewButton, BorderLayout.SOUTH);
		
		JLabel title = new JLabel("POS");
		this.add(title);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		
		ButtonGroup G1 = new ButtonGroup(); 
		
		JLabel lblNewLabel = new JLabel("Select liquid: ");
		panel.add(lblNewLabel);
		
		JCheckBox rdbtnNewRadioButton_1 = new JCheckBox("Liquid 1");
		panel.add(rdbtnNewRadioButton_1);
		
		JCheckBox rdbtnNewRadioButton_2 = new JCheckBox("Liquid 2");
		panel.add(rdbtnNewRadioButton_2);
		
		JCheckBox rdbtnNewRadioButton_3 = new JCheckBox("Liquid 3");
		panel.add(rdbtnNewRadioButton_3);
		
		JCheckBox rdbtnNewRadioButton = new JCheckBox("Liquid 4");
		panel.add(rdbtnNewRadioButton);
		
//		G1.add(rdbtnNewRadioButton_1);
//		G1.add(rdbtnNewRadioButton_2);
//		G1.add(rdbtnNewRadioButton_3);
//		G1.add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1.doClick();
		
		btnNewButton.addActionListener(new ActionListener() {
            // Anonymous class. 
  
            public void actionPerformed(ActionEvent e) 
            { 
                // Override Method 
            	System.out.println("Begin");
                // Declaration of String class Objects. 
                String qual = " "; 
  
                // If condition to check if jRadioButton2 is selected. 
                
                if(!rdbtnNewRadioButton.isSelected() && !rdbtnNewRadioButton_1.isSelected() && !rdbtnNewRadioButton_2.isSelected() && !rdbtnNewRadioButton_3.isSelected()) {
                	JOptionPane.showMessageDialog(OrderingSystem.this, "No liquids selected. \n Order was not made"); 
                }else {
                	// MessageDialog to show information selected radion buttons. 
                    JOptionPane.showMessageDialog(OrderingSystem.this, "Order made: \n" + qual); 
                    ActionListener al = new SignalClient(Ports.PORT_LOADER_CONTROLLER, Ports.PLACE_ORDER);
                	al.actionPerformed(null);
                	if (rdbtnNewRadioButton_1.isSelected()) { 
                    	ActionListener al1 = new SignalClient(Ports.PORT_LOADER_CONTROLLER, Ports.LIQUID_1);
                    	al1.actionPerformed(null);
                        qual = "Liquid 1"; 
                        System.out.println("Liq1 sent");
                    } 
                    if (rdbtnNewRadioButton_2.isSelected()) { 
                    	ActionListener al2 = new SignalClient(Ports.PORT_LOADER_CONTROLLER, Ports.LIQUID_2);
                    	al2.actionPerformed(null);
                        qual = "Liquid 2";
                        System.out.println("Liq2 sent");
                    }
                    if (rdbtnNewRadioButton_3.isSelected()) { 
                    	ActionListener al3 = new SignalClient(Ports.PORT_LOADER_CONTROLLER, Ports.LIQUID_3);
                    	al3.actionPerformed(null);
                        qual = "Liquid 3";
                        System.out.println("Liq3 sent");
                    } 
                    if (rdbtnNewRadioButton.isSelected()) { 
                    	ActionListener al4 = new SignalClient(Ports.PORT_LOADER_CONTROLLER, Ports.LIQUID_4);
                    	al4.actionPerformed(null);
                        qual = "Liquid 4"; 
                        System.out.println("Liq4 sent");
                    }
                    
                }
                
                
                
            }
        });
		
		this.setTitle("Ordering System");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		OrderingSystem oS = new OrderingSystem();
		oS.pack();
		oS.setVisible(true);
		System.out.println("Begin");
		SignalServer<LoaderVizWorker> server = new SignalServer<LoaderVizWorker>(Ports.PORT_POS, LoaderVizWorker.class);
		new Thread(server).start();
		while(true){
			try {
				oS.repaint();
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
