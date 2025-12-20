
class BankAccount
{
	int accNo;
	String holderName;
	double currentBalance;
	static double interestrate;
	
	static
	{
		interestrate = 7.7;
	}


	BankAccount()
	{
		this.accNo = 110011;
		this.holderName = "Rohit";
		this.currentBalance = 10000;
		//this.interestrate = 0.07;
		//System.out.println("Inside default constructor");

	}
	BankAccount(int d,String str,double c)
	{
		this.accNo =d;
		this.holderName = str;
		this.currentBalance = c;
		//this.interestrate = i;
		//System.out.println("\nInside Parameterized constructor");

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

	static void setinterestRate(double d)
	{
		interestrate = d;
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
		BankAccount b1 = new BankAccount(101,"Rohit",10000);
		
		BankAccount b2 = new BankAccount(102,"Seema",5000);
		BankAccount b3 = new BankAccount(34,"Atharv",1);

		b1.display();
		System.out.println();
		b2.display();	
		System.out.println();
		b3.display();
		System.out.println();

		BankAccount.setinterestRate(6.4);
		b1.display();
		System.out.println();
		b2.display();

	}
}
