// strcmp()

#include <stdio.h>
#include <string.h>

int mystrcmp(char*,char*); // function declaration.
void main()
{
    char str1[50], str2[50];
    printf("Enter first string: ");
    gets(str1);
    printf("Enter second string: ");
    gets(str2);

    int result = mystrcmp(str1, str2); // function call
    
    if(result == 0)
        printf("Strings are equal");
    else if(result>0)
        printf("Strings are not equal. str1 > str2 by %d ",result);
    else if(result<0)
    	printf("Strings are not equal. str1 < str1  by %d ",result);
}

int mystrcmp(char* str1,char* str2)
{
	int len1 = strlen(str1);
	
	for(int i=0; i<=len1; i++ )
	{
		if(str1[i] == str2[i])
			continue;	
		else
		{
			int c = str1[i] - str2[i];
			return c;
		}
	}
	return 0;
}