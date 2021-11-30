import java.util.Scanner;
public class Atm {
	//String First_Choicer;
	int Accno ;
	int pin;
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
			System.out.println("Your Account is Valid");
			
		}
		else {
			System.out.println("Your Account is IN-Valid");

		}
		
		
	
		
	}

}
