package com.empmanagement;

import javax.swing.*;
import java.awt.*;
import java.lang.*;
import java.awt.event.*;


public class Splash extends JFrame implements ActionListener{
	
	Splash(){
		
		getContentPane().setBackground(Color.white); //awt method used to set background color
		setLayout(null);//To not used default swing layout
		//ADDING TEXT
		JLabel heading = new JLabel("Employee Management System");
		heading.setBounds(80,30,1200,100);// sets the boundary for the label(heading)
		heading.setFont(new Font("serif",Font.BOLD,60));//set the font by font type , font , size
		heading.setForeground(Color.yellow);
		add(heading);
		//ADDING IMAGE
		
		ImageIcon i1 = new ImageIcon(getClass().getResource("icons/front.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
		ImageIcon i3= new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(50,100,1050,500);
		add(image);
		//Adding Buttons
		
		JButton clicktocontinue = new JButton("Click here to continue");
		clicktocontinue.setBounds(400,400,300,70);
		clicktocontinue.setBackground(Color.black);
		clicktocontinue.setForeground(Color.red);
		clicktocontinue.addActionListener(this);
		image.add(clicktocontinue);
		
		
		setSize(1170,650); // Sets the size of window frame
		setLocation(200,50); // Distance from left size and from top side
		setVisible(true); // is the window visible?
		
		//Blinking Text
		
		while(true) {
			heading.setVisible(false);
			try {
				Thread.sleep(500);
			}catch(Exception e) {}
			
			heading.setVisible(true);
			try {
				Thread.sleep(500);
			}catch(Exception e) {}
			
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Splash();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
		new Login();
		
		
	}

}

