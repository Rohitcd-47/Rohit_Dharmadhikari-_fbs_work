//wap in c to find two max number in array

#include <stdio.h>

void main()
{
	int arr[5] = {11,6,77,43,210};
	int max = arr[0];
	int max2 = arr[1];
	
	
	for(int i=1;i<5;i++)
	{
		if(arr[i] > max)
		{
			max2 = max;
			max = arr[i];
		}
		else if(arr[i]<max && arr[i] >= max2)
		{
			max2 = arr[i];
		}
			
			
	}
	printf("First max = %d\nSecond max = %d",max,max2);
}