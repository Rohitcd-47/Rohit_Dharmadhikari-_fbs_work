//9. Reverse the given array.
#include <stdio.h>
void main()
{
	int size;
	printf("Enter the size of the array : ");
	scanf("%d",&size);
	int arr[size];
	printf("\nEnter the elements in the array ");
	
	for(int i=0;i<size;i++)
	{
		scanf("%d",&arr[i]);
	}
	
	
	int temp = 0;
	for(int i=0,j=size-1; i<size/2 ;i++,j--)
	{
		temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	printf("Reversed array = ");
	for(int i=0;i<size;i++)
	{
		printf("%d ",arr[i]);
	}
}