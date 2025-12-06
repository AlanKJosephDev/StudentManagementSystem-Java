package StudentDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateRecord {

	public static void main(String[] args) throws SQLException {
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db", "root", "Root@123");

		PreparedStatement stmt=con.prepareStatement("update student set name=? where id=?;");
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the id to update:");
		int n=sc.nextInt();
		stmt.setInt(2, n);
		
		System.out.println("Enter the updated name:");
		String s=sc.next();
		stmt.setString(1, s);
		
		int rs=stmt.executeUpdate();
		if(rs>0)
			System.out.println("Data updated");
		else
			System.out.println("Updation failed");
		sc.close();
		stmt.close();
		con.close();
	}

}
