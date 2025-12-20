class Student
{
	int frn;
	String name;
	double distance;
	
	void display()
	{
		System.out.println("Student FRN No : " + frn + "\nName : " + name + "\nDistance : " + distance);
	}

}//student class ends here

class TestStudent
{
	public static void main(String args[])
	{
		Student s1;
		s1 = new Student();
		s1.frn = 005;
		s1.name = "Rohit";
		s1.distance = 12.5;
		
		s1.display();
	}
}
//  TestStudent class ends here