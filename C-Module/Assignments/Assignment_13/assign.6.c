//6. Accept array and print only prime numbers of array.

#include <stdio.h>
#include <math.h>

void primenum(int*,int);
void main()
{
	int* arr = (int*)malloc(sizeof(int)*5);
	printf("Enter elements = ");
	for(int i=0;i<4;i++)
	{
		scanf("%d",&arr[i]);
	}
	
	primenum(arr,4);
}
void primenum(int* arr,int size)
{
	for(int i = 0; i < size; i++)
    {
        if(arr[i] <= 1)
            continue; 

        int flag = 1;  

        for(int j = 2; j<=sqrt(arr[i]); j++)
        {
            if(arr[i] % j == 0)
            {
                flag = 0; 
                break;
            }
        }

        if(flag == 1)
            printf("%d ", arr[i]);
    }
}

