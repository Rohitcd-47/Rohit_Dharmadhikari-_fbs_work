//prime numbers in array
#include <stdio.h>
void main()
{
	int arr[4];
	
	//int flag = 0;
	for(int i=0;i<4;i++)
	{
		scanf("%d",&arr[i]);
	}
	//  0  1  2  3
	// 10 12 13 14
	
	for(int i=0;i<4;i++)
	{
		int flag = 0;
		if(arr[i]>2)
		for(int j=2;j<arr[i];j++)
		{
			if(arr[i] % j == 0)
			{
				flag++;
				j = arr[i];	
			}
		}
		if(flag==0)
		{
			printf("\n%d is a prime number.",arr[i]);
		}
	}

	
	
}