import java.util.Scanner;

class PrimeNumbers
{
    public static void main(String[] args)
    {
        int[] arr = new int[5];
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter 5 numbers:");

        // taking input
        for(int i = 0; i < 5; i++)
        {
            arr[i] = sc.nextInt();
        }

        System.out.println("Prime numbers are:");

        // checking each number
        for(int i = 0; i < 5; i++)
        {
            int num = arr[i];
            int count = 0;

            if(num > 1)
            {
                for(int j = 1; j <= num; j++)
                {
                    if(num % j == 0)
                        count++;
                }

                if(count == 2)
                    System.out.println(num);
            }
        }
    }
}
