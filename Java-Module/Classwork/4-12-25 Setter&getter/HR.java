class HR
{
	int id;
	String name;
	double salary,commission;
	
	void display()
	{
		System.out.println("HR_id : " + id + "\nHR_name : " + name + "\nSalary : " + salary + "\nCommission : " + commission);
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
	void setCommission(double d)
	{
		this.commission = d;
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
	double getCommission()
	{
		return this.commission;
	}

}//HR class ends here

class TestHR
{
	public static void main(String args[])
	{
		HR h1;
		h1 = new HR();

		h1.setId(005);
		h1.setName("Rohit");
		h1.setSalary(50000);
		h1.setCommission(12);
	
		System.out.println("ID : " + h1.getId());
		System.out.println("Name : " + h1.getName());
		System.out.println("Salary : "  + h1.getSalary());
		System.out.println("Commission : " + h1.getCommission());
		

	}
}
//  TestHR class ends here