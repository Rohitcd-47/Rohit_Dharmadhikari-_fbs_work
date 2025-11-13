//strstr()

#include <stdio.h>
#include <string.h>
char* mystrstr(char*,char*);
void main()
{
    char str[100] = "Welcomocome";
    char sub[20] = "come";

    char *ptr = mystrstr(str, sub);
    if(ptr)
    	printf("Found at %ld\nSubstring : %s",ptr-str+1, ptr);
}

char* mystrstr(char*str,char*sub)
{
	int len = strlen(str);
	int len1 = strlen(sub);
	
	int count = 0;
	for(int i=0,j=0;  i<=len && j<len1;  i++)
	{
		if(str[i] == sub[j])
		{
			count++;
			j++;
		}
		else if(str[i] != sub[j] && count>0)
		{
			j = 0;
			count = 0;
		}
			
	}
	if(count==len1)
		return str;
}
