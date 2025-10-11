//10. Print a hollow square with diagonal pattern
//Input: n = 5
//Output:
//
//* * * * *
//* * 	  *
//*  * 	  *
//*    *  *
//* * * * *

#include <stdio.h>
void main()
{
	int n = 5;
	for(int i=1;i<=n;i++)
	{
		for(int j=1;j<=n;j++)
		{
			if(i==1 || i==n || j==n || j==1 ||i==j)
			{
				printf("* ");
			}
			else
			{
				printf("  ");
			}	
		}
		printf("\n");
	}
}
