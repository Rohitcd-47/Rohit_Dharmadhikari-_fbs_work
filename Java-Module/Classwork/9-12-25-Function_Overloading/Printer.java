class Printer
{
	void print()
	{
		System.out.println("Hello");
	}
	void print(int d)
	{
		System.out.println(d);
	}
	void print(char a)
	{
		System.out.println(a);
	}
	void print(String str)
	{
		System.out.println(str);
	}
}


class TestPrinter
{

	public static void main(String args[])
	{
		Printer p1 = new Printer();
		p1.print();
		p1.print(10);
		p1.print('a');		
		p1.print("fbs");
	}
}