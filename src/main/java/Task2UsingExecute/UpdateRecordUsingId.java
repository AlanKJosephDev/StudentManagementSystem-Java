package Task2UsingExecute;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateRecordUsingId {

	public static void main(String[] args) throws SQLException {
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db", "root", "Root@123");
		
		PreparedStatement stmt=con.prepareStatement("update student set name=? where id=?");
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter id to update the record(less than or equal to 6):");
		int id=sc.nextInt();
		stmt.setInt(2, id);
		
		System.out.println("Enter name to be update the record:");
		String name=sc.next();
		stmt.setString(1, name);
		
		boolean rs=stmt.execute();
		
		System.out.println("Updation success");
	}

}
