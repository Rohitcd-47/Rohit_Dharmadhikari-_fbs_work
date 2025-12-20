class Student
{
	int frn;
	String name;
	double distance;

	Student()
	{
		this.frn = 5;
		this.name = "Rohit";
		this.distance = 15;
	}
	
	void display()
	{
		System.out.println("Student FRN No : " + frn + "\nName : " + name + "\nDistance : " + distance);
	}

	void setFrn(int d)
	{
		this.frn = d;
	}

	void setName(String d)
	{
		this.name = d;
	}

	void setDistance(double d)
	{
		this.distance = d;
	}


	int getFrn()
	{
		return this.frn;
	}

	String getName()
	{
		return this.name;	
	}

	double getDistance()
	{
		return this.distance;
	}






}//student class ends here

class TestStudent
{
	public static void main(String args[])
	{
		Student s1;
		s1 = new Student();
		s1.setFrn(005);
		s1.setName("Rohit");
		s1.setDistance(12.5);
		
		System.out.println("FRN : " + s1.getFrn());
		System.out.println("Name: " + s1.getName());
		System.out.println("Distance : " + s1.getDistance());

		s1.getDistance();

		//s1.display();
	}
}
//  TestStudent class ends here