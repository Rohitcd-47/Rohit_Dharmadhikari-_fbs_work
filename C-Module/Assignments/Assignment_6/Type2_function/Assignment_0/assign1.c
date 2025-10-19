//Write a C program to add two integers and display the result

#include <stdio.h>
int add();
int main()
{
	int res = add();
	printf("Addition of 2 numbers = %d",res);
}

int add()
{
	int a,b;
	scanf("%d%d",&a,&b);
	return a+b;
}