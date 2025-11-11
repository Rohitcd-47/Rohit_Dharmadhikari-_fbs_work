#include <stdio.h>
char replacechar(char*);
void main()
{
	char str[10] = "aadesh";
	char* result = replacechar(str);
	printf("Replace string is = %s",str);
}

char replacechar(char* str)
{

	int i = 0;
	while(str[i] != '\0')
	{
		if(str[i] == 'a')
			str[i] = '$';
		i++;
	}
	return str;	
}