package task6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CombineDataFromBothTables {

	public static void main(String[] args) {
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db", "root", "Your_password");
			
			PreparedStatement ps=con.prepareStatement("select s.id,s.name,sd.age,sd.mark from student s join student_details sd on s.id=sd.id;");
			
			ResultSet rs=ps.executeQuery();
			
			System.out.println("ID Name Age Marks");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getInt(4));
			}
		} catch (SQLException e) {
			
			System.out.println("SQLException happened: "+e.getMessage());
		}
	}

}
