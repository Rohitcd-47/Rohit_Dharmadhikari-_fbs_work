
class SalesManager
{
	int id,target;
	String name;
	double incentive,salary;

	void display()
	{
		System.out.println("SalesManager_id : " + id + "\nSalesManager_name : " + name + "\nTargets : " + target +"\nSalary : 		" + salary + "Incentive : " + incentive);
	}

		
} // SalesManager class ends here

class TestSalesManager
{
	public static void main(String args[])
	{

		SalesManager s1,s2;
		s1 = new SalesManager();

		s1.id = 005;
		s1.name = "Rohit";
		s1.target = 12;
		s1.salary = 125000;
		s1.incentive = 0.12;
		s1.display();

		s2 = new SalesManager();
		s2.display();	
		
	}
}
