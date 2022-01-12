package mainpkg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Scanner;

import db_connection.JDBC_Connection;

public class MainClass {
	
	static Scanner sn;
	
	 static InputStreamReader r;   
	 static BufferedReader brr; 
	 static DBSample obj ;
   
	
        
	
	public static void main(String[] args) throws IOException, SQLException {
		
		r=new InputStreamReader(System.in);
		brr=new BufferedReader(r);
		obj = new DBSample();
		sn = new Scanner(System.in);
		
		System.out.println("Your Choices::");
		
		System.out.println("1. Registeration");
		System.out.println("2. Login");
		System.out.println("3. Change Password");
		System.out.println("4. Exit");
		
		
		int choice =0;
		
		do {
			System.out.println("Please Enter ::");
			choice = sn.nextInt();
			switch (choice) {
			case 1:
				register();
				break;
				
			case 2:
				login();
				break;
			case 3:
				//changePass();
				break;

			default:
				break;
			}
		}while(choice!=4);
		System.out.println("Thanks for use");
		/*
		 * System.out.println("Please enter the desirable id:");
		 * 
		 * //JDBC_Connection.db(); DBSample obj = new DBSample(); int id = sn.nextInt();
		 * System.out.println("Please enter updated description:"); //String des =
		 * sn.nextLine();
		 * 
		 * obj.update(id, "My New Course");
		 * 
		 * //obj.select(id); //obj.insert("Rama", "657362627", "rama@abc.com", "123");
		 */				
	}
	
	public static void register() throws IOException {
		
		System.out.println("Enter Roll_No:");
		int Roll_no=Integer.parseInt(brr.readLine()); 
		System.out.println("Enter Name:");
		String name = brr.readLine();
		System.out.println("Enter Contact:");
		String contact = brr.readLine();
		System.out.println("Enter Email:");
		String email = brr.readLine();
		System.out.println("Enter DOB(yyyy-mm-dd):");
		String dob = brr.readLine();
		System.out.println("Enter pass:");
		String pass = brr.readLine();
		obj.insert(Roll_no, name, contact, email, pass, dob);
			
		
	}
	
	public static void login() throws IOException, SQLException {
		System.out.println("Enter Email:");
		String email = brr.readLine();
		System.out.println("Enter pass:");
		String pass = brr.readLine();
		obj.select(email, pass);
	}

}
