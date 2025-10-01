//3. Write a program to find greatest of three numbers using nested if-else.

#include <stdio.h>
void main()
{
	int a = -113, b= 52, c = -703;
	
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