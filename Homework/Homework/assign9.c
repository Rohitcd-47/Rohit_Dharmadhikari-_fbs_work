//9. Write a C program to input the base and height of a triangle and calculate its area.

#include <stdio.h>
int main()
{
	int base = 5, height = 7;
	float area;
	
	area = 0.5 * (base*height);
	printf("The area of triange with base = %d and height = %d is = %f",base,height,area);
	return 0;
}