class Product
{
	int PID,quantity;
	String PName;
	
	void display()
	{
		System.out.println("Product_id : " + PID + "\nProduct_Name : " + PName + "\nQuantity : " + quantity);	
	}
	
}// Product class ends here


class TestProduct
{
	public static void main (String args[])
	{
		Product p1 = new Product();
		p1.PID = 101;
		p1.PName = "Pulsar";
		p1.quantity = 200;
		p1.display();

		Product p2 = new Product();
		p2.display();
	}
}//TestProduct class ends here

