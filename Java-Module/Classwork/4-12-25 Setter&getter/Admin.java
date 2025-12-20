class Admin
{
	int id;
	String name;
	double salary,allowance;

	void display()
	{
		System.out.println("Admin_id : " + id + "\nName : "+ name + "\nAdmin_salary : " +  salary + "\nAdmin_allowance : " + 				allowance);
	}

	void setId(int d)
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

	void setAllowance(double d)
	{
		this.allowance = d;
	}



	int getId()
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

	double getAllowance()
	{
		return this.allowance;
	}

}//admin class ends here


class TestAdmin
{

	public static void main(String args[])
	{

		Admin a1 = new Admin();
		a1.setId(05);
		a1.setName("Rohit");
		a1.setSalary(45000);
		a1.setAllowance(7000);
	
		System.out.println("ID : " + a1.getId());
		System.out.println("Name : " + a1.getName());
		System.out.println("Salary : " + a1.getSalary());
		System.out.println("Allowance : " + a1.getAllowance());
		//a1.display();


	}

}



