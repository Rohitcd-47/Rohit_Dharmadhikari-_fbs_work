//4. Find odd and even among the numbers.

#include <stdio.h>
void main()
{
	int arr[5];
	printf("Enter elements = ");
	for(int i=0;i<5;i++)
	{
		scanf("%d",&arr[i]);
	}

	for(int i=0;i<5;i++)
	{
		if(arr[i] %2 == 0)
		{
			printf("\nEven : %d",arr[i]);
		}
		else 
		{
			printf("\nOdd : %d",arr[i]);
		}
	}
	
}

