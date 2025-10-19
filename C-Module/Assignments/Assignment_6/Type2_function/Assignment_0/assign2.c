//2. Write a C program to find the area of a circle.

#include <stdio.h>
int area();
int main()
{
	int output = area();
	printf("The area of the circle is = %d",output);
}
int area()
{
	float pie = 3.14;
	int r;
	scanf("%d",&r);
	float area;
	
	area = pie*r*r;
	
	return area;
}