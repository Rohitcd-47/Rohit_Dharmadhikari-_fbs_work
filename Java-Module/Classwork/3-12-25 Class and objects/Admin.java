class Admin
{
	int id;
	String name;
	double salary,allowance;

	void display()
	{
		System.out.println("Admin_id : " + id + "\nName : "+ name + "\nAdmin_salary : " +  salary + "\nAdmin_allowance : " + 				allowance);
	}

}//admin class ends here


class TestAdmin
{

	public static void main(String args[])
	{

		Admin a1 = new Admin();
		a1.id = 05;
		a1.name = "Rohit";
		a1.salary = 45000;
		a1.allowance = 7000;
		a1.display();

		Admin a2 = new Admin();
		a2.display();
	}

}



