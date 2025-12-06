package StudentDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertOneStudentUsingStatement {

	public static void main(String[] args) throws SQLException {
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db", "root", "Root@123");

		Statement stmt=con.createStatement();
		
		boolean rs=stmt.execute("insert into student values(1,'Alan');");
		
		System.out.println("Data added");
	}

}
