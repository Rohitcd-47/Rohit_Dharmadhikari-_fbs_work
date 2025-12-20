import java.util.Scanner;
class HR
{
	int id;
	String name;
	double salary,commission;

	HR()
	{
		this.id = 1;
		this.name = "Rohit";
		this.salary = 25000;
		this.commission = 0.12;
		System.out.println("Inside Default");


	}


	HR(int d,String str, double s,double c)
	{
		this.id = d;
		this.name = str;
		this.salary = s;
		this.commission = c;
		System.out.println("Inside Parameterized");

	}
	
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
        // -------- Object 1 (Default + setters) --------
        HR h1 = new HR();

        h1.setId(5);
        h1.setName("Rohit");
        h1.setSalary(50000);
        h1.setCommission(0.12);

        System.out.println("ID : " + h1.getId());
        System.out.println("Name : " + h1.getName());
        System.out.println("Salary : " + h1.getSalary());
        System.out.println("Commission : " + h1.getCommission());


        // -------- Object 2 (Parameterized) --------
        HR h2 = new HR(1, "Rohit", 23000, 0.13);


        // -------- Object 3 (User Input) --------
        Scanner sc = new Scanner(System.in);
        HR h3 = new HR();   // default values overwrite karenge

        System.out.print("\nEnter HR ID : ");
        h3.setId(sc.nextInt());

        sc.nextLine(); // buffer clear

        System.out.print("Enter HR Name : ");
        h3.setName(sc.nextLine());

        System.out.print("Enter Salary : ");
        h3.setSalary(sc.nextDouble());

        System.out.print("Enter Commission : ");
        h3.setCommission(sc.nextDouble());

        System.out.println("\n--- User Entered HR Details ---");
        h3.display();
 
	}

}//class TestHR ends here ...........