//6. Write a program to check whether a given character is uppercase or lowercase.

#include <stdio.h>
void upplow(char*);
void main()
{
	char alphabet;
	printf("Enter the character : ");
	scanf("%c",&alphabet);
	upplow(&alphabet);
}
void upplow(char*E ch)
{

		if (*ch >= 'A' && *ch <= 'Z')
	{
		printf("This char is uppercase");
	}
	else
	{
		printf("This char is lowercase");
	}
}








