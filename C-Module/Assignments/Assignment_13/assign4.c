//4. Find odd and even among the numbers.

#include <stdio.h>
void evenodd(int*);
void main()
{
	int* arr = (int*)malloc(sizeof(int)*5);
	printf("Enter elements = ");
	for(int i=0;i<5;i++)
	{
		scanf("%d",&arr[i]);
	}
	evenodd(arr);
}

void evenodd(int* arr)
{
	for(int i=0;i<5;i++)
	{
		(arr[i] %2 == 0) ? printf("\nEven = %d",arr[i]) : printf("\nOdd = %d",arr[i]);
	}
	
}