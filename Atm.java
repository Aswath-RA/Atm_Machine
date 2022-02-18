package Atmmachine;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.*;
public class Atm {
	//String First_Choicer;
	int Accno ;
	int pin;
	int option;
	
	
	Scanner string =new Scanner(System.in);
	Scanner integer = new Scanner(System.in);


	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
			Atm obj = new Atm();
			obj.display();
		
		
	}
	
		
		
	
	public void display () throws Exception {
		
		System.out.println(" \t\t\t\t\t\t\t\t***************************************");
		System.out.println(" \t\t\t\t\t\t\t\t********     Welcome      *************");
		System.out.println(" \t\t\t\t\t\t\t\t********      To          *************");
		System.out.println(" \t\t\t\t\t\t\t\t******** RAVIJI_ASWA ATM  *************");
		System.out.println(" \t\t\t\t\t\t\t\t***************************************");
		System.out.println("\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t Press ENTER to Continue");
		string.nextLine();
		System.out.println("*****Enter Your Credintals******\n\n");
		System.out.print("ACCOUNT NO: ");
		Accno=integer.nextInt();
		
		System.out.print("PIN NO:     ");
		pin=integer.nextInt();
		
		if (Accno ==9629638 && pin ==9796) {
			System.out.println("Your Account is Valid :-)\n\n");
			options();
		}
		else {
			System.out.println(" Sorry ,your Account is IN-Valid :-(\n");

		}
	}
	
	public void options() throws Exception{
		
		Class.forName("com.mysql.jdbc.Driver");  
		String url = "jdbc:mysql://localhost:3306/Atm?characterEncoding=utf8";
		String username ="blackfox";
		String password ="11aa22**";
		Connection con = DriverManager.getConnection(url,username,password);
		Statement stmt = con.createStatement();
		ResultSet rs;
		PreparedStatement st;
		String qry ="";
		System.out.println("--------------");
		System.out.println("ATM Working");
		System.out.println("--------------");
		
		
		System.out.println("-----------------------");
		System.out.println("Welcome to Atm Options");
		System.out.println("------------------------");

		System.out.println("Type 1 : Deposit");
		System.out.println("Type 2 : Withdraw");
		System.out.println("Type 3 : Balance check");
		System.out.println("Type 4 : Mini statement");
		System.out.println("Type 5 : Pin change");
		System.out.println("Type 6 : Contact-US");
		System.out.println("Type 7 : Exit Out ATM");
		System.out.print("\nEnter your option 1 to 7 : ");


		option=integer.nextInt();
		switch(option){
			case 1:
				System.out.println("-----------");
				System.out.println("\n Deposit");
				System.out.println("-----------");
				int deposit;
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
				System.out.println("Amout Deposited");
			
				System.out.println("-----------");
				
				break;
			case 2:
				int withdraw;
				System.out.println("-----------");
				System.out.println("Withdraw");
				System.out.println("-----------");
				while (true) {
					System.out.println("Enter Amount to Withdraw: ");
					withdraw=integer.nextInt();
					if (withdraw > 30000) {
						System.out.println("Your Daily Withdraw limit is Thirty Thousand Only ");
					}
					else {
						break;
					}
					}
					qry = "UPDATE Atmusers set Balance = Balance - "+withdraw+" where Accno = "+Accno+" AND Pin = "+pin+" ";
					st= con.prepareStatement(qry);
					st.executeUpdate();
					System.out.println("---Please Collect Your Money From The Machine ---");
					System.out.println("Thank you for Banking ");
					System.out.println("-----------");
				
				break;
			case 3:
			    System.out.println("-------------");
				System.out.println("Balance Check");
				System.out.println("--------------");
				int balance;
				String name; 
				qry = "SELECT Name,Balance from Atmusers where Accno = "+Accno+" AND Pin = "+pin+" ";
				
				rs=stmt.executeQuery(qry);
				
				
				while (rs.next()) {
					name=rs.getString("Name");
					balance = rs.getInt("Balance");
					System.out.println("Hi "+name+" ");
					System.out.println("Your Available Balance is : "+ balance);
					System.out.println("--------------");
				}
				break;
			case 4:
			    System.out.println("--------------");
				System.out.println("Mini Statement");
				System.out.println("--------------");
				break;
			case 5:
				System.out.println("------------");
				System.out.println("Pin Change");
				System.out.println("------------");
				
				String checkdob = null;
				int checkpin = 0;
				qry = "SELECT Dob,Pin from Atmusers where Accno = "+Accno+" AND Pin = "+pin+" ";
				rs=stmt.executeQuery(qry);
				
				while (rs.next()) {
					checkdob = rs.getString("Dob");
					checkpin = rs.getInt("Pin");
					System.out.println(checkdob);
					System.out.println(checkpin);
					
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
				System.out.println( scheck);
				
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
					System.out.println("Your New Pin Set Successfully ");
					System.out.println("------------------------------");
					
				}
				else {
					System.out.println(" Your Old pin or Date-of-Birth is Wrong.  ");
					System.out.println("Try After Some Time \n Thank you ..");
				}
				
			
				break;
			case 6:
				System.out.println("-----------");
				System.out.println("Contact Us");
				System.out.println("------------");
				System.out.println("For any banking related Queries");
				System.out.println("mail to : help@ravijiaswa.com");
				break;
			case 7:
				//System.out.println("Exit");
				display();
				break;
			default:
				System.out.println("Enter a number between 1 to 7");
		}


	}
}



