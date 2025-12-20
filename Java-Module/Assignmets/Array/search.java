import java.util.Scanner;

class Searchnumber
{
	public static void main(String args[])
	{
		int[] arr = new int[4];
		Scanner sc = new Scanner(System.in);

		
		for(int i=0; i<arr.length; i++)
		{
			arr[i] = sc.nextInt();
		}

		System.out.println();
		System.out.print("Enter the element you want to search : ");
		int search  =  sc.nextInt();

		boolean found = false;   // flag

		for(int i=0;i<arr.length;i++)
		{
			if(arr[i] == search)
			{
				System.out.print("Number found at index : " + search + " : " + i);
				found = true;
				break;
			}
			if(!found)
        		{
            			System.out.println("Not Found");
			}
        	
		}

	}
		

}