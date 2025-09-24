
//6. Write a C program to find the square and cube of a given number.

#include <stdio.h>
int main()
{
	int n1 = 2;
	int square ,cube;
	
	square = n1*n1;
	cube = square*n1;
	
	printf("The square of %d is %d and  cube of %d is %d",n1,square,n1,cube);
	return 0;
}