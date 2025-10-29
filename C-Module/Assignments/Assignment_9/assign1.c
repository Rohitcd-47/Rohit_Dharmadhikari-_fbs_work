#include <stdio.h>
void minmax(int*,int);
void main()
{
    int arr[5];
    printf("Enter the elements: ");
    for(int i = 0; i < 5; i++)
    {
        scanf("%d", &arr[i]);
    }
    minmax(arr, 5);
}

void minmax(int *arr, int size)
{
    int minimum = arr[0];
    int maximum = arr[0];
    
    for(int i = 1; i < size; i++)
    {
        if(arr[i] > maximum)
            maximum = arr[i];
        else if(arr[i] < minimum)
            minimum = arr[i];
    }
    
    printf("Maximum number = %d  Minimum number = %d", maximum, minimum);
}


