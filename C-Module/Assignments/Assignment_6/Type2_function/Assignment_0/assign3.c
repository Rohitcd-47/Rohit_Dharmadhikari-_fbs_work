//4. Write a C program to swap two numbers using a temporary third variable.

#include <stdio.h>
int swapnumber();
int main()
{
	int output = swapnumber();
	printf("After swap, numbers b = %d",output);
}
int swapnumber()
{
	int a,b,c;
	printf("Enter two numbers :");
	scanf("%d %d",&a,&b);
	printf("Before swap a = %d and b= %d \n",a,b);	
	int temp;
	temp = a;
	a = b;
	b = temp;
	
	
	return b;
	
}