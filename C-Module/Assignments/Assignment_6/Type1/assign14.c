
#include <stdio.h>
void upperlower();
void main()
{
	upperlower();
}

void upperlower()
{
	char ch;
	printf("Enter the character ");
	scanf("%c",&ch);
	
	if (ch >= 'A' && ch <= 'Z')
	{
		printf("This char is uppercase");
	}
	else
	{
		printf("This char is lowercase");
	}
}

