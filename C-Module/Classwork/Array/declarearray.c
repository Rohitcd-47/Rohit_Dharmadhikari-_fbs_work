#include <stdio.h>
void main()
{
	int arr[5];
	printf("Enter five elements = ");
	for(int i=0;i<5;i++)
	{
		scanf("%d",&arr[i]);
	}
	printf("\n"); 
	
	for(int i=0;i<5;i+=2)
	{
		printf("Value in array at index %d = %d \n",i,arr[i]);
	}
	printf("\n");
	
	
	int number,flag=1;
	printf("Enter the number to be found: ");
	scanf("%d",&number);
	
	for(int i=0;i<5;i++)
	{
		if(number==arr[i])
		{
			printf("Present at index : %d",i);
			flag--;
			break;
		}
	}
	
	if(flag==1)
	{
		printf("Not found");
	}
}


