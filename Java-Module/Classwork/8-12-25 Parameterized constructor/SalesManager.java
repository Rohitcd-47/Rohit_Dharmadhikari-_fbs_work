
class SalesManager
{
	int id,target;
	String name;
	double incentive,salary;

	SalesManager()
	{
		this.id = 1;
		this.target = 10;
		this.name  = "Rohit";
		this.incentive = 0.12;
		this.salary = 35000;
		System.out.println("Inside Default");

	}

	SalesManager(int i,String str,int t,double s,double in)
	{
		this.id = i;
		this.target = 10;
		this.name  = str;
		this.incentive = in;
		this.salary = s;
		System.out.println("Inside Parameterized");

	}

	void display()
	{
		System.out.println("SalesManager_id : " + id + "\nSalesManager_name : " + name + "\nTargets : " + target +"\nSalary : " + salary + "Incentive : " + incentive);
	}

	void setId(int d)
	{
		this.id = d;
	}
	void setName(String d)
	{
		this.name = d;
	}
	void setTarget(int d)
	{
		this.target = d;
	}
	void setSalary(double d)
	{
		this.salary = d;
	}
	void setIncentive(double d)
	{
		this.incentive = d;
	}



	int getId()
	{
		return this.id;
	}
	String getName()
	{
		return this.name;
	}
	int getTarget()
	{
		return this.target;
	}
	double getSalary()
	{
		return this.salary;
	}
		
	double getIncentive()
	{
		return this.incentive;
	}
} // SalesManager class ends here

class TestSalesManager
{
	public static void main(String args[])
	{

		SalesManager s1,s2;
		s1 = new SalesManager();

		s1.setId(05);
		s1.setName("Rohit");
		s1.setTarget(12);
		s1.setSalary(125000);
		s1.setIncentive(0.12);
	
		System.out.println("Id : " + s1.getId());
		System.out.println("Name : " + s1.getName());
		System.out.println("Target : " + s1.getTarget());
		System.out.println("Salary : " + s1.getSalary());
		System.out.println("Incentive : " + s1.getIncentive());

		//s1.display();

		s2 = new SalesManager(1,"Rohit",10,25000,0.13);

			
		
	}
}
