//strrchar = Find last occurence

#include <stdio.h>
#include <string.h>

char* mystrrchr(char*,char);

void main()
{
	char s1[20] = "Hello world";
	char s2 = 'o';
	
	char* result = mystrrchr(s1,s2);
	if(result != NULL)
		printf("Last occurence found %s",result);
	else 
		printf("Character not found ");
}

char* mystrrchr(char* s1,char s2)
{
	int j = 0;
	for(int i=0; s1[i] != '\0'; i++)
	{
		if(s1[i] == s2)
			j = i;
	}
	if(j>0)
		return (s1+j);
	else 
		return NULL;
}
