package task1;
import java.sql.*;
import java.util.Scanner;

public class Update {
	Update(String url, String username, String password){
		try {
			Scanner sc = new Scanner(System.in);
			Connection conn = DriverManager.getConnection(url, username, password);
	
			// Create a prepared statement for the update query
			String updateQuery = "UPDATE Students SET grade = ? WHERE student_id = ?";
			PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
	
			// Set the values for the update query
			System.out.println("Enter grade: ");
			int grade = sc.nextInt();
			updateStmt.setInt(1, grade); // grade
			System.out.println("Enter the student id: ");
			int id = sc.nextInt();
			updateStmt.setInt(2, id); // student_id
	
			// Execute the update query
			updateStmt.executeUpdate();
			Read r = new Read(url, username, password);
			// Close the prepared statement and connection
			updateStmt.close();
			conn.close();
			sc.close();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
