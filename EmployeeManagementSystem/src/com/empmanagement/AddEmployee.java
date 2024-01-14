package com.empmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.toedter.calendar.JDateChooser;

import java.util.Random;




public class AddEmployee extends JFrame implements ActionListener{
	
	Random randomnumber = new Random();
	int number = randomnumber.nextInt(999999);
	
	JLabel heading,labelname,labelfname,labeldob,labelsalary,labeladdress,labelphone,labelemail,labeleducation,labeldesignation,labelaadhar,labelempid,lempid;
	JTextField tname,tfname,tdob,tsalary,taddress,tphone,temail,tdesignation,taadhar,tempid;
	JComboBox cbeducation;
	JDateChooser ddob;
	JButton add,back;

	AddEmployee(){
		
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		heading = new JLabel("Add Employee Details");
		heading.setBounds(350,30,500,50);// sets the boundary for the label(heading)
		heading.setFont(new Font("serif",Font.BOLD,25));//set the font by font type , font , size
		add(heading);
		////NAME
		labelname = new JLabel("Name");
		labelname.setBounds(50,150,150,30);// sets the boundary for the label(heading)
		labelname.setFont(new Font("serif",Font.PLAIN,20));//set the font by font type , font , size
		add(labelname);
		
		tname = new JTextField();
		tname.setBounds(200,150,150,30);// sets the boundary for the label(heading)
		add(tname);
		
		///FATHER NAME
		labelfname = new JLabel("Father's Name");
		labelfname.setBounds(400,150,150,30);// sets the boundary for the label(heading)
		labelfname.setFont(new Font("serif",Font.PLAIN,20));//set the font by font type , font , size
		add(labelfname);
		
		 tfname = new JTextField();
		tfname.setBounds(600,150,150,30);// sets the boundary for the label(heading)
		add(tfname);
		
		///DATE
		 labeldob = new JLabel("Date of Birth");
		labeldob.setBounds(50,200,150,30);// sets the boundary for the label(heading)
		labeldob.setFont(new Font("serif",Font.PLAIN,20));//set the font by font type , font , size
		add(labeldob);
		
		ddob = new JDateChooser();
		ddob.setBounds(200,200,150,30);// sets the boundary for the label(heading)
		add(ddob);
		
		///Salary
		
		 labelsalary = new JLabel("Salary");
		labelsalary.setBounds(400,200,150,30);// sets the boundary for the label(heading)
		labelsalary.setFont(new Font("serif",Font.PLAIN,20));//set the font by font type , font , size
		add(labelsalary);
		
		 tsalary = new JTextField();
		tsalary.setBounds(600,200,150,30);// sets the boundary for the label(heading)
		add(tsalary);
		
		///ADDRESS
		 labeladdress = new JLabel("Address");
		labeladdress.setBounds(50,250,150,30);// sets the boundary for the label(heading)
		labeladdress.setFont(new Font("serif",Font.PLAIN,20));//set the font by font type , font , size
		add(labeladdress);
		
		 taddress = new JTextField();
		taddress.setBounds(200,250,150,30);// sets the boundary for the label(heading)
		add(taddress);
		///PHONE
		 labelphone= new JLabel("Phone");
		labelphone.setBounds(400,250,150,30);// sets the boundary for the label(heading)
		labelphone.setFont(new Font("serif",Font.PLAIN,20));//set the font by font type , font , size
		add(labelphone);
		
		 tphone = new JTextField();
		tphone.setBounds(600,250,150,30);// sets the boundary for the label(heading)
		add(tphone);
		///EMAIL
		
		 labelemail = new JLabel("Email");
		labelemail.setBounds(50,300,150,30);// sets the boundary for the label(heading)
		labelemail.setFont(new Font("serif",Font.PLAIN,20));//set the font by font type , font , size
		add(labelemail);
		
		 temail = new JTextField();
		temail.setBounds(200,300,150,30);// sets the boundary for the label(heading)
		add(temail);
		///HIGHEST EDUCATION
		
		 labeleducation = new JLabel("Highest Education");
		labeleducation.setBounds(400,300,150,30);// sets the boundary for the label(heading)
		labeleducation.setFont(new Font("serif",Font.PLAIN,20));//set the font by font type , font , size
		add(labeleducation);
		
		String courses[] = {"","BBA","BCA","BA","BSC","B.COM","B.Tech","MBA","MCA","MA","MSC","PHD"};
		cbeducation = new JComboBox(courses);
		cbeducation.setBackground(Color.white);
		cbeducation.setBounds(600,300,150,30);// sets the boundary for the label(heading)
		add(cbeducation);
		
		///DESIGNATION
		labeldesignation = new JLabel("Designation");
		labeldesignation.setBounds(50,350,150,30);// sets the boundary for the label(heading)
		labeldesignation.setFont(new Font("serif",Font.PLAIN,20));//set the font by font type , font , size
		add(labeldesignation);
		
		 tdesignation = new JTextField();
		tdesignation.setBounds(200,350,150,30);// sets the boundary for the label(heading)
		add(tdesignation);
		///PHONE
		 labelaadhar= new JLabel("Aadhar Number");
		labelaadhar.setBounds(400,350,150,30);// sets the boundary for the label(heading)
		labelaadhar.setFont(new Font("serif",Font.PLAIN,20));//set the font by font type , font , size
		add(labelaadhar);
		
		 taadhar = new JTextField();
		taadhar.setBounds(600,350,150,30);// sets the boundary for the label(heading)
		add(taadhar);
		
		///EMP ID
		
		 labelempid= new JLabel("Employee ID");
		labelempid.setBounds(50,400,150,30);// sets the boundary for the label(heading)
		labelempid.setFont(new Font("serif",Font.BOLD,20));//set the font by font type , font , size
		add(labelempid);
		
		 lempid= new JLabel(""+number);
		lempid.setBounds(200,400,150,30);// sets the boundary for the label(heading)
		lempid.setFont(new Font("serif",Font.BOLD,20));//set the font by font type , font , size
		add(lempid);
		
		
		//ADD EMP BUTTON
		
		add = new JButton("ADD EMPLOYEE");
		add.setBounds(250,550,150,40);
		add.setBackground(Color.black);
		add.setForeground(Color.white);
		add.addActionListener(this);
		add(add);
		
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
		new AddEmployee();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==add) {
			String name = tname.getText();
			String fname = tfname.getText();
			String dob = ((JTextField) ddob.getDateEditor().getUiComponent()).getText();
			String salary = tsalary.getText();
			String address = taddress.getText();
			String phone = tphone.getText();
			String email = temail.getText();
			String education= (String) cbeducation.getSelectedItem();
			String designation = tdesignation.getText();
			String aadhar = taadhar.getText();
			String empid = lempid.getText();
			
			
			try {
				ConnectionClass con = new ConnectionClass();
				String query ="insert into employee values ('"+name+"','"+fname+"','"+dob+"','"+salary+"','"+address+"','"+phone+"','"+email+"','"+education+"','"+designation+"','"+aadhar+"','"+empid+"')";
				con.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null,"Details Added Succesfully");
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
