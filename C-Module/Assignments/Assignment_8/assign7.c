//7. Take two array and add sum in third array
//
//Example-
//arr[5]= {1,2, 3, 4,5}
//
//brr[5]={10,20,30, 40, 50}
//crr[5]={11,22,33,44,55}


#include <stdio.h>
void main()
{
	int arr[5] = {1,2,3,4,5};
	int brr[5] = {10,20,30,40,50};
	int crr[5];
	
	
	for(int i=0;i<5;i++)
	{
		crr[i] = arr[i] + brr[i];
	}
	
	for(int i=0;i<5;i++)
	{
		printf("%d ",crr[i]);
	}
	
}