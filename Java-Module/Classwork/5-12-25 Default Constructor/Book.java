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
	Book b1 = new Book();
	Book b2 = new Book();

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
	//b1.display();
	 	
}
}//TestBook class ends here

