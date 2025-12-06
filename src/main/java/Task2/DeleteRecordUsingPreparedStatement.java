package Task2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteRecordUsingPreparedStatement {

	public static void main(String[] args) throws SQLException {
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db", "root", "Root@123");
		
		PreparedStatement stmt=con.prepareStatement("delete from student where id=?;");
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter id to delete record(less than or equal to 6):");
		int id=sc.nextInt();
		stmt.setInt(1, id);
		
		int i=stmt.executeUpdate();
		
		if(i>0)
			System.out.println("deletion successful");
		else
			System.out.println("deletion failed");
	}

}
