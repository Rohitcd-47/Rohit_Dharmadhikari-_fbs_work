//1. Write a program to check whether a number is even or odd.

#include <stdio.h>
int evenodd();
int main()
{
	int output = evenodd();
	if(output==1)
	{
		printf("Even number");	
	}
	else
	{
		printf("Odd number");
	}
}
int evenodd()
{
	int num ;
	printf("Enter the number = ");
	scanf("%d",&num);
	
	if (num%2 == 0)
	{
		return 1;
	}
	else
	{
		return 0;
	}
}


