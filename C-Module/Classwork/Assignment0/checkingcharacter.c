// Find entered character is alphabet,digit or special symbols

#include <stdio.h>
void main()
{
	char ch = 's';
	if (ch>='A' && ch<=Z || ch>='a' && ch<='z' )
	{
		printf("Alphabet");
	}
	else
	{
		if(ch>='0' && ch<='9')
		{
			printf("Digits");
		}
		else
		{
			if(ch==" ")
			{
				printf("Char is space");
			}
			else
			{
				printf("Symbols");
				
			}
		}
	}
}