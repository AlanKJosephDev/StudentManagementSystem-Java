package Task2UsingExecute;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SearchAStudentUsingId {

	public static void main(String[] args) throws SQLException {
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db", "root", "Your_password");
		
		PreparedStatement stmt=con.prepareStatement("select * from student where id=?");
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter id to seach a record(less than or equal to 6):");
		int id=sc.nextInt();
		stmt.setInt(1, id);
		
		ResultSet rs=stmt.executeQuery();//with execute it is impossible.
		
		if(rs.next())
			System.out.println("Name: "+rs.getString(2));
		else
			System.out.println("Invalid id");
	}

}
