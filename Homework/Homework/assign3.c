//3. Write a C program to convert temperature from Celsius to Fahrenheit using the formula:
//F = (C *9/5) + 32

#include <stdio.h>
int main()
{
	int f,c=22;
	f = (c*9/5) + 32;
	printf("The temperature %d  in Fahrenheit is %d",c,f);
	return 0;
}
