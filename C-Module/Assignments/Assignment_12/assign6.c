//6. WAP to Take in a String and Replace Every Blank Space with special symbol.

#include <stdio.h>
#include <string.h>

char* replacechar(char*);
void main()
{
	char str[50] = "Hey How are you ?";
	char* result = replacechar(str);
	printf("Replace string is = %s",str);
}

char* replacechar(char* str)
{
	int i = 0;
	while(str[i] != '\0')
	{
		if(str[i] == ' ')
			str[i] = '-';
		i++;
	}
	return str;	
}