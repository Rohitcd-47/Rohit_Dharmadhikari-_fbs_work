//1. Accept two numbers from user and an operator (+,-,/,*,%) based on that perform the desired operations.

#include <stdio.h>
void operations(int*,int*,char*);
void main()
{
	int number1,number2;
	printf("Enter two numbers : ");
	scanf("%d%d",&number1,&number2);
	char ch;
	printf("Select operation you want to (+ - * / %) : ");
	scanf(" %c",&ch);
	operations(&number1,&number2,&ch);
}
void operations(int* a,int* b,char* op)
{
	
	if(*op =='+')
	{
		printf("%d",*a+*b);
	}
	else if(*op=='-')
	{
		printf("%d",*a-*b);
	}
	else if(*op=='*')
	{
		printf("%d",*a**b);
	}
	else if(*op=='/')
	{
		printf("%d",*a/ *b);
	}
	
	else if(*op == '%')
	{
		printf("%d",*a%*b);
	}
	else
	{
		printf("Choice is invalid");
	}
	
}