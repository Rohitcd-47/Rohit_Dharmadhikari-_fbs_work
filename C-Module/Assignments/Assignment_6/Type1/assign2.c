//2. Write a C program to find the area of a circle.

#include <stdio.h>
void area();
void main()
{
	area();
}
void area()
{
	float pie = 3.14;
	int r,area;
	printf("Enter radius of the circle = ");
	scanf("%d",&r);	
	area = pie*r*r;
	printf("The area of the circle whose radius is %d = %d",r,area);
}