import java.util.Scanner;

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

		
}//class Date ends here

class TestDate
{
	public static void main(String args[])
	{
		Date d1,d2;
		//---------------object 1 (default)---------------
		d1 = new Date();

		d1.setDay(13);
		d1.setMonth(12);
		d1.setYear(2025);
		d1.setDow("Thursday");


		d1.display();

		//---------------object 2 (Parameterised)---------------
		d2 = new Date(1,1,2025,"Wednesday");
		//d2.display();


		//---------------object 3 (User-input)------------------------
		
		Date d3 = new Date();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter Day : ");
		d3.setDay(sc.nextInt());

		System.out.print("Enter Month : ");
		d3.setMonth(sc.nextInt());

		System.out.print("Enter Year : ");
		d3.setYear(sc.nextInt());

		sc.nextLine();
		System.out.print("Enter Dow : ");
		d3.setDow(sc.nextLine());

		System.out.println("\n--- User Entered Date Details ---");
        	d3.display();
  		
	}

}//class TestDate ends here...