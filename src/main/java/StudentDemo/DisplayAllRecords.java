package StudentDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DisplayAllRecords {

	public static void main(String[] args) {
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db", "root", "Root@123");
			
			Statement stmt=con.createStatement();
			
			ResultSet rs=stmt.executeQuery("select * from student");
			
			System.out.println("The Table records are:");
			System.out.println("ID	Name");
			System.out.println("------------------------");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"	"+rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
