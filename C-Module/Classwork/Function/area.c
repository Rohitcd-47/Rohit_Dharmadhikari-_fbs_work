//2. Write a C program to find the area of a circle.

#include <stdio.h>

void area();
void main()
{
	area();
}
void  area()
{
	float pie = 3.14;
	int r;
	float area;
	printf("Enter the radius = ");
	scanf("%d",r);
	
	area = pie*r*r;
	printf("The area of the circle whose radius is %d = %f",r,area);
}