//1. Accept two numbers from user and an operator (+,-,/,*,%) based on that perform the desired operations.

#include <stdio.h>
void main()
{
	int a = 20;
	int b = 5;
	
	char op = '/';
	if(op=='+')
	{
		printf("%d",a+b);
	}
	else if(op=='-')
	{
		printf("%d",a-b);
	}
	else if(op=='*')
	{
		printf("%d",a*b);
	}
	else if(op=='/')
	{
		printf("%d",a/b);
	}
	else
	{
		printf("%d",a%b);
	}
	
}