//1. Write a program to check whether a number is even or odd.

#include <stdio.h>
void evenodd();
void main()
{
	evenodd();
}

void evenodd()
{
	int num;
	printf("Enter the number = ");
	scanf("%d",&num);
	
	if (num%2 == 0)
	{
		printf("number is even");
	}
	else
	{
		printf("Number is odd");
	}
}
