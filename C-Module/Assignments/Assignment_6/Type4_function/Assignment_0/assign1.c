//Write a C program to add two integers and display the result

#include <stdio.h>
int add(int,int);
int main()
{
	int res = add(2,4);
	printf("Addition of 2 numbers = %d",res);
}

int add(int x,int y)
{
//	int a,b;
//	scanf("%d%d",&a,&b);
	return x+y;
}