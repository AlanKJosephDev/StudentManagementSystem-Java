package Task2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertRecordUsingPreparedStatement {

	public static void main(String[] args) throws SQLException {
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db", "root", "Root@123");
		
		PreparedStatement stmt=con.prepareStatement("insert into student values(?,?)");
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter id(greater than or equal to 7):");
		int id=sc.nextInt();
		stmt.setInt(1, id);
		
		System.out.println("Enter Name:");
		String name=sc.next();
		stmt.setString(2, name);
		
		int i=stmt.executeUpdate();
		
		if(i>0)
			System.out.println("Insertion successful");
		else
			System.out.println("Insertion failed");
	}

}
