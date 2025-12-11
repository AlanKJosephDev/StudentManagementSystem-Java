package Task3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ResultSortedByIdOrName {

	public static void main(String[] args) {
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db", "root", "Your_password");
			
			System.out.println("Choices:\n1.Sort records by id\n2.Sort results by name");
			System.out.println("Enter the choice:");
			Scanner sc=new Scanner(System.in);
			int ch=sc.nextInt();
			switch (ch) {
			case 1: {
				PreparedStatement ps=con.prepareStatement("select * from student order by id;");
				
				ResultSet rs=ps.executeQuery();
				
				System.out.println("Id   Name");
				while(rs.next())
					System.out.println(rs.getInt(1)+"   "+rs.getString(2));
				break;
			}
			case 2: {
				PreparedStatement ps=con.prepareStatement("select * from student order by name;");
				
				ResultSet rs=ps.executeQuery();
				
				System.out.println("Id   Name");
				while(rs.next())
					System.out.println(rs.getInt(1)+"   "+rs.getString(2));
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: "+ch);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
