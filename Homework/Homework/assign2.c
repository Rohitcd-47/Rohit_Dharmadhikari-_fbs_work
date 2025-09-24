//2. Write a C program to find the area of a circle.

#include <stdio.h>

int main()
{
	float pie = 3.14;
	int r = 4;
	float area;
	
	area = pie*r*r;
	printf("The area of the circle whose radius is %d = %f",r,area);
	return 0;
}