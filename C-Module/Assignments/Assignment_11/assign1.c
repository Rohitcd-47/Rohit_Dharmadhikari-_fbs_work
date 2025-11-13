//strcpy

#include <stdio.h>
#include <string.h>
void copystr(char*,char*);
void main()
{
    char str[50], dest[50];
    printf("Enter a string to copy: ");
    gets(str);

    copystr(dest, str);
    printf("Copied string = %s", dest);
} 

void copystr(char* dest,char* str)
{
	for(int i=0;  str[i] != '\0';  i++)
		dest[i] = str[i];
}