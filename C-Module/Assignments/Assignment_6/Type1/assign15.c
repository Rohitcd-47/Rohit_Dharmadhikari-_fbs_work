//1. Accept two numbers from user and an operator (+,-,/,*,%) based on that perform the desired operations.

#include <stdio.h>
void calculate();
void main()
{
	calculate();
}
void calculate()
{

	int a,b;
	char op;
	
	printf("Enter two numbers = ");
	scanf("%d %d",&a,&b);
	
	printf("\n Select the operation = ");
	scanf(" %c",&op);
	
	if(op =='+')
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
	else if(op == '%')
	{
		printf("%d",a%b);
	}
	else
	{
		printf("Choice is invalid");
	}
	
}