//strcat()

#include <stdio.h>
#include <string.h>

void mystrcat(char*,char*);
void main()
{
    char str1[50] = "rohit";
    char str2[50] = " dharmadhikari";
    
    mystrcat(str1, str2);
    printf("After concatenation: %s", str1);
}

void mystrcat(char* str1,char* str2)
{
	int length = strlen(str1);
	int length2 = strlen(str2);
	
	for(int i=0, j = length; i<=length2 ; i++)
	{
		str1[j] = str2[i];
		j++;
	}
}
