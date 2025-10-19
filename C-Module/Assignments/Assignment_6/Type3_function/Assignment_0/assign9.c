//9. Write a C program to input the base and height of a triangle and calculate its area.

#include <stdio.h>
void trianglearea(int,int);
void main()
{
	int base,height;
	printf("Enter the base and height for the triangle : ");
	scanf("%d %d",&base,&height);
	trianglearea(base,height);
}

void trianglearea(int base,int height)
{	
	float area = 0.5 * (base*height);
	printf("The area of triange with base = %d and height = %d is = %f",base,height,area);

}