class Product
{
	int PID,quantity;
	String PName;
	

	Product()
	{
		this.PID = 10;
		this.quantity = 101;
		this.PName = "Pulsar";
		System.out.println("Inside Default");
	}

	Product(int p,String str,int q)
	{
		this.PID = p;
		this.quantity = q;
		this.PName = str;
		System.out.println("Inside Parameterized");
	}

	void display()
	{
		System.out.println("Product_id : " + PID + "\nProduct_Name : " + PName + "\nQuantity : " + quantity);	
	}

	void setPID(int d)
	{
		this.PID = d;
	}
	void setPName(String d)
	{
		this.PName = d;
	}
	void setQuantity(int d)
	{
		this.quantity = d;
	}


	int getPID()
	{
		return this.PID;
	}
	int getQuantity()
	{
		return this.quantity;
	}

	String getPName()
	{
		return this.PName;
	}
}// Product class ends here


class TestProduct
{
	public static void main (String args[])
	{
		Product p1 = new Product();
		p1.setPID(101);
		p1.setPName("Pulsar");
		p1.setQuantity(200);

		//p1.Display();
		System.out.println("Product_id : " + p1.getPID());
		System.out.println("Product_name: " + p1.getPName());
		System.out.println("Product_qty : " + p1.getQuantity());

		Product p2 = new Product(1,"Bajaj",21);

	}
}//TestProduct class ends here

