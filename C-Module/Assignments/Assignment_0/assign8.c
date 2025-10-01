
//8. Write a C program to input the length and width of a rectangle and find its perimeter.

#include <stdio.h>
int main()
{
	int length = 10;
	int width = 5;
	int perimeter;
	
	perimeter = 2*(length+width);
	printf("The perimeter of rectangle whose length is %d and width is %d = %d",length,width,perimeter);
	return 0;
}