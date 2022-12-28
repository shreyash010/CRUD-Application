package task1;
import java.sql.*;
import java.util.Scanner;
public class Insert {
	Insert(String url, String username, String password){
		try {
			Scanner sc = new Scanner(System.in);
			Connection con = DriverManager.getConnection(url, username, password);
			String insertQuery = "INSERT INTO Students (student_id, first_name, last_name, grade) VALUES (?, ?, ?, ?)";
			PreparedStatement insertStmt = con.prepareStatement(insertQuery);

			// Set the values for the insert query
			System.out.println("Enter id: ");
			int id = sc.nextInt();
			System.out.println("Enter first name: ");
			String fname = sc.next();
			System.out.println("Enter last name: ");
			String lname = sc.next();
			System.out.println("Enter grade: ");
			int grade = sc.nextInt();
			insertStmt.setInt(1, id); // student_id
			insertStmt.setString(2, fname); // first_name
			insertStmt.setString(3, lname); // last_name
			insertStmt.setInt(4, grade); // grade

			// Execute the insert query
			insertStmt.executeUpdate();
			Read r = new Read(url, username, password);
			con.close();
			sc.close();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
