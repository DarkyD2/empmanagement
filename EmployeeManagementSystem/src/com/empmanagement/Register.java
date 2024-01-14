package com.empmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Register extends JFrame implements ActionListener{

	JLabel luser,lpass,lconfirm;
	JTextField tuser;
	JPasswordField pass, confirmpass;
	JButton back,register;
	
	Register(){
		
		getContentPane().setBackground(Color.white);
		
		luser = new JLabel("Enter Username:");
		luser.setBounds(40,30,120,30);
		luser.setFont(new Font("serif",Font.BOLD,15));
		add(luser);
		
		tuser = new JTextField();
		tuser.setBounds(200,30,200,30);
		add(tuser);
		
		lpass = new JLabel("Enter Password:");
		lpass.setFont(new Font("serif",Font.BOLD,15));
		lpass.setBounds(40,70,120,30);
		add(lpass);
		
		pass = new JPasswordField();
		pass.setBounds(200,70,200,30);
		add(pass);
		
		lconfirm = new JLabel("Confirm Password:");
		lconfirm.setFont(new Font("serif",Font.BOLD,15));
		lconfirm.setBounds(40,110,150,30);
		add(lconfirm);
		
		confirmpass = new JPasswordField();
		confirmpass.setBounds(200,110,200,30);
		add(confirmpass);
		
		register = new JButton("REGISTER");
		register.setBounds(100,200,150,40);
		register.setFont(new Font("Roboto",Font.BOLD,20));
//		register.setBackground(Color.black);
//		register.setForeground(Color.red);
		register.addActionListener(this);
		
		add(register);


		back = new JButton("BACK");
		back.setBounds(300,200,150,40);
		back.setFont(new Font("Roboto",Font.BOLD,20));
//		back.setBackground(Color.black);
//		back.setForeground(Color.red);
		back.addActionListener(this);
		add(back);
		
		
		
		ImageIcon loginimage1 = new ImageIcon(getClass().getResource("icons/second.jpg"));
		Image loginimage2 = loginimage1.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT);
		ImageIcon loginimage3 = new ImageIcon(loginimage2);
		JLabel loginimage = new JLabel(loginimage3);
		loginimage.setBounds(450,0,200,200);
		add(loginimage);
		
		
		
		
		
		
		
		setLayout(null);
		setSize(700,400);
		setLocation(450,200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Register();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		
		if(ae.getSource()==register) {
		
		
			String username=tuser.getText();
			String password=pass.getText();
			String confirmpassword = confirmpass.getText();
			
			if(username.isEmpty()||password.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Username and password cannot be blank.");
				return;
			}
		
			if(password.equals(confirmpassword)) {
				try {
				ConnectionClass con = new ConnectionClass();
				String query = "insert into login values('"+username+"','"+password+"')";
				con.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Registered Succesfully");
				setVisible(false);
				new Splash();
				}catch(Exception e) {
					e.printStackTrace();
					}
			}
			
			
			
			else {
				JOptionPane.showMessageDialog(null,"Password and Confirm Password don't match.");
				tuser.setText("");
				pass.setText("");
				confirmpass.setText("");
				
			}
		}else if(ae.getSource()==back){
			setVisible(false);
			new Splash();
		
		
		
		}
	}
}

