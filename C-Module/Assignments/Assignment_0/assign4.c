//4. Write a C program to swap two numbers using a temporary third variable.

#include <stdio.h>
int main()
{
	int a = 3,b =54;
	int c;
	printf("Before swap, numbers are a = %d and b = %d",a,b);
	c = a;
	a = b;
	b = c;
	printf("\n");
	printf("After swap, numbers are a = %d and b = %d",a,b);
	
	return 0;
	
}