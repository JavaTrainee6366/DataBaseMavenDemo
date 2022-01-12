package mainpkg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db_connection.JDBC_Connection;

public class DBSample {

	Connection con;

	public DBSample() {
		// TODO Auto-generated constructor stub

		con = JDBC_Connection.db();
	}

	void insert(int id, String name, String contact, String email, String pass, String DOB) {

		try {
			PreparedStatement pd = con
					.prepareStatement("Insert into student (id,name,contact,email,DOB,pass) values(?,?,?,?,?,?) ");

			pd.setInt(1, id);
			pd.setString(2, name);
			pd.setString(3, contact);
			pd.setString(4, email);
			pd.setString(5, DOB);
			pd.setString(6, pass);

			int i = pd.executeUpdate();

			if (i > 0) {
				System.out.println("Successfully Inserted");
				// response.sendRedirect("/Login.html");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/*
	 * void select(int ans_id) { try { PreparedStatement pd = con.prepareStatement(
	 * "select * from answer where ans_id = '" + ans_id + "' "); ResultSet rs =
	 * pd.executeQuery();
	 * 
	 * while (rs.next()) { int id = rs.getInt(1); String ans = rs.getString(2);
	 * 
	 * 
	 * System.out.println("Values Are::" + ans);
	 * 
	 * }
	 * 
	 * 
	 * if (rs.next()) { System.out.println("You are Successfully LogIn"); }else{
	 * System.out.println("Your Username or password are incorrect"); }
	 * 
	 * 
	 * } catch (Exception e) { System.out.println("" + e); }
	 * 
	 * }
	 */

	public void select(String email, String pass) throws SQLException {

		PreparedStatement pd = con.prepareStatement("select * from student where email = '" + email + "' and pass = '"+pass+"' ");
		ResultSet rs = pd.executeQuery();

		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			
			System.out.println("Welcome : "+name);

		}

	}

	public void update(int id, String des) {

		try {
			PreparedStatement pd = con
					.prepareStatement("update course set description='" + des + "' " + "where id='" + id + "' ");
			int i = pd.executeUpdate();

			if (i > 0) {
				System.out.println("Successful");
			} else {
				System.out.println("check with your query");
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

	}

}
