import java.util.Scanner;

class Student
{
	int frn;
	String name;
	double distance;

	Student()
	{
		this.frn = 5;
		this.name = "Rohit";
		this.distance = 15;
		System.out.println("Inside Default");

	}
	
	Student(int d,String str,double dis)
	{
		this.frn = d;
		this.name = str;
		this.distance = dis;
		System.out.println("Inside Parameterized");

	}

	void display()
	{
		System.out.println("Student FRN No : " + frn + "\nName : " + name + "\nDistance : " + distance);
	}

	void setFrn(int d)
	{
		this.frn = d;
	}

	void setName(String d)
	{
		this.name = d;
	}

	void setDistance(double d)
	{
		this.distance = d;
	}


	int getFrn()
	{
		return this.frn;
	}

	String getName()
	{
		return this.name;	
	}

	double getDistance()
	{
		return this.distance;
	}


}//student class ends here

class TestStudent
{
    public static void main(String args[])
    {
        // -------- OBJECT 1 (Default + Setters) --------
        Student s1 = new Student();
        s1.setFrn(5);
        s1.setName("Rohit");
        s1.setDistance(12.5);

        System.out.println("\n--- S1 Details ---");
        System.out.println("FRN : " + s1.getFrn());
        System.out.println("Name : " + s1.getName());
        System.out.println("Distance : " + s1.getDistance());


        // -------- OBJECT 2 (Parameterized) --------
        Student s2 = new Student(1, "Rohit", 10);



        // -------- OBJECT 3 (User Input) --------
        Scanner sc = new Scanner(System.in);
        Student s3 = new Student();   // default → overwrite karenge

        System.out.print("\nEnter FRN : ");
        s3.setFrn(sc.nextInt());

        sc.nextLine(); // buffer clear

        System.out.print("Enter Name : ");
        s3.setName(sc.nextLine());

        System.out.print("Enter Distance : ");
        s3.setDistance(sc.nextDouble());

        System.out.println("\n--- USER ENTERED STUDENT DETAILS ---");
        s3.display();
    }
}
// TestStudent ends here