//2 Print table for given number.
//Input: n = 5
//Output: 5 10 15 20 25 30 35 40 45 50

#include <stdio.h>
void table(int);
void main()
{
	int number=5;
	table(number);
}
void table(int n)
{
	while(n<=50)
	{
		printf("%d ",n);
		n = n+5;
	}
}