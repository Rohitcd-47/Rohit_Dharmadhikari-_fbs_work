//strncasecmp

#include <stdio.h>
#include <string.h>

int mystrcasecmp(char* ,char*,int );
void main()
{
	char str1[20] = "RohitDharmadhikari";
	char str2[20] = "rohitdixit";
	int n = 4;
	
	int result = mystrcasecmp(str1,str2,n);
	if(result == 0)
		printf("Strings are equal %d",result);
	else if(result<0)
		printf("String are not equal %d",result);
	else if(result>0)
		printf("String are not equal %d",result);
}

int mystrcasecmp(char* str1,char* str2,int n)
{
	int count = 0;
	int i=0;
	
	while(str1[i] != '\0' && str2[i] != '\0' && i<n)
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




