
//8. Write a C program to input the length and width of a rectangle and find its perimeter.

#include <stdio.h>
void rect();
void main()
{
	rect();
}
void rect()
{
	int length,width;
	printf("Enter the length and width of the rectangle = ");
	scanf("%d %d",&length,&width);
	int perimeter;
	
	perimeter = 2*(length+width);
	printf("The perimeter of rectangle whose length is %d and width is %d = %d",length,width,perimeter);

}