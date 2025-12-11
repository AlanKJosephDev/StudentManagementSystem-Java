package com.student.StudentJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection2 {

	public static void main(String[] args) throws Exception{
		String url="jdbc:mysql://localhost:3306/student_db";
		String name="root";
		String password="Your_password";
		
		Connection con=DriverManager.getConnection(url, name, password);
		
		
	}

}
