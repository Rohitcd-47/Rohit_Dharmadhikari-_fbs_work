import java.util.Scanner;

class Sum
{
	public static void main(String[] args)
	{
		int[] arr = new int[5];
		Scanner sc  = new Scanner(System.in);
		
		System.out.print("Enter elements : ");

		int sum = 0;
		for(int i=0; i<arr.length; i++)
		{
			arr[i] = sc.nextInt();
		}
	
		for(int i=0; i<arr.length; i++)
		{
			sum = sum + arr[i];
		}
		System.out.print("Sum of all elements : " + sum);
	
	}
}