package com.student.main;
import java.sql.*;
import java.util.*;

import com.student.db.DBConnection;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Student Management System");
		while(true) {
			System.out.println("\n1. Add Student");
			System.out.println("2. View All Students");
			System.out.println("3. Search Student by ID");
			System.out.println("4. Update Student");
			System.out.println("5. Delete Student");
			System.out.println("6. Exit\n");
			System.out.print("Enter your choice: ");
			int choice=sc.nextInt();
			switch(choice) {
			case 1:
				System.out.print("\nEnter Student ID: ");
				int id=sc.nextInt();
				System.out.print("Enter Student Name: ");
				String name=sc.next();
				System.out.print("Enter Student Gender: ");
				String gender=sc.next();
				System.out.print("Enter Student Marks: ");
				int marks=sc.nextInt();
				try {
					Connection con=DBConnection.getConnection();
					PreparedStatement check=con.prepareStatement("select id from student where id=?");
					check.setInt(1, id);
					ResultSet rs=check.executeQuery();
					if(rs.next()) {
						System.out.println("\nID already exists! Please enter another ID.");
						break;
					}
					String qry="Insert into student(id,name,gender,marks) values(?,?,?,?)";
					PreparedStatement ps=con.prepareStatement(qry);
					ps.setInt(1, id);
					ps.setString(2, name);
					ps.setString(3, gender);
					ps.setInt(4, marks);
					int result=ps.executeUpdate();
					if(result>0) {
						System.out.println("\nStudent Added Successfully!");
					}
					else {
						System.out.println("\nFailed to Add Student!");
					}
					con.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
				break;
			case 2:
				try {
					Connection con=DBConnection.getConnection();
					String qry="select * from student order by id";
					PreparedStatement ps=con.prepareStatement(qry);
					ResultSet rs=ps.executeQuery();
					System.out.printf("\n%-6s %-15s %-10s %-5s\n\n","ID","Name","Gender","Marks");
					while(rs.next()) {
						System.out.printf("%-6d %-15s %-10s %-5d\n",rs.getInt("id"),rs.getString("name"),rs.getString("gender"),rs.getInt("marks"));
					}
					con.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
				break;
			case 3:
				System.out.print("Enter ID: ");
				int searchId=sc.nextInt();
				try {
					Connection con=DBConnection.getConnection();
					String qry="select * from student where id=?";
					PreparedStatement ps=con.prepareStatement(qry);
					ps.setInt(1, searchId);
					ResultSet rs=ps.executeQuery();
					System.out.printf("\n%-6s %-15s %-10s %-5s\n\n","ID","Name","Gender","Marks");
					while(rs.next()) {
						System.out.printf("%-6d %-15s %-10s %-5d\n",rs.getInt("id"),rs.getString("name"),rs.getString("gender"),rs.getInt("marks"));
					}
					con.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
				break;
			case 4:
				System.out.print("Enter ID: ");
				int updateId=sc.nextInt();
				System.out.print("Enter Name: ");
				String updatedName=sc.next();
				System.out.print("Enter Gender: ");
				String updatedGender=sc.next();
				System.out.print("Enter Marks: ");
				int updatedMarks=sc.nextInt();
				try {
					Connection con=DBConnection.getConnection();
					String qry="update student set name=?,gender=?,marks=? where id=?";
					PreparedStatement ps=con.prepareStatement(qry);
					ps.setString(1, updatedName);
					ps.setString(2, updatedGender);
					ps.setInt(3, updatedMarks);
					ps.setInt(4, updateId);
					int result=ps.executeUpdate();
					if(result>0) {
						System.out.println("\nStudent Updated Successfully!");
					}
					else {
						System.out.println("\nStudent Is Not Updated");
					}
					con.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
				break;
			case 5:
				System.out.print("Enter Id: ");
				int deleteId=sc.nextInt();
				try {
					String qry="delete from student where id=?";
					Connection con=DBConnection.getConnection();
					PreparedStatement ps=con.prepareStatement(qry);
					ps.setInt(1,deleteId);
					int result=ps.executeUpdate();
					if(result>0) {
						System.out.println("\nStudent Deleted Successfully!");
					}
					else {
						System.out.println("\nStudent Is Not Exist!");
					}
					con.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
				
				break;
			case 6:
				System.out.println("\nExiting loop...");
				break;
			}
			if(choice==6) {
				break;
			}
		}
	}
}
