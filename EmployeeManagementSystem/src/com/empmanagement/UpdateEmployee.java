package com.empmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;





public class UpdateEmployee extends JFrame implements ActionListener{
	

	
	JLabel lblname,lblfname,lblddob,lblaadhar,heading,labelname,labelfname,labeldob,labelsalary,labeladdress,labelphone,labelemail,labeleducation,labeldesignation,labelaadhar,labelempid,lempid;
	JTextField tname,tfname,tdob,tsalary,taddress,tphone,temail,tdesignation,taadhar,tempid,tfeducation;
	JButton update,back;
	String empid;

	UpdateEmployee(String empid){
		this.empid=empid;
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		heading = new JLabel("Update Employee Details");
		heading.setBounds(350,30,500,50);// sets the boundary for the label(heading)
		heading.setFont(new Font("Roboto",Font.BOLD,25));//set the font by font type , font , size
		add(heading);
		////NAME
		labelname = new JLabel("Name:");
		labelname.setBounds(50,150,150,30);// sets the boundary for the label(heading)
		labelname.setFont(new Font("Roboto",Font.PLAIN,20));//set the font by font type , font , size
		add(labelname);
		
		JLabel lblname = new JLabel();
		lblname.setBounds(200,150,150,30);// sets the boundary for the label(heading)
		add(lblname);
		
		///FATHER NAME
		labelfname = new JLabel("Father's Name:");
		labelfname.setBounds(400,150,150,30);// sets the boundary for the label(heading)
		labelfname.setFont(new Font("Roboto",Font.PLAIN,20));//set the font by font type , font , size
		add(labelfname);
		
		 lblfname = new JLabel();
		lblfname.setBounds(600,150,150,30);// sets the boundary for the label(heading)
		add(lblfname);
		
		///DATE
		 labeldob = new JLabel("Date of Birth:");
		labeldob.setBounds(50,200,150,30);// sets the boundary for the label(heading)
		labeldob.setFont(new Font("Roboto",Font.PLAIN,20));//set the font by font type , font , size
		add(labeldob);
		
		 lblddob = new JLabel();
		lblddob.setBounds(200,200,150,30);// sets the boundary for the label(heading)
		add(lblddob);
		
		///Salary
		
		 labelsalary = new JLabel("Salary:");
		labelsalary.setBounds(400,200,150,30);// sets the boundary for the label(heading)
		labelsalary.setFont(new Font("Roboto",Font.PLAIN,20));//set the font by font type , font , size
		add(labelsalary);
		
		 tsalary = new JTextField();
		tsalary.setBounds(600,200,150,30);// sets the boundary for the label(heading)
		add(tsalary);
		
		///ADDRESS
		 labeladdress = new JLabel("Address:");
		labeladdress.setBounds(50,250,150,30);// sets the boundary for the label(heading)
		labeladdress.setFont(new Font("Roboto",Font.PLAIN,20));//set the font by font type , font , size
		add(labeladdress);
		
		 taddress = new JTextField();
		taddress.setBounds(200,250,150,30);// sets the boundary for the label(heading)
		add(taddress);
		///PHONE
		 labelphone= new JLabel("Phone:");
		labelphone.setBounds(400,250,150,30);// sets the boundary for the label(heading)
		labelphone.setFont(new Font("Roboto",Font.PLAIN,20));//set the font by font type , font , size
		add(labelphone);
		
		 tphone = new JTextField();
		tphone.setBounds(600,250,150,30);// sets the boundary for the label(heading)
		add(tphone);
		///EMAIL
		
		 labelemail = new JLabel("Email:");
		labelemail.setBounds(50,300,150,30);// sets the boundary for the label(heading)
		labelemail.setFont(new Font("Roboto",Font.PLAIN,20));//set the font by font type , font , size
		add(labelemail);
		
		 temail = new JTextField();
		temail.setBounds(200,300,150,30);// sets the boundary for the label(heading)
		add(temail);
		///HIGHEST EDUCATION
		
		 labeleducation = new JLabel("Highest Education:");
		labeleducation.setBounds(400,300,150,30);// sets the boundary for the label(heading)
		labeleducation.setFont(new Font("Roboto",Font.PLAIN,20));//set the font by font type , font , size
		add(labeleducation);
		
		tfeducation = new JTextField();
		tfeducation.setBounds(600,300,150,30);// sets the boundary for the label(heading)
		add(tfeducation);
		
		///DESIGNATION
		labeldesignation = new JLabel("Designation:");
		labeldesignation.setBounds(50,350,150,30);// sets the boundary for the label(heading)
		labeldesignation.setFont(new Font("Roboto",Font.PLAIN,20));//set the font by font type , font , size
		add(labeldesignation);
		
		 tdesignation = new JTextField();
		tdesignation.setBounds(200,350,150,30);// sets the boundary for the label(heading)
		add(tdesignation);
		///PHONE
		 labelaadhar= new JLabel("Aadhar Number:");
		labelaadhar.setBounds(400,350,150,30);// sets the boundary for the label(heading)
		labelaadhar.setFont(new Font("Roboto",Font.PLAIN,20));//set the font by font type , font , size
		add(labelaadhar);
		
		 lblaadhar = new JLabel();
		lblaadhar.setBounds(600,350,150,30);// sets the boundary for the label(heading)
		add(lblaadhar);
		
		///EMP ID
		
		 labelempid= new JLabel("Employee ID:");
		labelempid.setBounds(50,400,150,30);// sets the boundary for the label(heading)
		labelempid.setFont(new Font("Roboto",Font.BOLD,20));//set the font by font type , font , size
		add(labelempid);
		
		 lempid= new JLabel();
		lempid.setBounds(200,400,150,30);// sets the boundary for the label(heading)
		lempid.setFont(new Font("Roboto",Font.BOLD,20));//set the font by font type , font , size
		add(lempid);
		
		try {
			ConnectionClass c= new ConnectionClass();
			String query = "select * from employee where empid = '"+empid+"'";
			ResultSet rs=c.s.executeQuery(query);
			while(rs.next()) {
				lblname.setText(rs.getString("name"));
				lblfname.setText(rs.getString("fname"));
				lblddob.setText(rs.getString("dob"));
				lblaadhar.setText(rs.getString("aadhar"));
				lempid.setText(rs.getString("empid"));
				taddress.setText(rs.getString("address"));
				tphone.setText(rs.getString("phone"));
				temail.setText(rs.getString("email"));
				tfeducation.setText(rs.getString("education"));
				tdesignation.setText(rs.getString("designation"));
				tsalary.setText(rs.getString("salary"));


			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		//UPDATE EMP BUTTON
		
		update = new JButton("UPDATE EMPLOYEE");
		update.setBounds(250,550,150,40);
		update.setBackground(Color.black);
		update.setForeground(Color.white);
		update.addActionListener(this);
		add(update);
		
		//BACK BUTTON
		
		back = new JButton("BACK");
		back.setBounds(450,550,150,40);
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.addActionListener(this);
		add(back);
		
		
		
		
		
		
		
		
		setSize(900,700);
		setLocation(300,50);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new UpdateEmployee("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==update) {
			String salary = tsalary.getText();
			String address = taddress.getText();
			String phone = tphone.getText();
			String email = temail.getText();
			String education= tfeducation.getText();
			String designation = tdesignation.getText();
			
			
			try {
				ConnectionClass con = new ConnectionClass();
				String query ="update employee set salary ='"+salary+"',address ='"+address+"',phone ='"+phone+"',email='"+email+"',education='"+education+"',designation='"+designation+"' where empid='"+empid+"'";
				con.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null,"Details Updated Succesfully");
				setVisible(false);
				new HomePage();
				
			}catch(Exception e2) {
				e2.printStackTrace();
			}



		}
		else {
			setVisible(false);
			new HomePage();
		}
	}
}
