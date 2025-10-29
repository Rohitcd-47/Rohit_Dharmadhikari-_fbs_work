
//6. Write a C program to find the square and cube of a given number.

#include <stdio.h>
void sqcube(int*);
void main()
{
	int number;
	printf("Enter the number :");
	scanf("%d",&number);
	sqcube(&number);
}
void sqcube(int* n1)
{
	int square ,cube;
	square = *n1 * *n1;
	cube = square* *n1;
	
	printf("The square of %d is %d and  cube of %d is %d",*n1,square,*n1,cube);
}