#include <stdio.h>
void main()
{
	char ch = 'A';
	printf("%d\n",ch);
	
	
	if (ch >= 'A' && ch <= 'Z')
	{
		ch = ch + 32;
		printf("%c",ch);
	}
	else
	{
		ch = ch - 32;
		printf("%c",ch);
	}
}

