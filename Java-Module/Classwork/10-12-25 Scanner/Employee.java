import java.util.Scanner;

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
		Employee e1,e2;

		//-------------------------object 1 (default) ----------------------------
		e1 = new Employee();

		e1.setEmployeeid(5);
		e1.setName("Rohit");
		e1.setSalary(125000);
		
		System.out.println("Employee_id : " + e1.getEmployeeid());
		System.out.println("Employee_name: " + e1.getName());
		System.out.println("Employee_salary : " + e1.getSalary());

		
		//--------------------object 2 (parameterized) ------------------------
		e2 = new Employee(1,"Rohit",50000);
		
		

		//--------------------object 3 (user-input)----------------------------

		Employee e3 = new Employee();
		Scanner sc = new Scanner(System.in);
		System.out.println("\n\n");
		
		System.out.print("Enter employee_id : ");
		e3.setEmployeeid(sc.nextInt());

		sc.nextLine();
		System.out.print("Enter name : ");
		e3.setName(sc.nextLine());

		System.out.print("Enter Salary : ");
		e3.setSalary(sc.nextDouble());

		System.out.println("User entered Employee Details\n");
		e3.display();
		
	}
}
//  TestEmployee class ends here