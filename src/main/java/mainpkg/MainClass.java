package mainpkg;

import java.util.Scanner;

import db_connection.JDBC_Connection;

public class MainClass {
	
	public static void main(String[] args) {
		Scanner sn = new Scanner(System.in);
		System.out.println("Please enter the desirable id:");
		
		//JDBC_Connection.db();
		DBSample obj = new DBSample();
		int id = sn.nextInt();
		System.out.println("Please enter updated description:");
		//String des = sn.nextLine();
		
		obj.update(id, "My New Course");
		
		//obj.select(id);
		//obj.insert("Rama", "657362627", "rama@abc.com", "123");
				
	}

}
