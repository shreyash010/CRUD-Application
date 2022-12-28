package task1;

import java.sql.*;

public class Read {
	Read(String url, String username, String password){
		try {
			Connection conn = DriverManager.getConnection(url, username, password);
	
			// Create a prepared statement for the update query
			String selectQuery = "SELECT * FROM Students";
			PreparedStatement selectStmt = conn.prepareStatement(selectQuery);

			// Set the value for the WHERE clause in the select query
//			selectStmt.setInt(1, 123); // student_id

			// Execute the select query and get the result set
			ResultSet rs = selectStmt.executeQuery();

			// Iterate through the result set and print the results
			while (rs.next()) {
			   int studentId = rs.getInt("student_id");
			   String firstName = rs.getString("first_name");
			   String lastName = rs.getString("last_name");
			   int grade = rs.getInt("grade");
			   System.out.println("Student: " + studentId + " " + firstName + " " + lastName + " " + grade);
			}

			// Close the result set, prepared statement, and connection
			rs.close();
			selectStmt.close();
			conn.close();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
