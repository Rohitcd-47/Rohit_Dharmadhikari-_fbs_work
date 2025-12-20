
import java.util.Scanner;

class Maxminnumbers
{
	public static void main(String args[])
	{
		int[] arr = new int[4];
		Scanner sc = new Scanner(System.in);

		
		for(int i=0; i<arr.length; i++)
		{
			arr[i] = sc.nextInt();
		}

		int min = arr[0];
		int max = arr[0];
		for (int i = 0; i <arr.length; i++)
		{
			if(arr[i] < min)
			min = arr[i];
			
			if(arr[i] > max)
			max = arr [i];
			
		}	

		System.out.print("Maximum number : " + max + "\n" + "Minimum number : " + min);
		System.out.println();
		for(int i=0; i<arr.length; i++)
		{
			System.out.print(" " + arr[i]);
		}

		

	}
}//class Maxminnumbers ends here..