package Atmmachine;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;  
import java.io.File;
import java.io.FileWriter; 
import java.io.IOException;
import java.sql.*;
public class Atm {
	
	//String First_Choicer;
	//Variable for Auth and choice
	int Accno ;
	int pin;
	int option;
	
	Scanner string =new Scanner(System.in);   //Scanner object for String
	Scanner integer = new Scanner(System.in); //Scanner object for Integer
	
	//DB Connection Variables
	String url = "jdbc:mysql://localhost:3306/Atm?characterEncoding=utf8";
	String username ="blackfox";
	String password ="11aa22**";
	ResultSet rs;
	PreparedStatement st;
	String qry ="";

	public static void main(String[] args) throws Exception {
		
			Atm obj = new Atm();
			obj.display();	  //Display function calling
		
	}
	
			
	public void display () throws Exception {
		
		//Display function for welcoming and Authentication
		
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con = DriverManager.getConnection(url,username,password);
		Statement stmt = con.createStatement();
		
		System.out.println(" \t\t\t\t\t\t\t\t***************************************");
		System.out.println(" \t\t\t\t\t\t\t\t********     Welcome      *************");
		System.out.println(" \t\t\t\t\t\t\t\t********      To          *************");
		System.out.println(" \t\t\t\t\t\t\t\t********  Black Fox ATM   *************");
		System.out.println(" \t\t\t\t\t\t\t\t***************************************");
		System.out.println("\n\n\t\t\t\t\t\t\t Press ENTER to Continue");
		string.nextLine();
		System.out.println("*****Enter Your Credintals******\n\n");
		int flag = 0;
		while (flag < 3) {                                            //For Incorrect Accno and Pin giving three Chances to correct it 
		
		System.out.println("Enter your Account Number: ");
		Accno=integer.nextInt();                                      //Getting user input for Authentication
		System.out.println("Enter your Pin: ");
		pin=integer.nextInt();
		
		qry = "SELECT * from Atmusers where Accno = "+Accno+" AND Pin = "+pin+" ";
		rs=stmt.executeQuery(qry);
		
		if (rs.next()) {
			//System.out.println("Your Account is Valid \n\n");      //Checking the input in the DB
			options();
			break;	
		}
		else {
			System.out.println("\n..............................");
			System.out.println("Sorry ,your Account is IN-Valid ");
			System.out.println("..............................\n");
			flag = flag + 1;
		}
		
		if (flag == 3){
			System.out.println("\n..............................");
			System.out.println("Please Try after some time ...");
			System.out.println("..............................\n");	
			thankyou();
		}
		}
	}
	
