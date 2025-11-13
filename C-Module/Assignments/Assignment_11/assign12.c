// strupr - strupr(str) ? converts "rohit" ? "ROHIT"

#include <stdio.h>
#include <string.h>
char* mystrupper(char*);
void main()
{
	char str[20] = "rohit DhaRmadhiKarI";
	char*result = mystrupper(str);
	printf("Uppercase of string = %s",result);
}

char* mystrupper(char* str)
{
	for(int i=0; str[i] != 0; i++)
	{
		if(str[i]>= 'a' && str[i]<='z')
			str[i] = str[i] - 32;
	}
	return str;
}