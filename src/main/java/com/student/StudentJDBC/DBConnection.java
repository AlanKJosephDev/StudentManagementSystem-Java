package com.student.StudentJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBConnection {

	public static void main(String[] args) {
		String URL="jdbc:mysql://localhost:3306/student_db";
		String User="root";
		String password="Root@123";
		try {
			Connection con=DriverManager.getConnection(URL, User, password);
			
			Statement stmt=con.createStatement();
			
			ResultSet rs=stmt.executeQuery("select * from students;");
			
			System.out.println("ID Name 	Email");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+" 	"+rs.getString(3));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
