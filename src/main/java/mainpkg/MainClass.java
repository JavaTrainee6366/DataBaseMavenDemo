package mainpkg;

import db_connection.JDBC_Connection;

public class MainClass {
	
	public static void main(String[] args) {
		
		JDBC_Connection.db();
		DBSample obj = new DBSample();
		obj.insert("Rama", "657362627", "rama@abc.com", "123");
				
	}

}
