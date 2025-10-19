//4. Write a C program to swap two numbers using a temporary third variable.

#include <stdio.h>
void swap(int,int);
void main()
{
	int a,b;
	printf("Enter two number = ");
	scanf("%d %d",&a,&b);
	printf("Before swap, numbers are a = %d and b = %d",a,b);
	swap(a,b);
}

void swap(int a,int b)
{
	int temp;
	temp = a;
	a = b;
	b = temp;
	printf("\n");
	printf("After swap, numbers are a = %d and b = %d",a,b);	
}