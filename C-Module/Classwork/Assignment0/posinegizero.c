//Find number is positive , -ve or 0

#include <stdio.h>
void main()
{
	int num = 0;
	if(num>0)
	{
		printf("Number is positive");
	}
	else
	{
		if(num==0)
		{
			printf("Number is equal to zero");
		}
		else
		{
			printf("Number is negative");
		}
	}
}