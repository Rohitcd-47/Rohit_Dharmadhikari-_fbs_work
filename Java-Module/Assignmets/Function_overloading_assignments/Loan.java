class Student
{
	int rollno;
	String name;
	double percentage;
	
	Student(int rollno, String name, double percentage)
	{
		this.rollno = rollno;
		this.name = name;
		this.percentage = percentage;
	}
}



class Employee
{
	int id;
	String name;
	double salary;
	
	Employee(int id,String name, double salary)
	{
		this.id = id;
		this.name = name;
		this.salary = salary;

	}
}


class Bank
{
	String approveloan(Student s1)
	{
		if(s1.percentage > 80)
			return "Loan approved : 2 lakh";

		else if(s1.percentage >= 60 && s1.percentage <=80)
			return "Loan approved : 1 lakh";

		else if (s1.percentage >=40 && s1.percentage <60)
			return "Loan approved : 50k";
	
		else
			return "Loan Not approved";
	}	



	String approveloan(Employee e1)
	{
		if(e1.salary > 1200000)
			return "Loan approved : 7 lakh";

		else if(e1.salary >= 1000000 && e1.salary <=1200000)
			return "Loan approved : 6 lakh";

		else if (e1.salary >=600000 && e1.salary <1000000)
			return "Loan approved : 5 lakh";
	
		else if(e1.salary>=400000 && e1.salary<600000)
			return "Loan approved : 4 lakh";

		else
			return "Loan not approved";
	}	

}

class TestBank
{
	
	public static void main()
	{

		Student s1 = new Student(5,"Rohit",85);
		Employee e1 = new Employee(101,"Rohit",500000);


		Bank b = new Bank();

		System.out.println("Student Loan: " + b.approveloan(s1));
	        System.out.println("Employee Loan: " + b.approveloan(e1));
	}
	
}