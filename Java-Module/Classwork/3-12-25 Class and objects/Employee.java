class Employee
{
	int id;
	String name;
	double salary;
	
	void display()
	{
		System.out.println("Employee_id : " + id + "\nEmployee_name : " + name + "\nSalary : " + salary);
	}

}//Employee class ends here

class TestEmployee
{
	public static void main(String args[])
	{
		Employee e1,e2;
		e1 = new Employee();
		e1.id = 005;
		e1.name = "Rohit";
		e1.salary = 125000;
		
		e1.display();
		e2.display();
	}
}
//  TestEmployee class ends here