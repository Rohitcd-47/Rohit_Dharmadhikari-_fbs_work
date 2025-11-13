//strchr()

#include <stdio.h>
#include <string.h>

char* mystrchr(char*,char);
void main()
{
    char str[50] = "hello world";
    char *ptr = mystrchr(str, 'o');

    if(ptr)
        printf("First 'o' found at position: %ld", ptr - str + 1);
    else
        printf("Character not found");
}
char* mystrchr(char* str,char ch)
{
	int i=0;
	while(str[i] != '\0')
	{
		if(str[i] == ch)
			return &str[i];
		i++;
	}
	return NULL;
	
}