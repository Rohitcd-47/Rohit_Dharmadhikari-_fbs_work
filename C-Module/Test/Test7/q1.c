// wap to accept array & exchange data of xth position to yth position
// arr[] = {11,23,30,4,21,45,50} 
// x = 3
// y = 5 using function

#include <stdio.h>
#include <string.h>
void exchange(int*,int,int);
void main()
{
	int arr[] = {11,23,30,4,21,45,50};
//	int x = 3;
//	int y = 5;
	exchange(arr,3,5);
}

void exchange(int* arr,int x,int y)
{
	for(int i=0;i<7;i++)
	{
		if(i == x-1)
		{
			int temp = arr[i];
			arr[i] = arr[y-1];
			arr[y-1] = temp;
			break;
		}
	}

	for(int i=0;i<7;i++)
	{
		printf("%d ",arr[i]);
	}	
}