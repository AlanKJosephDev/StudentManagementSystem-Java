package Task3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DisplayOnlyNames {

	public static void main(String[] args) {
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db", "root", "Root@123");
			
			PreparedStatement ps=con.prepareStatement("select name from student;");
			
			ResultSet rs=ps.executeQuery();
			
			System.out.println("Name of all students:");
			while(rs.next())
				System.out.println(rs.getString(1));
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
