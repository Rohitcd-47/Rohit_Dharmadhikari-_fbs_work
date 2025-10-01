// Q3 Print last 2 digits of number

#include <stdio.h>
void main()
{
	int num = 223410;
	int rem;
	
	rem = num % 100;
	
	printf("%d",rem);
}