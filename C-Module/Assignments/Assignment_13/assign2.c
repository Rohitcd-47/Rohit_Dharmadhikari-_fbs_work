//2. Search the given number in array.

#include <stdio.h>
void search(int*,int,int*);
void main()
{
	int* arr = (int*)malloc(sizeof(int)*5);
	printf("Enter elements = ");
	for(int i=0;i<5;i++)
	{
		scanf("%d",&arr[i]);
	}
	
	printf("\nEnter the element you want to search : ");
	int number;
	scanf("%d",&number);
	
	search(arr,5,&number);
}

void search(int *arr,int size,int *number)
{
	int found = 0;
	for(int i=0;i<size;i++)
	{
		if(arr[i] == *number)
		{
			printf("Number = %d found at index %d",*number,i);
			found = 1;
			break;
		}
	}
	if(found == 0)
	{
		printf("Not found");
	}
}