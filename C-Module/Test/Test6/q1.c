// wap in c to find common elements in two array
// arr = {1,2,3,4,5}
// brr = {1,6,7,3,2}

#include <stdio.h>

void main()
{
	int arr[5] = {1,2,3,4,5};
	int brr[5] = {1,6,7,3,2};
	int crr[5];
	printf("Common elements : ");
	for(int i=0;i<5;i++)
	{
		for(int j=0;j<5;j++)
		{
			if(arr[i] == brr[j])
			{
				printf("%d ",arr[i]);
				break;
			}
		
		}
	}
}