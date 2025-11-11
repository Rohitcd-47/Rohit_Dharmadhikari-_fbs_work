//strlen()

#include <stdio.h>
#include <string.h>
int findlength(char*);
void main()
{
    char str[50];
    printf("Enter a string: ");
    gets(str);
    
    int result = findlength(str);
    printf("Length of the string = %d",result);
}

int findlength(char* str)
{
	int i=0;
	while(str[i] != '\0')
	{
		i++;
	}
	return i;
}

