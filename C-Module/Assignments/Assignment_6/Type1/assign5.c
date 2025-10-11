//6. Write a C program to find the square and cube of a given number.

#include <stdio.h>
void cube();
void main()
{
	cube();
}
void cube()
{
	int n1;
	int square ,cube;
	printf("Enter number = ");
	scanf("%d",&n1);
	square = n1*n1;
	cube = square*n1;
	
	printf("The square of %d is %d and  cube of %d is %d",n1,square,n1,cube);
	
}