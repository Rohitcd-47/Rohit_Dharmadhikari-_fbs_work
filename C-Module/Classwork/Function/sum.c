//Write a C program to add two integers and display the result using function

#include <stdio.h>
void sum(); // fun declaration
void main() 
{
	sum(); // fun call
}
void sum() // fun defination
{
	int n1,n2,result;
	
	printf("Enter two numbers = ");
	scanf("%d %d",&n1,&n2);
	result = n1+n2;
	printf("The addition of two numbers %d and %d is %d",n1,n2,result);
 
}