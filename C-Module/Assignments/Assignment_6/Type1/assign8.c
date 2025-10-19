//9. Write a C program to input the base and height of a triangle and calculate its area.

#include <stdio.h>
void triangle();
void main()
{
	triangle();
}
void triangle()
{
	int b,h;
	printf("Enter base and height = ");
	scanf("%d %d",&b,&h);
	float area;
	
	area = 0.5 * (b*h);
	printf("The area of triange with base = %d and height = %d is = %f",b,h,area);
	
}