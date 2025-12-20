import java.util.Scanner;

class Alternate
{
	public static void main(String[] args)
	{
		int[] arr = new int[5];
		Scanner sc  = new Scanner(System.in);
		
		System.out.print("Enter elements : ");

	
		for(int i=0; i<arr.length; i++)
		{
			arr[i] = sc.nextInt();
		}
	
		for(int i=0; i<arr.length; i+=2)
		{
			System.out.print(" " + arr[i]);

		}
		
	}
}