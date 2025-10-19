//1 Print numbers from 1 to 10
//Output: 1 2 3 4 5 6 7 8 9 10

#include <stdio.h>
void numbers(int);
void main()
{
	int i=1;
	numbers(i);
}
void numbers(int i)
{
	while(i<=10)
	{
		printf("%d ",i);
		i++;
	}
}