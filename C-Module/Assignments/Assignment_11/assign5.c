//strncat()

#include <stdio.h>
#include <string.h>

void mystrncat(char*,char*,int);
void main()
{
    char str1[50] = "rohit";
    char str2[50] = " dharmadhikari";
    
    mystrncat(str1, str2,5);
    printf("After concatenation: %s", str1);
}

void mystrncat(char* str1,char* str2,int n)
{
	int length = strlen(str1);
	int length2 = strlen(str2);
	
	for(int i=0, j = length; i<=n ; i++)
	{
		str1[j] = str2[i];
		j++;
	}
}
