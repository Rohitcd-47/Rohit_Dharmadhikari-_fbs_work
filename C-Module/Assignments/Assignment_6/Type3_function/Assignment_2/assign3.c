//3. Write a program to find greatest of three numbers using nested if-else.

#include <stdio.h>
void greatestnumber(int,int,int);
void main()
{
	int number1,number2,number3;
	printf("Enter 3 numbers : ");
	scanf("%d%d%d",&number1,&number2,&number3);
	greatestnumber(number1,number2,number3);
}

void greatestnumber(int a,int b,int c)
{	
	if(a>b)
	{
		if(a>c)
		{
			printf("a is greater");
		}
		else
		{
			printf("c is greater");
		}
	}
	else
	{
		if (b>a)
		{
			if(b>c)
			{
				printf("b is greater");
			}
			else
			{
				printf("c is greater");
			}
		}
		
	}
}