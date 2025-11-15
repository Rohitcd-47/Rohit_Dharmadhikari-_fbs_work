
#include <stdio.h>
#include <string.h>
char* exchange(char* );
void main()
{
	char str[20] = "Rohit Dharmadhikari";
	
	char* result = exchange(str);
	printf("String after exchanging first and lst character : %s",result);
}

char* exchange(char* str)
{
	int i=0;
	int len = strlen(str);
	
	while(str[i] != '\0')
	{
		char first = str[0];
		char last = str[len-1];

		if(i==0)
		{
			str[i] = last;
			str[len-1] = first;	
		}	
		i++;
			
	}
	return str;
}