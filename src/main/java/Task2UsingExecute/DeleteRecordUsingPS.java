package Task2UsingExecute;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteRecordUsingPS {

	public static void main(String[] args) throws SQLException {
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db", "root", "Your_password");
		
		PreparedStatement stmt=con.prepareStatement("delete from student where id=?;");
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter id to delete record(less than or equal to 6):");
		int id=sc.nextInt();
		stmt.setInt(1, id);
		
		boolean i=stmt.execute();
		
		System.out.println("deletion successful");
	}

}
