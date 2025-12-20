class PlacedStudent
{
	int frn;
	String name,companyname,designation;
	double distance;
	
	
	void display()
	{
		System.out.println("Student FRN No : " + frn + "\nName : " + name + "\nDistance : " + distance + "km" + 					   "\nCompany_Name : " + companyname + "\nDesignation : " + designation);
	}

	void setFrn(int d)
	{
		this.frn = d;
	}
	void setName(String d)
	{
		this.name = d;
	}
	void setcompanyName(String d)
	{
		this.companyname = d;
	}
	void setDesignation(String d)
	{
		this.designation = d;
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
	
	String getcompanyName()
	{
		return this.companyname;
	}
	String getDesignation()
	{
		return this.designation;
	}

	double getDistance()
	{
		return this.distance;	
	}


}//PlacedStudent class ends here

class TestPlacedStudent
{
	public static void main(String args[])
	{
		PlacedStudent p1;
		p1 = new PlacedStudent();

		p1.setFrn(005);
		p1.setName("Rohit");
		p1.setDistance(12.5);
		p1.setcompanyName("FirstBit");
		p1.setDesignation("Java Full-Stack Developer");
		

		System.out.println("FRN : "+p1.getFrn());
		System.out.println("Name "+ p1.getName());
		System.out.println("Distance "+p1.getDistance());
		System.out.println("CompanyName "+p1.getcompanyName());
		System.out.println("Designation "+p1.getDesignation());
		
		//p1.display();
	}
}
//  PlacedTestStudent class ends here.