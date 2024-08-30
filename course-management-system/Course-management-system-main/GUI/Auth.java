package GUI;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


//this class is for user authentication and restration
public class Auth {
	private static Statement stmt;
	
	//ask for DatabseManager when object is created
	public Auth(DatabaseManager db) {
		Auth.stmt = db.getStatement();
	}

	/////login
	public static void returnSystemUser(String email, String password) throws Exception {
		try {
			String sql = "SELECT count(*) FROM auth WHERE email='" + email + "'";
			ResultSet rs = stmt.executeQuery(sql);
			int count = 0;
			if (rs.next())
				count = rs.getInt(1);
			if (count == 0)
				throw new Exception("No user with this email found!");
			else {
				sql = "SELECT name,role FROM auth WHERE email='" + email + "' AND password='" + password + "'";
				rs = stmt.executeQuery(sql);
				if (rs.next()) {
					switch (rs.getString("role")) {
						case "Student":
//							return new Student(rs.getString("name"));
							System.out.println("Student");
						case "Teacher":
//							return new Teacher(rs.getString("name"));
							System.out.println("Teacher");
						case "Admin":
//							return new Admin(rs.getString("name"));
							System.out.println("Admin");
						default:
							throw new Exception("An error occurred while retrieving role!");
					}
				} else
					throw new Exception("Password not valid!");
			}
		} catch (SQLException e) {
			throw new Exception("An error occurred while checking the email and password!");
		}
	}
	
	//Signup

	public static void addCredential(String email, String password) throws Exception {
		try {
			String sql = "SELECT email FROM auth WHERE email='" + email + "'";
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				throw new Exception("Email already in use!");
			} else {
				sql = "INSERT INTO auth (email, password, role) VALUES ('" + email + "', '"
						+ password + "', 'Student')";
				stmt.executeUpdate(sql);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}