class ArrayAddition
{
    public static void main(String[] args)
    {
        int[] arr = {1, 2, 3, 4, 5};
        int[] brr = {10, 20, 30, 40, 50};
        int[] crr = new int[5];

        // adding elements
        for(int i = 0; i < 5; i++)
        {
            crr[i] = arr[i] + brr[i];
        }

        // printing result
        for(int i = 0; i < 5; i++)
        {
            System.out.print(crr[i] + " ");
        }
    }
}//class arrayaddition ends here

