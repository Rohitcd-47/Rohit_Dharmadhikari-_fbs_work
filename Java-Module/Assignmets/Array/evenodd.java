import java.util.Scanner;

class EvenOdd
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
	
		for(int i=0; i<arr.length; i++)
		{
			if(arr[i] % 2 == 0)
				System.out.println("Even : " + arr[i]);
			else
				System.out.println("Odd : " + arr[i]);

		}
		
	}
}