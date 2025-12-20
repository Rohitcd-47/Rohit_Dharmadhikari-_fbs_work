
class BankAccount
{
	int accNo;
	String holderName;
	double currentBalance, interestrate;

	void display()
	{
		System.out.println("Account_no : "+ accNo + "\nHolderName : " + holderName + "\nCurrentBalance : " + currentBalance + "\nInterestRate : " + interestrate);
	}
}
// BankAccount class end here

class TestBankAccount
{
	public static void main (String args[])
	{
		BankAccount b1 = new BankAccount();
		b1.accNo = 5846;
		b1.holderName = "Rohit";
		b1.currentBalance = 8700;
		b1.interestrate = 0.06;
		b1.display();

		BankAccount b2 = new BankAccount();
		b2.display();
	}
}