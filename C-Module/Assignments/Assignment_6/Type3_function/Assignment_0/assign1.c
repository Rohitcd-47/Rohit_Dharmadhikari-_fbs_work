//Write a C program to add two integers and display the result

#include <stdio.h>
void add(int,int);
void main()
{
	int number1,number2;
	printf("Enter two numbers = ");
	scanf("%d %d",&number1,&number2);
	add(number1,number2);
}
void add(int x,int y)
{
	
	int result = x+y;
	printf("Result = %d",result);
}