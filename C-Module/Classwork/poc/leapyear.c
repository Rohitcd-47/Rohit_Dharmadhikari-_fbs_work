// Year is leap or not

#include <stdio.h>

void main()
{
	int year = 2004;
	if(year % 4 ==0 && year%100 != 0 || year%100 == 0)
	{
		printf("Year is leap year");
	}
	else
	{
		printf("No leap year");
	}
}