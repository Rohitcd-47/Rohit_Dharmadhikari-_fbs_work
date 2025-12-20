import java.util.Scanner

class Admin
{
	int id;
	String name;
	double salary,allowance;

	
	Admin()
	{
		this.id = 1;
		this.name = "Rohit";
		this.salary = 23000;
		this.allowance = 3500;
		System.out.println("Inside default constructor");
	}

	Admin(int d,String str,double s,double a)
	{
		this.id = d;
		this.name = str;
		this.salary = s;
		this.allowance = a;
		System.out.println("\nInside default constructor");
	}


	void display()
	{
		System.out.println("Admin_id : " + id + "\nName : "+ name + "\nAdmin_salary : " +  salary + "\nAdmin_allowance : " + allowance);
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


		Admin a2 = new Admin(1,"Rohit",23000.25,3500);


		Admin a3 = new Admin();
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter ID : ");
		a3.setId(sc.nextInt());

		sc.nextLine();
		System.out.println("Enter Name : ");
		a3.setName(sc.nextLine());

		System.out.println("Enter Salary : ");
		a3.setSalary(sc.nextDouble());

		System.out.println("Enter Allowance : ");
		a3.setAllowance(sc.nextDouble());


		System.out.println("\n--- Details Entered by User ---");
        	a3.display();

		

		
	}

}



