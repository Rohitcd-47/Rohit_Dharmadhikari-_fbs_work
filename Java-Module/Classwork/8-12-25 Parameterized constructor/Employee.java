class Employee
{
	int id;
	String name;
	double salary;

	Employee()
	{
		this.id = 1;
		this.name = "Rohit";
		this.salary = 25000;
		System.out.println("Inside Default");

	}
	
	Employee(int d,String name, double s)
	{
		this.id = d;
		this.name = name;
		this.salary = s;
		System.out.println("Inside Parameterized");
	}

	void display()
	{
		System.out.println("Employee_id : " + id + "\nEmployee_name : " + name + "\nSalary : " + salary);
	}

	void setEmployeeid (int d)
	{
		this.id = d;
	}

	void setName(String d)
	{
		this.name = d;
	}
	void setSalary(double d)
	{
		this.salary = d;
	}


	int getEmployeeid()
	{
		return this.id;
	}
	String getName()
	{
		return this.name;
	}
	double getSalary()
	{
		return this.salary;
	}


	

}//Employee class ends here

class TestEmployee
{
	public static void main(String args[])
	{
		

		Employee[] earr = new Employee[3];
		earr[0] = new Employee();
		earr[1] = new Employee(1,"abc",2000);
		
		for(int i=0;i<earr.length; i++)
		{
			System.out.print(" " + earr[i]);
		}
		
	}
}
//  TestEmployee class ends here