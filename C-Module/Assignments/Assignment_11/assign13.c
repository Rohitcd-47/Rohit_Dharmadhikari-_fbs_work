// strlwr- strlwr(str) ? converts  "ROHIT" -> "rohit"

#include <stdio.h>
#include <string.h>
char* mystrupper(char*);
void main()
{
	char str[20] = "ROHIT DhaRmadhiKarI";
	char*result = mystrupper(str);
	printf("Lowercase of string = %s",result);
}

char* mystrupper(char* str)
{
	for(int i=0; str[i] != 0; i++)
	{
		if(str[i]>= 'A' && str[i]<='Z')
			str[i] = str[i] + 32;
	}
	return str;
}