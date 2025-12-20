class BankAccount 
{
	double accNo, currentBalance, interestRate;
	String holderName;
	
	BankAccount()
	{
		this.accNo = 1;
		this.holderName = "Akshay";
		this.currentBalance = 100;
		this.interestRate = 0.06;
	
		System.out.println("default constructor get call"+"\n");
	}
	
	BankAccount(double aNo, double balance, double rate, String name)
	{
		this.accNo = aNo;
		this.currentBalance = balance;
		this.interestRate = rate;
		this.holderName = name;
	
		System.out.println("\n"+"parameterized constructor get call");
	}
	
	void setAccNo(double b)
	{
		this.accNo = b;
	}
	
	void setCurrentBalance(double b)
	{
		this.currentBalance = b;
	}
	
	void setInterestRate (double b)
	{
		this.interestRate = b;
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
		BankAccount B1;
		
		B1 = new BankAccount ();

		B1.setAccNo (5846);
		B1.setHolderName ("Rohit");
		B1.setCurrentBalance (10000);
		B1.setInterestRate  (0.07);
		
		System.out.println("Account no: "+B1.getAccNo());
		System.out.println("Current Balance: "+B1.getCurrentBalance());
		System.out.println("Interest Rate: "+B1.getInterestRate());
		System.out.println("Holder Name: "+B1.getHolderName());
	
		BankAccount B2 = new BankAccount (7856,4500,0.17,"Arnav");
	}
}//TestBankAccount class ends here