//strlen()

#include <stdio.h>
#include <string.h>
int mystrlen(char*);
void main()
{
    char str[50];
    printf("Enter a string: ");
    gets(str);
    
    int result = mystrlen(str);
    printf("Length of the string = %d",result);
}

int mystrlen(char* str)
{
	int i=0;
	while(str[i] != '\0')
	{
		i++;
	}
	return i;
}

