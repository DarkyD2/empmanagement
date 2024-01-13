package com.empmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
public class Login extends JFrame implements ActionListener {

	JTextField tusername,tpassword;
	
	
	Login(){
		
		getContentPane().setBackground(Color.white);
		setLayout(null);
		//Adding username and its textfield
		
		JLabel lusername = new JLabel("Username");
		lusername.setBounds(40,20,100,30);
		add(lusername);
		
		tusername = new JTextField();
		tusername.setBounds(150,20,150,30);
		add(tusername);
		
		JLabel lpassword = new JLabel("Password");
		lpassword.setBounds(40,70,100,30);
		add(lpassword);
		
		tpassword = new JTextField();
		tpassword.setBounds(150,70,150,30);
		add(tpassword);
		//Adding Button
		
		JButton loginbutton = new JButton("Click here to login");
		loginbutton.setBounds(150,200,150,30);
		loginbutton.setBackground(Color.black);
		loginbutton.setForeground(Color.red);
		loginbutton.addActionListener(this);
		add(loginbutton);
		
		//Adding Image
		
		ImageIcon loginimage1 = new ImageIcon(getClass().getResource("icons/second.jpg"));
		Image loginimage2 = loginimage1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
		ImageIcon loginimage3 = new ImageIcon(loginimage2);
		JLabel loginimage = new JLabel(loginimage3);
		loginimage.setBounds(350,0,200,200);
		add(loginimage);
		
		
		
		
		
		
		
		setSize(600,400);
		setLocation(450,200);
		setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Login();
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
		
		
			String username = tusername.getText();
			String password = tpassword.getText();
			ConnectionClass c = new ConnectionClass();
			
			String query = "select * from login where username = '"+username+"' and password = '"+password+"'";
			
			ResultSet rs = c.s.executeQuery(query);
			
			if(rs.next()) {
				setVisible(false);
				new HomePage();
			}else {
				JOptionPane.showMessageDialog(null, "Invalid username or password");
				setVisible(false);
			}
		}catch(Exception e2) {
			e2.printStackTrace();
			}
		
	}
}
