import java.util.Scanner;
public class Atm {
	//String First_Choicer;
	int Accno ;
	int pin;
	int option;
	Scanner string =new Scanner(System.in);
	Scanner integer = new Scanner(System.in);


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Atm obj=new Atm();
		obj.display();
		
	}
	public void display () {
		
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
		
		if (Accno ==9629638 && pin ==9629) {
			System.out.println("Your Account is Valid :-)\n\n");
			options();
		}
		else {
			System.out.println(" Sorry ,your Account is IN-Valid :-(\n");

		}
	}
	public void options(){
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
				break;
			case 2:
				System.out.println("-----------");
				System.out.println("Withdraw");
				System.out.println("-----------");
				break;
			case 3:
			    System.out.println("-------------");
				System.out.println("Balance Check");
				System.out.println("--------------");
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


