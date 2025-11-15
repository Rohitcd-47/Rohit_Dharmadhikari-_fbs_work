
#include <stdio.h>
#include <string.h>
char* removecharacter(char* ,int );
void main()
{
	char str[20] = "Rohit Dharmadhikari";
	int n = 3;
	
	char* result = removecharacter(str,n);
	printf("String after removing %dth index : %s",n,result);
}

char* removecharacter(char* str,int n)
{
	int i=0;
	while(str[i] != '\0')
	{
		if(i+1>n)
		{
			str[i] = str[i+1];
		}
		i++;
	}
	return str;
}