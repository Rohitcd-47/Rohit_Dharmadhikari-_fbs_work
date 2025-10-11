//5. Print an inverted pyramid pattern
//Input: n = 5
//Output:
//
//* * * * *
// * * * *
//  * * *
//   * *
//    *
#include <stdio.h>
void main ()
{
	int n = 5;
	for (int i=1;i<=5;i++)
	{
		for (int j=1;j<i;j++)
		{
			printf(" ");
		}
		for (int k=1;k<=6-i;k++)
		{
			printf("* ");
		}
		printf("\n");
	}
}


