package StudentDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertMultipleValuesUsingLoop {

	public static void main(String[] args) throws SQLException {
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db", "root", "Root@123");
		
		PreparedStatement stmt=con.prepareStatement("insert into student values(?,?)");
		
		System.out.println("How many values to insert?");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		
		for(int i=1;i<=n;i++) {
			System.out.println("Enter ID:");
			int m=sc.nextInt();
			stmt.setInt(1, m);
			
			System.out.println("Enter Name:");
			String s=sc.next();
			stmt.setString(2, s);
			
			stmt.execute();
		}
		
		System.out.println("All Data successfully inserted");
		sc.close();
		stmt.close();
		con.close();
	}

}
