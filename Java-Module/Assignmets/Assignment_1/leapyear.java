class leapyear
{	
	public static void main(String args[])
	{
		int year = 2100;
		if(year%4==0 && year%100 != 0 || year%400 == 0)
			System.out.printf("This is a leap year");
		else 
			System.out.printf("Not a leap year");
	}
	
}