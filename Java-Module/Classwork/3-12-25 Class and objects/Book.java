class Book
{
	int ISBN;
	String bName,author,category;
	double price;
	
	void display()
	{
		System.out.println("Book_ISBN : " + ISBN + "\nBook_name : "+ bName + "\nBook_author : " + author + "\nCategory : " + category + "\nPrice : " + price);
	}

	
}//Book class ends here


class TestBook
{
	public static void main(String args[])
{
	Book b1 = new Book();
	Book b2 = new Book();

	b1.ISBN = 0123;
	b1.bName = "Rich Dad Poor Dad";
	b1.author = "Robert";
	b1.category = "Self-help";
	b1.price = 450;
	b1.display();
	b2.display(); 	
}
}//TestBook class ends here

