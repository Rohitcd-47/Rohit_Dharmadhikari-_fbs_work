#include <stdio.h>

void add();
void main()
{
	add();
}
void add()
{
	int n1,n2,result;
	printf("Enter two numbers = ");
	scanf("%d %d",&n1,&n2);
	result = n1+n2;
	printf("The addition of two numbers is %d",result);
	
}