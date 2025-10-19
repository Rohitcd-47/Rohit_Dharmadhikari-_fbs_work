//2. Write a C program to find the area of a circle.

#include <stdio.h>
void circle(int);
void main()
{
	int r;
	printf("Enter the radius of the circle = ");
	scanf("%d",&r);
	circle(r);
	
}
void circle(int r)
{
	float pie = 3.14;
	float area = pie*r*r;
	printf("The area of the circle whose radius is %d = %f",r,area);

}