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
		
		void select(int ans_id) {
			try {
				PreparedStatement pd = con.prepareStatement(
		"select * from answer where ans_id = '" + ans_id + "' ");
				ResultSet rs = pd.executeQuery();

				while (rs.next()) {
					int id = rs.getInt(1);
					String ans = rs.getString(2);
					

					System.out.println("Values Are::" + ans);

				}

				/*
				 * if (rs.next()) { System.out.println("You are Successfully LogIn"); }else{
				 * System.out.println("Your Username or password are incorrect"); }
				 */

			} catch (Exception e) {
				System.out.println("" + e);
			}

		}
		
		public void update(int id,String des) {
			
			try {
				PreparedStatement pd = con.prepareStatement("update course set description='"+des+"' "
																+"where id='"+id+"' ");
				int i = pd.executeUpdate();
				
				if(i>0) {
					System.out.println("Successful");
				}else {
					System.out.println("check with your query");
				}
				
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
			
		}
	

}
