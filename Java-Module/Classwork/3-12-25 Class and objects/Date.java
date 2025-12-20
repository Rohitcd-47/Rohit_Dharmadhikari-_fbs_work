class Date
{
	int day,month,year;
	String dow;
	void display()
	{
		System.out.println(day + "/" + month + "/" + year + "\nDOW " + dow);
 	}
}

class TestDate
{
	public static void main(String args[])
	{
		Date d1,d2;
		d1 = new Date();

		d1.day = 2;
		d1.month = 12;
		d1.year = 2025;	
		d1.dow = "Tuesday";
	
		d1.display();

		d2 = new Date();
		d2.display();
		
	}
}