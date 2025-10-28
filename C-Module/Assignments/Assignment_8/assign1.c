//1. Find minimum and maximum number in array.

#include <stdio.h>
void main()
{
	int arr[5];
	printf("Enter elements ");
	for(int i=0;i<5;i++)
	{
		scanf("%d",&arr[i]);
	}
	
	int minimum = -1;
	int maximum = arr[0];
	
	for(int i=0;i<4;i++)
	{
		if(arr[i+1]>maximum)
		{
			maximum = arr[i+1];
			minimum = arr[i];
		}
		else if(minimum>arr[i+1])
		{
			minimum = arr[i+1];
		}
	}
	
	printf("Maximum number = %d  Minimum number = %d",maximum,minimum);
}