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
		Employee e1,e2;
		e1 = new Employee();

		e1.setEmployeeid(5);
		e1.setName("Rohit");
		e1.setSalary(125000);
		
		System.out.println("Employee_id : " + e1.getEmployeeid());
		System.out.println("Employee_name: " + e1.getName());
		System.out.println("Employee_salary : " + e1.getSalary());
		//e1.display();
		
	}
}
//  TestEmployee class ends here