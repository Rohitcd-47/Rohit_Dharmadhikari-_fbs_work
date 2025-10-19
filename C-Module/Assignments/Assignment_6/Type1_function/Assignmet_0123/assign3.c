//3. Write a C program to convert temperature from Celsius to Fahrenheit using the formula:
//F = (C *9/5) + 32

#include <stdio.h>
void convert();
void main()
{
	convert();
}
void convert()
{
	int f,c;
	printf("Enter the temperature = ");
	scanf("%d",&c);
	f = (c*9/5) + 32;
	printf("The temperature %d  in Fahrenheit is %d",c,f);

}
