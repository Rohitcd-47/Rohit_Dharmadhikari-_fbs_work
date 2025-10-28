//2. Search the given number in array.

#include <stdio.h>
void main()
{
	int arr[5];
	printf("Enter elements = ");
	for(int i=0;i<5;i++)
	{
		scanf("%d",&arr[i]);
	}
	
	printf("\nEnter the element you want to search : ");
	int number;
	scanf("%d",&number);
	
	for(int i=0;i<5;i++)
	{
		if(arr[i] == number)
		{
			printf("Number = %d found at index %d",number,i);
			break;
		}
		else
		{
			printf("Not found");
			break;
		}
	}
}