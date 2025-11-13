// strncmp()

#include <stdio.h>
#include <string.h>

int mystrncmp(char*,char*,int); // function declaration.
void main()
{
    char str1[50], str2[50];
    printf("Enter first string: ");
    gets(str1);
    printf("Enter second string: ");
    gets(str2);

    int result = mystrncmp(str1, str2,3); // function call
    
    if(result == 0)
        printf("Strings are equal");
    else if(result>0)
        printf("Strings are not equal. str1 > str2 by %d ",result);
    else if(result<0)
    	printf("Strings are not equal. str1 < str1  by %d ",result);
}

int mystrncmp(char* str1,char* str2,int n)
{
	
	for(int i=0; i<=n; i++ )
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