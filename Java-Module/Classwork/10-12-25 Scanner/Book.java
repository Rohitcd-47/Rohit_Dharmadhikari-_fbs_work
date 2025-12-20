import java.util.Scanner;
class Book
{
	int ISBN;
	String bName,author,category;
	double price;
	


	Book()
	{
		this.ISBN = 7077;
		this.bName = "Time Management";
		this.author = "B.Joseph";
		this.category = "Self-Help";
		this.price = 450;
		System.out.println("Inside Default");
	}
	
	Book(int d,String str,String a,String c,double p)
	{
		this.ISBN = d;
		this.bName = str;
		this.author = a;
		this.category =c;
		this.price = p;
		System.out.println("Inside Parameterized");
	}
	void display()
	{
		System.out.println("Book_ISBN : " + ISBN + "\nBook_name : "+ bName + "\nBook_author : " + author + "\nCategory : " + category + "\nPrice : " + price);
	}

	void setISBN(int d)
	{
		this.ISBN = d;
	}
	
	void setbName(String d)
	{
		this.bName = d;
	}
	
	void setAuthor(String d)
	{
		this.author = d;
	}

	void setCategory(String d)
	{
		this.category = d;
	}

	void setPrice(double d)
	{
		this.price = d;	
	}

	int getISBN()
	{
		return this.ISBN;
	}
	String getbName()
	{
		return this.bName;
	}
	String getAuthor()
	{
		return this.author;
	}

	String getCategory()
	{
		return this.category;
	}

	double getPrice()
	{
		return this.price;
	}
	
}//Book class ends here


class TestBook
{
	public static void main(String args[])
{
	// --------------Object 1 (default) ---------------------------
	Book b1 = new Book();

	// --------------Object 1 (Parameterised) ----------------------
	Book b2 = new Book(11,"Book","Me","self-help",500);

	b1.setISBN(0123);
	b1.setbName("Rich Dad Poor Dad");
	b1.setAuthor("Robert");
	b1.setCategory("Self-help");
	b1.setPrice(450);

	System.out.println("ISBN : " + b1.getISBN());
	System.out.println("Name : " + b1.getbName());
	System.out.println("Author : " + b1.getAuthor());
	System.out.println("Category : " + b1.getCategory());
	System.out.println("Price : " + b1.getPrice());
	

	// --------------Object 3 (User-input) ----------------------

	Book b3 = new Book();
	Scanner sc = new Scanner(System.in);
	System.out.println("\n\n");

	
	System.out.println("Enter ISBN code : ");
	b3.setISBN(sc.nextInt());

	sc.nextLine();
	System.out.println("Enter Book name : ");
	b3.setbName(sc.nextLine());

	sc.nextLine();
	System.out.println("Enter Author name : ");
	b3.setAuthor(sc.nextLine());

	
	System.out.println("Enter Category : ");
	b3.setCategory(sc.nextLine());

	System.out.println("Enter price :");
	b3.setPrice(sc.nextDouble());

	System.out.println("\n--- User Entered Account Details ---");
        b3.display();
	 	
}
}//TestBook class ends here

