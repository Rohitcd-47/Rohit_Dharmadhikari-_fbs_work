import java.util.Scanner;
class BankAccount
{
	int accNo;
	String holderName;
	double currentBalance, interestrate;


	BankAccount()
	{
		this.accNo = 110011;
		this.holderName = "Rohit";
		this.currentBalance = 10000;
		this.interestrate = 0.07;
		System.out.println("Inside default constructor");

	}
	BankAccount(int d,String str,double c,double i)
	{
		this.accNo =d;
		this.holderName = str;
		this.currentBalance = c;
		this.interestrate = i;
		System.out.println("\nInside Parameterized constructor");

	}

	void display()
	{
		System.out.println("Account_no : "+ accNo + "\nHolderName : " + holderName + "\nCurrentBalance : " + currentBalance + 		"\nInterestRate : " + interestrate);
	}

	void setaccNo(int d)
	{
		this.accNo = d;
	}
	void setholderName(String d)
	{
		this.holderName = d;
	}
	void setcurrentBalance(double d)
	{
		this.currentBalance = d;
	}

	void setinterestRate(double d)
	{
		this.interestrate = d;
	}



	int getaccNo()
	{
		return this.accNo;
	}
	String getholderName()
	{
		return this.holderName;
	}

	double getcurrentBalance()
	{
		return this.currentBalance;
	}
	double getinterestRate()
	{
		return this.interestrate;
	}
}
// BankAccount class end here

class TestBankAccount
{
	public static void main (String args[])
	{

		//--------------------Object 1 -----------------default
		BankAccount b1 = new BankAccount();

		b1.setaccNo(5846);
		b1.setholderName("Rohit");
		b1.setcurrentBalance(8700);
		b1.setinterestRate(0.06);

		System.out.println("AccNo : " + b1.getaccNo());
		System.out.println("HolderName : " + b1.getholderName());
		System.out.println("CurrentBalance : " + b1.getcurrentBalance());
		System.out.println("Interestrate : " + b1.getinterestRate());


		 // ------- Object 2 ------- Parameterised.
		BankAccount b2 = new BankAccount(1234,"Seema",10000,0.07);
		

		
		// ------- Object 3 (User Input) -------

		Scanner sc = new Scanner(System.in);

		BankAccount b3 = new BankAccount();

		System.out.println("Enter acc no : ");
		b3.setaccNo(sc.nextInt());

		sc.nextLine();
		System.out.println("Holder Name : ");
		b3.setholderName(sc.nextLine());

		System.out.println("Enter current balance : ");
		b3.setcurrentBalance(sc.nextDouble());
	
		System.out.println("Enter interestrate : ");
		b3.setinterestRate(sc.nextDouble());

        	System.out.println("\n--- User Entered Account Details ---");
        	b3.display();

		


	}
}
