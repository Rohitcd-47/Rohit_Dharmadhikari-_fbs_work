//3. Write a C program to convert temperature from Celsius to Fahrenheit using the formula:
//F = (C *9/5) + 32

#include <stdio.h>
void temperature(int*);
void main()
{
	int celsius;
	printf("Enter the temperature in celsius = ");
	scanf("%d",&celsius);
	temperature(&celsius);
}
void temperature(int* c)
{	
	int f = (*c*9/5) + 32;
	printf("The temperature %d  in Fahrenheit is %d",*c,f);
	
}
