// strcasecmp(str1, str2) : Compare two strings without caring about uppercase or lowercase letters.

#include <stdio.h>
#include <string.h>

int mystrcasecmp(char* ,char* );
void main()
{
	char str1[20] = "Rohit";
	char str2[20] = "ROHITi";
	
	int result = mystrcasecmp(str1,str2);
	if(result == 0)
		printf("Strings are equal %d",result);
	else if(result<0)
		printf("String are not equal %d",result);
	else if(result>0)
		printf("String are not equal %d",result);
}

int mystrcasecmp(char* str1,char* str2)
{
	int count = 0;
	int i=0;
		int len = strlen(str1);
	while(str1[i] != '\0' && str2[i] != '\0')
	{
		char a = str1[i];
		char b = str2[i];
	
		
		if(a>= 'A' && a<= 'Z') a = a+32;
		if(b>='A' && b<='Z') b = b+32;
		
		if(a != b)
			return a-b;
		i++;	
	}
	return str1[i] - str2[i];
}



