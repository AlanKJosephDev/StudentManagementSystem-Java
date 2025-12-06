package task5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MenuDrivenProgram {

	public static void main(String[] args) {
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db", "root", "Root@123");
			
			while(true) {
				System.out.println("Enter your choice\n1.Insert student\n2.Display all\n3.Update student\n4.Delete student\n5.Search student\n6.Exit");
				Scanner sc=new Scanner(System.in);
				int ch=sc.nextInt();
				System.out.println();
				switch (ch) {
				case 1: {
					PreparedStatement ps2=con.prepareStatement("select max(id) from student;");
					ResultSet rs=ps2.executeQuery();
					
					int id=0;
					if(rs.next())
						id=rs.getInt(1);
					
					System.out.println("Enter id(> "+id+")");
					int n=sc.nextInt();
					sc.nextLine();
					
					if(n<=id) {
						System.out.println("Id already in use");
					}
					else {
						PreparedStatement ps=con.prepareStatement("insert into student values(?,?);");
						ps.setInt(1, n);
						System.out.println("Enter Name:");
						String name=sc.nextLine();
						ps.setString(2, name);
						
						int rs2=ps.executeUpdate();
						if(rs2>0)
							System.out.println("Insertion successful");
						else
							System.out.println("Insertion failed");
					}
					System.out.println();
					break;
				}
				case 2: {
					PreparedStatement ps=con.prepareStatement("select * from student;");
					ResultSet rs=ps.executeQuery();
					System.out.println("List of all the students:");
					System.out.println("ID   Name");
					while(rs.next()) {
						System.out.println(rs.getInt(1)+"   "+rs.getString(2));
					}	
					System.out.println();
					break;
				}
				case 3: {
					PreparedStatement ps=con.prepareStatement("update student set name=?where id=?;");
					
					PreparedStatement ps2=con.prepareStatement("select max(id) from student;");
					ResultSet rs=ps2.executeQuery();
					
					int id=0;
					if(rs.next())
						id=rs.getInt(1);
					
					System.out.println("Enter id(< "+id+") to update name");
					int n=sc.nextInt();
					ps.setInt(2, n);
					System.out.println("Enter updated Name:");
					String name=sc.next();
					ps.setString(1, name);
					
					int rs2=ps.executeUpdate();
					if(rs2>0)
						System.out.println("Updation successful");
					else
						System.out.println("Updation failed");
					System.out.println();
					break;
				}
				case 4: {
					PreparedStatement ps=con.prepareStatement("delete from student where id=?");
					
					PreparedStatement ps2=con.prepareStatement("select max(id) from student;");
					ResultSet rs=ps2.executeQuery();
					
					int id=0;
					if(rs.next())
						id=rs.getInt(1);
					
					System.out.println("Enter id(< "+id+") to delete record");
					int n=sc.nextInt();
					ps.setInt(1, n);
					
					int rs2=ps.executeUpdate();
					if(rs2>0)
						System.out.println("Deletion successful");
					else
						System.out.println("Deletion failed");
					System.out.println();
					break;
				}
				case 5: {
					PreparedStatement ps=con.prepareStatement("select * from student where id=?");
					
					PreparedStatement ps2=con.prepareStatement("select max(id) from student;");
					ResultSet rs=ps2.executeQuery();
					
					int id=0;
					if(rs.next())
						id=rs.getInt(1);
					
					System.out.println("Enter id(<or= "+id+") to search record");
					int n=sc.nextInt();
					ps.setInt(1, n);
					
					ResultSet rs2=ps.executeQuery();
					if(rs2.next())
						System.out.println("Id: "+rs2.getInt(1)+"\nName: "+rs2.getString(2));
					else
						System.out.println("Invalid id");
					System.out.println();
					break;
				}
				case 6: {
					return;
					
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + ch);
				}
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
