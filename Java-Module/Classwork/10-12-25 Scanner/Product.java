import java.util.Scanner;

class Product
{
    int PID, quantity;
    String PName;

    Product()
    {
        this.PID = 10;
        this.quantity = 101;
        this.PName = "Pulsar";
        System.out.println("Inside Default");
    }

    Product(int p, String str, int q)
    {
        this.PID = p;
        this.quantity = q;
        this.PName = str;
        System.out.println("Inside Parameterized");
    }

    void display()
    {
        System.out.println("Product_id : " + PID +
                "\nProduct_Name : " + PName +
                "\nQuantity : " + quantity);
    }

    void setPID(int d){ this.PID = d; }
    void setPName(String d){ this.PName = d; }
    void setQuantity(int d){ this.quantity = d; }

    int getPID(){ return this.PID; }
    int getQuantity(){ return this.quantity; }
    String getPName(){ return this.PName; }
} // Product class ends here




class TestProduct
{
    public static void main(String args[])
    {
        // ----------- Object 1 (Default + Setters) -----------
        Product p1 = new Product();

        p1.setPID(101);
        p1.setPName("Pulsar");
        p1.setQuantity(200);

        System.out.println("\n--- P1 Details ---");
        System.out.println("Product_id : " + p1.getPID());
        System.out.println("Product_name: " + p1.getPName());
        System.out.println("Product_qty : " + p1.getQuantity());


        // ----------- Object 2 (Parameterized) -----------
        Product p2 = new Product(1, "Bajaj", 21);



        // ----------- Object 3 (User Input) -----------
        Scanner sc = new Scanner(System.in);

        Product p3 = new Product();   // default → user input overwrite karega

        System.out.print("\nEnter Product ID : ");
        p3.setPID(sc.nextInt());

        sc.nextLine();  // buffer clear

        System.out.print("Enter Product Name : ");
        p3.setPName(sc.nextLine());

        System.out.print("Enter Quantity : ");
        p3.setQuantity(sc.nextInt());

        System.out.println("\n--- User Entered Product Details ---");
        p3.display();
    }
} // TestProduct class ends here
