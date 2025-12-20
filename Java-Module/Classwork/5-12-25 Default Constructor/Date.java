class Date
{
	int day,month,year;
	String dow;

	
	Date()
	{
		this.day = 31;
		this.month = 10;
		this.year = 2003;
		this.dow = "Friday";
	}
	void display()
	{
		System.out.println("\n"+day + "/" + month + "/" + year + "/" + dow );
 	}


	void setDay(int d)
	{
		this.day = d;
	}
	
	void setMonth(int d)
	{
		this.month = d;
	}

	void setYear(int d)
	{
		this.year = d;
	}

	void setDow(String d)
	{
		this.dow = d;
	}


	int getDay()
	{
		return this.day;
	}

	int getMonth()
	{
		return this.month;
	}


	int getYear()
	{
		return this.year;
	}

	String getDow()
	{
		return this.dow;
	}

	
	
		
}

class TestDate
{
	public static void main(String args[])
	{
		Date d1,d2;
		d1 = new Date();
		d2 = new Date();

		d1.setDay(13);
		d1.setMonth(12);
		d1.setYear(2025);
		d1.setDow("Thursday");

		d2.setDay(4);
		d2.setMonth(12);
		d2.setYear(2025);
		d2.setDow("Thursday");

		d1.display();
		d2.display();

		if(d1.getDay() < d2.getDay())
			System.out.println("d1 is elder");
		else
			System.out.println("d2 is elder");


		if(d1.getMonth() < d2.getMonth())
			System.out.println("d1 is elder");
		else
			System.out.println("d2 is elder");


		if(d1.getYear() < d2.getYear())
			System.out.println("d1 is elder");
		else
			System.out.println("d2 is elder");	
		
	}
}