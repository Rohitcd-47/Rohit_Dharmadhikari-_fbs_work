//7. WAP to Remove the Characters of Odd Index Values in a String

#include <stdio.h>
#include <string.h>

char* removeoddindex(char*);
void main()
{
	char str[50] = "Hey How are you ?";
	char* result = removeoddindex(str);
	
	printf("Replace string is = %s",str);
}

char* removeoddindex(char* str)
{
	int i = 0,j=0;
	while(str[i] != '\0')
	{
		if(i%2==0)
		{
			str[j] = str[i];
			j++;
		}
		i++;
	}
	str[j] = '\0';
	return str;	
}