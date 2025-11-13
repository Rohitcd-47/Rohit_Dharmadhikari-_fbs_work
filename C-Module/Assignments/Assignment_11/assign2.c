// strncpy ()
#include <stdio.h>
#include <string.h>

void copynstr(char*,char*,int*);
void main()
{
    char str[50], dest[50];
    printf("Enter a string to copy: ");
    gets(str);

	int n;
	printf("Enter number till you want to copy :");
	scanf("%d",&n);
	
    copynstr(dest, str,&n);
    printf("Copied string = %s", dest);
}

void copynstr(char* dest,char* str,int* n)
{
	for(int i=0;  i != *n;  i++)
		dest[i] = str[i];
}


