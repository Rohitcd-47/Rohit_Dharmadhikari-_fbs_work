import java.util.Scanner;

class PlacedStudent
{
    int frn;
    String name, companyname, designation;
    double distance;

    PlacedStudent()
    {
        this.frn = 5;
        this.name = "Rohit";
        this.companyname = "fbs";
        this.designation = "Student";
        this.distance = 15;
        System.out.println("Inside Default");
    }

    PlacedStudent(int f, String n, String c, String d, double ds)
    {
        this.frn = f;
        this.name = n;
        this.companyname = c;
        this.designation = d;
        this.distance = ds;
        System.out.println("Inside Parameterized");
    }

    void display()
    {
        System.out.println("Student FRN No : " + frn +
                "\nName : " + name +
                "\nDistance : " + distance + " km" +
                "\nCompany_Name : " + companyname +
                "\nDesignation : " + designation);
    }

    void setFrn(int d){ this.frn = d; }
    void setName(String d){ this.name = d; }
    void setcompanyName(String d){ this.companyname = d; }
    void setDesignation(String d){ this.designation = d; }
    void setDistance(double d){ this.distance = d; }

    int getFrn(){ return this.frn; }
    String getName(){ return this.name; }
    String getcompanyName(){ return this.companyname; }
    String getDesignation(){ return this.designation; }
    double getDistance(){ return this.distance; }


}//class PlacedStudent ends here

class TestPlacedStudent
{
    public static void main(String args[])
    {
        // --------- Object 1 (Default + Setters) ---------
        PlacedStudent p1 = new PlacedStudent();

        p1.setFrn(5);
        p1.setName("Rohit");
        p1.setDistance(12.5);
        p1.setcompanyName("FirstBit");
        p1.setDesignation("Java Full-Stack Developer");

        System.out.println("\n--- P1 Details ---");
        System.out.println("FRN : " + p1.getFrn());
        System.out.println("Name : " + p1.getName());
        System.out.println("Distance : " + p1.getDistance());
        System.out.println("Company Name : " + p1.getcompanyName());
        System.out.println("Designation : " + p1.getDesignation());


        // --------- Object 2 (Parameterized) ---------
        PlacedStudent p2 = new PlacedStudent(1, "Rohit", "fbs", "JFS", 10);




        // --------- Object 3 (User Input) ---------

        Scanner sc = new Scanner(System.in);
        PlacedStudent p3 = new PlacedStudent();  // default overwrite karenge

        System.out.print("\nEnter FRN Number : ");
        p3.setFrn(sc.nextInt());

        sc.nextLine(); // buffer clear

        System.out.print("Enter Student Name : ");
        p3.setName(sc.nextLine());

        System.out.print("Enter Company Name : ");
        p3.setcompanyName(sc.nextLine());

        System.out.print("Enter Designation : ");
        p3.setDesignation(sc.nextLine());

        System.out.print("Enter Distance (in km) : ");
        p3.setDistance(sc.nextDouble());

        System.out.println("\n--- User Entered Student Details ---");
        p3.display();
    }


}// class TestPlacedStudent ends here
