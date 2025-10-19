#include <stdio.h>

void evenodd(int);
void main()
{
	int number;
	printf("Enter the number = ");
	scanf("%d",&number);
	evenodd(number);
}
void evenodd(int num)
{
	if (num%2 == 0)
	{
		printf("number is even");
	}
	else
	{
		printf("Number is odd");
	}
}

