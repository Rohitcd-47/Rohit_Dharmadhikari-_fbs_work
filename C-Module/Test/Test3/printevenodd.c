//wap to print even and odd numbers in a given range

#include <stdio.h>
void main()
{
	for(int i=10;i<=25;i++)
	{
		if(i%2==0)
		{
			printf("Even number = %d \n",i);
		}
			
		
		else
		{
			printf("\n");
			printf("Odd number = %d \n",i);
			printf("\n");
		}
	}
	
}