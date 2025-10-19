//1. Print a solid square pattern
//Input: n = 4
//Output:
//
//	* * * *
//	* * * *
//	* * * *
//	* * * *

#include <stdio.h>
void pattern();
void main()
{
	pattern();
}
void pattern()
{
	for(int i=0;i<4;i++)
	{
		for(int j=0;j<4;j++)
		{
			printf("* ");
		}
		printf("\n");
	}
}