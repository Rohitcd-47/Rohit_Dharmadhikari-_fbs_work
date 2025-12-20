import java.util.Scanner;

class ReverseArray
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array : ");
        int size = sc.nextInt();

        int[] arr = new int[size];

        System.out.println("Enter the elements in the array");
        for(int i = 0; i < size; i++)
        {
            arr[i] = sc.nextInt();
        }

    
        int temp;
        for(int i = 0, j = size - 1; i < size / 2; i++, j--)
        {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        System.out.print("Reversed array = ");
        for(int i = 0; i < size; i++)
        {
            System.out.print(arr[i] + " ");
        }
    }
}//reversearray class ends here
