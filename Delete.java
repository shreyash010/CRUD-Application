package task1;
import java.sql.*;
import java.util.Scanner;

public class Delete {
	Delete(String url, String username, String password){
		// Establish a connection to the database
		try {
			Scanner sc = new Scanner(System.in);
			Connection conn = DriverManager.getConnection(url, username, password);
			// Create a prepared statement for the delete query
			String deleteQuery = "DELETE FROM Students WHERE student_id = ?";
			PreparedStatement deleteStmt = conn.prepareStatement(deleteQuery);

			// Set the value for the WHERE clause in the delete query
			System.out.println("Enter Students id: ");
			int id = sc.nextInt();
			deleteStmt.setInt(1, id); // student_id

			// Execute the delete query
			deleteStmt.executeUpdate();
			Read r = new Read(url, username, password);

			// Close the prepared statement and connection
			deleteStmt.close();
			conn.close();

		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
