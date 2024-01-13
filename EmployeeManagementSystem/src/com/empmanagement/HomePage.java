package com.empmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HomePage extends JFrame implements ActionListener{
	
	
	JButton addButton,viewButton,updateButton,removeButton;
	HomePage(){
		setLayout(null);
		
		JLabel heading = new JLabel("Employee Management System");
		heading.setBounds(80,30,1200,100);// sets the boundary for the label(heading)
		heading.setFont(new Font("serif",Font.BOLD,60));//set the font by font type , font , size
		add(heading);
		
		ImageIcon i1 = new ImageIcon(getClass().getResource("icons/home.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
		ImageIcon i3= new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,1120,630);
		add(image);
		
		addButton = new JButton("ADD");
		addButton.setBounds(650,400,150,40);
		addButton.setBackground(Color.black);
		addButton.setForeground(Color.red);
		addButton.addActionListener(this);
		image.add(addButton);
		
		viewButton = new JButton("VIEW");
		viewButton.setBounds(850,400,150,40);
		viewButton.setBackground(Color.black);
		viewButton.setForeground(Color.red);
		viewButton.addActionListener(this);
		image.add(viewButton);
		
		
		updateButton = new JButton("UPDATE");
		updateButton.setBounds(650,500,150,40);
		updateButton.setBackground(Color.black);
		updateButton.setForeground(Color.red);
		updateButton.addActionListener(this);
		image.add(updateButton);
		
		
		removeButton = new JButton("REMOVE");
		removeButton.setBounds(850,500,150,40);
		removeButton.setBackground(Color.black);
		removeButton.setForeground(Color.red);
		removeButton.addActionListener(this);
		image.add(removeButton);
		setSize(1120,630);
		setLocation(250,100);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new HomePage();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==addButton) {
			setVisible(false);
			new AddEmployee();
		}
		else if(e.getSource()==viewButton){
			setVisible(false);
			new ViewEmployee();
		}
		
		else if(e.getSource()==updateButton) {
			setVisible(false);
			new ViewEmployee();
			}
		else{
			setVisible(false);
			new RemoveEmployee();
			
		}
		
		
	}

}
