//8. Merge two arrays

#include <stdio.h>
void main()
{
	
	int arr[4] = {1,2,3,4};
	int brr[3] = {11,22,33};
	int crr[7];
	
	for(int i=0;i<4;i++)
	{
		crr[i] = arr[i];
	}
	
	
	for(int i=0,j=4;i<3;i++,j++)
	{
		crr[j] = brr[i];
	}
	
	for(int i=0;i<7;i++)
	{
		printf("%d ",crr[i]);
	}
}