	public void options() throws Exception{
		
		//Options function will give the Atm options and data from DB
		
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con = DriverManager.getConnection(url,username,password);      //DB Connection
		Statement stmt = con.createStatement();
		ResultSet rs;
		PreparedStatement st;
		String qry ="";

		System.out.println("--------------");
		System.out.println("ATM Working");
		System.out.println("--------------\n");
		
		System.out.println("-----------------------");
		System.out.println("Welcome to Atm Options");
		System.out.println("------------------------\n\n");

		System.out.println("----------------------------");
		System.out.println("Type 1 : Deposit");
		System.out.println("Type 2 : Withdraw");
		System.out.println("Type 3 : Balance check");
		System.out.println("Type 4 : Mini statement");                         //Atm options
		System.out.println("Type 5 : Pin change");
		System.out.println("Type 6 : Contact-US");
		System.out.println("Type 7 : Exit Out ATM");
		System.out.println("------------------------------");
		System.out.print("\nEnter your option 1 to 7 : ");
		

																			  //Getting options 
		option=integer.nextInt();                                                 
		switch(option){
			case 1:
				System.out.println("\n-----------");
				System.out.println(" Deposit");
				System.out.println("-----------\n");
				int deposit;												   //Case 1 : Deposit ,Amount should be less than 1 lakh
				while (true) {
				System.out.println("Enter Amount to Deposit: ");
				deposit=integer.nextInt();
				if (deposit > 100000) {
					System.out.println("Deposit Amount should be less than 1 Lakh ");
				}
				else {
					break;
				}
				}
				qry = "UPDATE Atmusers set Balance = Balance + "+deposit+" where Accno = "+Accno+" AND Pin = "+pin+" ";
				st= con.prepareStatement(qry);
				st.executeUpdate();
				System.out.println("\n---------------");
				System.out.println("Amout Deposited");
				System.out.println("---------------\n");
				thankyou();

				break;

			case 2:
				int withdraw;
				System.out.println("\n-----------");
				System.out.println("Withdraw");
				System.out.println("-----------\n");                          //Case 2 : Withdraw ,Amount should be less than 30 thousand
				while (true) {
					System.out.println("Enter Amount to Withdraw: ");
					withdraw=integer.nextInt();
					if (withdraw > 30000) {
						System.out.println("\n................................................");
						System.out.println("Your Daily Withdraw limit is Thirty Thousand Only ");
						System.out.println(" .................................................\n");
					}
					else {
						break;
					}
					}
					qry = "UPDATE Atmusers set Balance = Balance - "+withdraw+" where Accno = "+Accno+" AND Pin = "+pin+" ";
					st= con.prepareStatement(qry);
					st.executeUpdate();
					System.out.println("\n------------------------------------------");
					System.out.println("---Please Collect Your Money From Atm ------");
					System.out.println("-------------------------------------------\n");
					thankyou();
				
				break;
			case 3:
			    System.out.println("\n-------------");
				System.out.println("Balance Check");
				System.out.println("--------------\n");                       //Case 3 : Balance check
				int balance;
				String name; 
				qry = "SELECT Name,Balance from Atmusers where Accno = "+Accno+" AND Pin = "+pin+" ";
				rs=stmt.executeQuery(qry);
				
				while (rs.next()) {
					name=rs.getString("Name");
					balance = rs.getInt("Balance");
					System.out.println("Hi "+name+" ");
					System.out.println("\n-------------------------------------");
					System.out.println("Your Available Balance is : "+ balance);
					System.out.println("-------------------------------------\n");
					thankyou();
				}
				break;

			case 4:
			    System.out.println("\n--------------");
				System.out.println("Mini Statement");                             //Case 4 : Mini Statement -> It will be Printed to a separate File
				System.out.println("--------------\n");
				int mini_balance =0;
				String mini_name = ""; 
				qry = "SELECT Name,Balance from Atmusers where Accno = "+Accno+" AND Pin = "+pin+" ";
				rs=stmt.executeQuery(qry);
				
				while (rs.next()) {
					mini_name=rs.getString("Name");
					mini_balance = rs.getInt("Balance");
				}
				try {  
			        FileWriter fwrite = new FileWriter("/home/blackfox/MiniStatement.txt",true);  
			          
			        
			        fwrite.write("*************************************\n");   
			        fwrite.write("*******Welcome To BlackFox ATM*******\n"); 
			        fwrite.write("*************************************\n"); 
			        fwrite.write("\n-----------------------\n"); 
			        fwrite.write("-----Mini Statement------\n"); 
			        fwrite.write("-------------------------\n"); 
			        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
			        LocalDateTime now = LocalDateTime.now();  
			        fwrite.write(dtf.format(now)+ "\n"); 
			        fwrite.write("\nHi "+ mini_name + "\n"); 
			        fwrite.write("\nYour Available Balance is :"+ mini_balance + "\n"); 
			        fwrite.write("\n-----------------------\n"); 
			        fwrite.write("--Thank You For Using--\n"); 
			        fwrite.write("-----Black Fox Atm-----\n"); 
			        fwrite.write("-----------------------\n");
			      
			        // Closing the file stream  
			        fwrite.close();   
			        System.out.println("\n-------------------------------------");
			        System.out.println("Mini Statement Created Sucessfully..."); 
			        System.out.println("-------------------------------------\n");
			    } catch (IOException e) {  
			    	System.out.println("\n-------------------------------------");
			        System.out.println("Right Now Mini Statement is not Working"); 
			        System.out.println("You can use Balance Check Option in ATM");
			        System.out.println("-------------------------------------\n");
			   
			        } 
				thankyou();
				break;
				
			case 5:
				System.out.println("\n------------");
				System.out.println("Pin Change");                            //Case 5 : Pin changing -> need to enter old password and Date of birth.
				System.out.println("------------\n");
				
				String checkdob = null;
				int checkpin = 0;
				qry = "SELECT Dob,Pin from Atmusers where Accno = "+Accno+" AND Pin = "+pin+" ";
				rs=stmt.executeQuery(qry);
				
				while (rs.next()) {
					checkdob = rs.getString("Dob");
					checkpin = rs.getInt("Pin");
					//System.out.println(checkdob);
					//System.out.println(checkpin);	
				}
				int newpin;
				int oldpin;
				String dob;
				Boolean  scheck;
				
				System.out.println("Enter Your Old Pin: ");
				oldpin = integer.nextInt();
				System.out.println("Enter your Date-of-Birth in format YYYY-MM-DD: ");
				dob=string.next();
				scheck= dob.equals(checkdob);
				//System.out.println( scheck);
				
				if (oldpin == checkpin && scheck){
					
					while (true) {
						
					     System.out.println("Enter your new pin: ");
					     newpin = integer.nextInt();
					     //int n = String.valueOf(newpin).length();
					     String n = Integer.toString(newpin);
					     System.out.println(n.length()); 
					     
					     if ( n.length() >= 5 || n.length() <= 3 ){
					        System.out.println("Pin is not in correct size"); 
					     }
					     else{
					          System.out.println("Your Pin is "+ newpin);
					          break ;
					     }
					
					}
					
					qry = "UPDATE Atmusers set Pin =  "+newpin+" where Accno = "+Accno+" AND Pin = "+pin+" ";
					st= con.prepareStatement(qry);
					st.executeUpdate();
					System.out.println("\n------------------------------");
					System.out.println("Your New Pin Set Successfully   ");
					System.out.println("--------------------------------\n");
					thankyou();
					
				}
				else {
					System.out.println("\n----------------------------------------");
					System.out.println(" Your Old pin or Date-of-Birth is Wrong.  ");
					System.out.println("----------------------------------------\n");
					
					System.out.println("\n-------------------");
					System.out.println("Try After Some Time ");
					System.out.println("--------------------\n");
					
					thankyou();
				}
				break;
				
			case 6:
				System.out.println("\n-----------");
				System.out.println("Contact Us");
				System.out.println("------------\n");                                      //Case 6 : Contact us option
				System.out.println("\n-------------------------------");
				System.out.println("For any banking related Queries");
				System.out.println("mail to : help@blackfox.com ");
				System.out.println("-------------------------------\n");
				thankyou();
				break;
				
			case 7:
				//System.out.println("Exit");                                             //Case 7 : Exit -> It will return to Display function
				display();
				break;
				
			default:
				System.out.println("\nEnter a number between 1 to 7");                    //Default shows options are in 1 to 7
				System.out.println("-------------------------------\n");
		}

	}
	public void thankyou(){                                                               //Thankyou function to print the thanks message.
				System.out.println("-----------------------");
				System.out.println("--Thank You For Using--");
				System.out.println("-----Black Fox Atm-----");
				System.out.println("-----------------------");

	}
}


