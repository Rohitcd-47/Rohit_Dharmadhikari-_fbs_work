class PlacedStudent
{
	int frn;
	String name,companyname,designation;
	double distance;
	
	
	void display()
	{
		System.out.println("Student FRN No : " + frn + "\nName : " + name + "\nDistance : " + distance + "km" + 					   "\nCompany_Name : " + companyname + "\nDesignation : " + designation);
	}

}//PlacedStudent class ends here

class TestPlacedStudent
{
	public static void main(String args[])
	{
		PlacedStudent p1;
		p1 = new PlacedStudent();
		p1.frn = 005;
		p1.name = "Rohit";
		p1.distance = 12.5;
		p1.companyname = "FirstBit";
		p1.designation = "Java Full-Stack Developer";
		
		p1.display();
	}
}
//  PlacedTestStudent class ends here.