package com.empmanagement;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

import javax.swing.*;

public class RemoveEmployee extends JFrame implements ActionListener{

	
	JLabel labelempid,labelname,lblname,labelphone,lblphone,labelemail,lblemail;
	Choice cempid;
	JButton delete,back;
	RemoveEmployee(){
		
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		labelempid = new JLabel("Emp ID:");
		labelempid.setFont(new Font("Roboto",Font.BOLD,20));
		labelempid.setBounds(50,50,100,30);
		add(labelempid);
		
		cempid = new Choice();
		cempid.setBounds(200,50,150,30);
		cempid.setFont(new Font("Roboto",Font.BOLD,20));
		add(cempid);
		
		
		labelname = new JLabel("Name:");
		labelname.setFont(new Font("Roboto",Font.BOLD,20));
		labelname.setBounds(50,100,150,30);// sets the boundary for the label(heading)
//		labelname.setFont(new Font("serif",Font.PLAIN,20));//set the font by font type , font , size
		add(labelname);
		
		lblname = new JLabel();
		lblname.setBounds(200,100,150,30);
		lblname.setFont(new Font("Roboto",Font.BOLD,20));// sets the boundary for the label(heading)
		add(lblname);
		
		labelphone= new JLabel("Phone:");
		labelphone.setFont(new Font("Roboto",Font.BOLD,20));
		labelphone.setBounds(50,150,150,30);// sets the boundary for the label(heading)
//		labelphone.setFont(new Font("serif",Font.PLAIN,20));//set the font by font type , font , size
		add(labelphone);
			
		lblphone= new JLabel();
		lblphone.setFont(new Font("Roboto",Font.BOLD,20));
		lblphone.setBounds(200,150,150,30);// sets the boundary for the label(heading)
		add(lblphone);
			
		labelemail = new JLabel("Email:");
		labelemail.setFont(new Font("Roboto",Font.BOLD,20));
		labelemail.setBounds(50,200,150,30);// sets the boundary for the label(heading)
//		labelemail.setFont(new Font("serif",Font.PLAIN,20));//set the font by font type , font , size
		add(labelemail);
				
		lblemail = new JLabel();
		lblemail.setFont(new Font("Roboto",Font.BOLD,20));
		lblemail.setBounds(200,200,150,30);// sets the boundary for the label(heading)
		add(lblemail);
		
		
		
		try {
			ConnectionClass c = new ConnectionClass();
			String query ="select * from employee";
			
			ResultSet rs= c.s.executeQuery(query);
			while(rs.next()) {
				cempid.add(rs.getString("empid"));
				lblname.setText(rs.getString("name"));
				lblphone.setText(rs.getString("phone"));
				lblemail.setText(rs.getString("email"));

				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		cempid.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent ie) {
				// TODO Auto-generated method stub
				try {
					ConnectionClass c = new ConnectionClass();
					String query ="select * from employee where empid='"+cempid.getSelectedItem()+"'";
					
					ResultSet rs= c.s.executeQuery(query);
					while(rs.next()) {
						lblname.setText(rs.getString("name"));
						lblphone.setText(rs.getString("phone"));
						lblemail.setText(rs.getString("email"));

						
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			
		});
		
		delete = new JButton("DELETE");
		delete.setBounds(50,300,100,50);
		delete.setFont(new Font("Roboto",Font.BOLD,10));
//		delete.setBackground(Color.black);
//		delete.setForeground(Color.red);
		delete.addActionListener(this);
		add(delete);
		
		back = new JButton("BACK");
		back.setFont(new Font("Roboto",Font.BOLD,10));
		back.setBounds(200,300,100,50);
//		back.setBackground(Color.black);
//		back.setForeground(Color.red);
		back.addActionListener(this);
		add(back);
		
		
		setSize(700,500);
		setLocation(350,250);
//		setSize(1000,800);
//		setLocation(350,200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new RemoveEmployee();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource()==delete) {
			try {
				ConnectionClass c = new ConnectionClass();
				String query = "delete from employee where empid='"+cempid.getSelectedItem()+"'";
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Deleted Sucessfully");
				setVisible(false);
				new HomePage();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else {
			setVisible(false);
			new HomePage();
			
			
		}
	}

}
