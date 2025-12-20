
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
		BankAccount b1 = new BankAccount();

		b1.setaccNo(5846);
		b1.setholderName("Rohit");
		b1.setcurrentBalance(8700);
		b1.setinterestRate(0.06);

		System.out.println("AccNo : " + b1.getaccNo());
		System.out.println("HolderName : " + b1.getholderName());
		System.out.println("CurrentBalance : " + b1.getcurrentBalance());
		System.out.println("Interestrate : " + b1.getinterestRate());



		
		//b1.display();


	}
}
