package mainpkg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db_connection.JDBC_Connection;

public class DBSample {
	
	Connection con;
	
	public DBSample() {
		// TODO Auto-generated constructor stub

		con = JDBC_Connection.db();
	}

	void insert(String name, String contact, String email, String pass) {

		try {
			PreparedStatement pd = con
					.prepareStatement("Insert into tb_reg (tb_name,tb_contact,tb_email,"
							+ "tb_pass) values(?,?,?,?) ");

			// pd.setInt(1,0 );
			pd.setString(1, name);
			pd.setString(2, contact);

			pd.setString(3, email);
			pd.setString(4, pass);

			int i = pd.executeUpdate();

			if (i > 0) {
				System.out.println("Successfully Inserted");
				// response.sendRedirect("/Login.html");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
		
		void select(String uname, String pass) {
			try {
				PreparedStatement pd = con.prepareStatement(
		"select * from tb_test where email = '" + uname + "' " + "and password = '" + pass + "' ");
				ResultSet rs = pd.executeQuery();

				while (rs.next()) {
					int id = rs.getInt(1);
					String nn = rs.getString("name");
					String em = rs.getString(3);
					String pas = rs.getString(4);
					String cont = rs.getString(5);
					String ad = rs.getString(6);

					System.out.println("Values Are::" + nn);

				}

				/*
				 * if (rs.next()) { System.out.println("You are Successfully LogIn"); }else{
				 * System.out.println("Your Username or password are incorrect"); }
				 */

			} catch (Exception e) {
				System.out.println("" + e);
			}

		}
	

}
