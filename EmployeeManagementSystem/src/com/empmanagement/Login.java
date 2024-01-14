package com.empmanagement;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
public class Login extends JFrame implements ActionListener {

	JLabel lusername,lpassword;
	JTextField tusername,tpassword;
	JPasswordField pass;
	
	
	Login(){
		
		getContentPane().setBackground(Color.white);
		setLayout(null);
		//Adding username and its textfield
		
		lusername = new JLabel("Username:");
		lusername.setBounds(40,20,100,30);
		lusername.setFont(new Font("Roboto",Font.BOLD,20));
		add(lusername);
		
		tusername = new JTextField();
		tusername.setBounds(150,20,150,30);
		tusername.setFont(new Font("Roboto",Font.BOLD,20));
		add(tusername);
		
		lpassword = new JLabel("Password:");
		lpassword.setBounds(40,70,100,30);
		lpassword.setFont(new Font("Roboto",Font.BOLD,20));
		add(lpassword);
		
//		tpassword = new JTextField();
//		tpassword.setBounds(150,70,150,30);
//		add(tpassword);
		//ADDING CENSOR
		pass = new JPasswordField();
		pass.setBounds(150,70,150,30);
		pass.setFont(new Font("Roboto",Font.BOLD,20));
		add(pass);
		
		
		//Adding Button
		
		JButton loginbutton = new JButton("LOGIN");
		loginbutton.setBounds(150,150,150,70);
		loginbutton.setFont(new Font("Roboto",Font.BOLD,20));
//		loginbutton.setBackground(Color.black);
//		loginbutton.setForeground(Color.red);
		loginbutton.addActionListener(this);
		add(loginbutton);
		
		//Adding Image
		
		ImageIcon loginimage1 = new ImageIcon(getClass().getResource("icons/second.jpg"));
		Image loginimage2 = loginimage1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon loginimage3 = new ImageIcon(loginimage2);
		JLabel loginimage = new JLabel(loginimage3);
		loginimage.setBounds(350,0,200,200);
		add(loginimage);
		
		
		
		
		
		
		
		setSize(600,400);
		setLocation(450,200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
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
			String password = pass.getText();
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
