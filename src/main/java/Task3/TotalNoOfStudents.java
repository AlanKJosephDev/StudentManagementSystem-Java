package Task3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TotalNoOfStudents {

	public static void main(String[] args) {
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db", "root", "Root@123");
			
			PreparedStatement ps=con.prepareStatement("select * from student;");
			
			ResultSet rs=ps.executeQuery();
			
			int c=0;
			while(rs.next())
				c++;
			
			System.out.println("Total no of students:"+c);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
