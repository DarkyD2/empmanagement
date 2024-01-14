package com.empmanagement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

import net.proteanit.sql.DbUtils;


public class ViewEmployee extends JFrame implements ActionListener{
	
	JTable table;
	JButton search, print, update,back;
	Choice empid;
	ViewEmployee(){
		
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		table = new JTable();
		
		JLabel labelsearch = new JLabel("Search ID");
		labelsearch.setBounds(20,20,70,20);
		add(labelsearch);


		search = new JButton("SEARCH");
		search.setBounds(20,70,80,20);
//		search.setBackground(Color.black);
//		search.setForeground(Color.white);
		search.addActionListener(this);
		add(search);
		
		
		print = new JButton("PRINT");
		print.setBounds(120,70,80,20);
//		print.setBackground(Color.black);
//		print.setForeground(Color.white);
		print.addActionListener(this);
		add(print);
		
		
		update = new JButton("UPDATE");
		update.setBounds(220,70,84,20);
//		update.setBackground(Color.black);
//		update.setForeground(Color.white);
		update.addActionListener(this);
		add(update);
		
		
		back = new JButton("BACK");
		back.setBounds(320,70,80,20);
//		back.setBackground(Color.black);
//		back.setForeground(Color.white);
		back.addActionListener(this);
		add(back);
		
		String ids;
		
		empid = new Choice();
		empid.setBounds(90,20,150,20);
		add(empid);
		
		try {
			ConnectionClass con = new ConnectionClass();
			ResultSet rs = con.s.executeQuery("select * from employee");
			
			while(rs.next()){
				empid.add(rs.getString("empid"));
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	
		
		try {
			ConnectionClass con = new ConnectionClass();
			ResultSet rs = con.s.executeQuery("select * from employee");
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(0,100,900,600);
		add(scroll);
		
		setSize(900,700);
		setLocation(300,100);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	
	public static void main(String[] args) {
		new ViewEmployee();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==search) {
			String query = "select * from employee where empid ='"+empid.getSelectedItem()+"'";
			try {
				ConnectionClass con2 = new ConnectionClass();
				ResultSet rs2 = con2.s.executeQuery(query);
				table.setModel(DbUtils.resultSetToTableModel(rs2));
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}else if(e.getSource()==print) {
			try {
				table.print();
			}catch(Exception e3){
				e3.printStackTrace();
			}
		}else if(e.getSource()==update){
			setVisible(false);
			new UpdateEmployee(empid.getSelectedItem());
		}else {
			setVisible(false);
			new HomePage();
		}
	}
}
