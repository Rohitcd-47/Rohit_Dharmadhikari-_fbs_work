class MergeArrays
{
    public static void main(String[] args)
    {
        int[] arr = {1, 2, 3, 4};
        int[] brr = {11, 22, 33};
        int[] crr = new int[7];


        for(int i = 0; i < 4; i++)
        {
            crr[i] = arr[i];
        }


        for(int i = 0, j = 4; i < 3; i++, j++)
        {
            crr[j] = brr[i];
        }

   
        for(int i = 0; i < 7; i++)
        {
            System.out.print(crr[i] + " ");
        }
    }
}//class mergearray ends here
