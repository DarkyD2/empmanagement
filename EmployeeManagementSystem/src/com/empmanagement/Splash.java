package com.empmanagement;

import javax.swing.*;
import java.awt.*;
import java.lang.*;
import java.awt.event.*;


public class Splash extends JFrame implements ActionListener{
	JLabel heading;
	JButton Login,Register;
	Splash(){
		
		getContentPane().setBackground(Color.white); //awt method used to set background color
		setLayout(null);//To not used default swing layout
		//ADDING TEXT
		heading = new JLabel("Employee Management System");
		heading.setBounds(200,0,1200,100);// sets the boundary for the label(heading)
		heading.setFont(new Font("serif",Font.BOLD,60));//set the font by font type , font , size
		heading.setForeground(Color.black);
		add(heading);
		//ADDING IMAGE
		
		ImageIcon i1 = new ImageIcon(getClass().getResource("icons/splashpage.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1170, 650, Image.SCALE_DEFAULT);
		ImageIcon i3= new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,1170,650);
		add(image);
		//Adding Buttons	
		
		Login = new JButton("Login");
		Login.setBounds(900,120,150,70);
		Login.setFont(new Font("Roboto",Font.BOLD,20));
//		Login.setBackground(Color.black);
//		Login.setForeground(Color.red);
		Login.addActionListener(this);
		image.add(Login);
		
		Register = new JButton("Register");
		Register.setBounds(900,200,150,70);
		Register.setFont(new Font("Roboto",Font.BOLD,20));
//		Register.setBackground(Color.black);
//		Register.setForeground(Color.red);
		Register.addActionListener(this);
		image.add(Register);
		
		
		
		setSize(1170,650); // Sets the size of window frame
		setLocation(200,50); // Distance from left size and from top side
		setVisible(true); // is the window visible?
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Blinking Text
		
//		while(true) {
//			heading.setVisible(false);
//			try {
//				Thread.sleep(500);
//			}catch(Exception e) {}
//			
//			heading.setVisible(true);
//			try {
//				Thread.sleep(500);
//			}catch(Exception e) {}
//			
//		}
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Splash();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==Login) {
		setVisible(false);
		new Login();
		}
		else if(e.getSource()==Register) {
			setVisible(false);
			new Register();
		}
			
		}
		
		
	}



