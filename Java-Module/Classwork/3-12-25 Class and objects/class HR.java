class HR
{
	int id;
	String name;
	double salary,commission;
	
	void display()
	{
		System.out.println("HR_id : " + id + "\nHR_name : " + name + "\nSalary : " + salary + "\nCommission : " + commission);
	}

}//HR class ends here

class TestHR
{
	public static void main(String args[])
	{
		HR h1;
		h1 = new HR();
		h1.id = 005;
		h1.name = "Rohit";
		h1.salary = 50000;
		h1.commission = 12;
		
		h1.display();

		h2 = new HR();
		h2.display();
	}
}
//  TestHR class ends here