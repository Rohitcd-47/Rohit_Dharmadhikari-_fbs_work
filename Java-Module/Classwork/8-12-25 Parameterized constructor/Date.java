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
		System.out.println("Default constructor called\n");
	}

	Date(int d,int m,int y,String str)
	{
		this.day = d;
		this.month = m;
		this.year = y;
		this.dow = str;
		System.out.println("Parameterized constructor called\n");

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

		d1.setDay(13);
		d1.setMonth(12);
		d1.setYear(2025);
		d1.setDow("Thursday");


		d1.display();

		d2 = new Date(1,1,2025,"Wednesday");
		//d2.display();


	}
}