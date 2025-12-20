class Date
{
	int day,month,year;
	void display()
	{
		System.out.println(day + "/" + month + "/" + year);
 	}
}

class TestDate
{
	public static void main(String args[])
	{
		Date d1;
		d1 = new Date();
		d1.day = 2;
		d1.month = 12;
		d1.year = 2025;	
		
		d1.display();
		
		Date d2;
		d2 = new Date();

		d1 = new Date();
		d2.day = 3;
		d2.month = 12;
		d2.year = 2025;

		d2.display();
	}
}