class BankAccount 
{
	double accNo, currentBalance;
	static double interestRate;
	String holderName;

	static 
	{
		interestRate = 8.2;
	}
	
	BankAccount()
	{
		this.accNo = 1;
		this.holderName = "Akshay";
		this.currentBalance = 100;
	
		//System.out.println("default constructor get call"+"\n");
	}
	
	BankAccount(double aNo,String name, double balance)
	{
		this.accNo = aNo;
		this.holderName = name;
		this.currentBalance = balance;
					
		//System.out.println("\n"+"parameterized constructor get call");
	}
	
	

        void display()
	{
		System.out.println("Account_no : "+ accNo + "\nHolderName : " + holderName + "\nCurrentBalance : " + currentBalance + 	"\nInterestRate : " + interestRate);
	}
	void setAccNo(double b)
	{
		this.accNo = b;
	}
	
	void setCurrentBalance(double b)
	{
		this.currentBalance = b;
	}
	
	static void setInterestRate (double b)
	{
		interestRate = b;
	}
	
	void setHolderName(String b)
	{
		this.holderName = b;
	}
	

	double getAccNo()
	{
		return this.accNo;	
	}
	
	double getCurrentBalance()
	{
		return this.currentBalance;
	}
	
	double getInterestRate()
	{	
		return this.interestRate;
	}
	
	String getHolderName()
	{
		return this.holderName;
	}	
	
}// BankAccount class ends here

class TestBankAccount
{
	public static void main (String [] args)
	{
		BankAccount B1,B2,B3;
		
		B1 = new BankAccount (1,"Rohit",10000);
		System.out.println();
		B1.display();

		B2 = new BankAccount (2,"Sakshi",50000);
		System.out.println();
		B2.display();

		B3 = new BankAccount (3,"Arnav",1);
		System.out.println();
		B3.display();

		BankAccount.setInterestRate(7.5);
		System.out.println();
		B1.display();
		
		System.out.println();
		B2.display();
	
		
	}
}//TestBankAccount class ends here