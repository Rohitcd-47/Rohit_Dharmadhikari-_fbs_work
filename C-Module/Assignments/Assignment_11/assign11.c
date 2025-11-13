// strnstr str1 ke pehle n characters ke andar substring str2 ko dhoondhta hai.


#include <stdio.h>
#include <string.h>

char* mystrstr(char*, char*,int);

void main()
{
    char str1[50] = "Hello world";
    char str2[20] = "wor";
	int n = 6;
	
    char *result = mystrstr(str1, str2,n);

    if (result != NULL)
        printf("Substring found: %s", result);
    else
        printf("Substring not found");
}

char* mystrstr(char* str1, char* str2,int n)
{
    int i, j;
    for (i = 0; str1[i] != '\0' && i!=n; i++) 
    {
		   
		for (j = 0; str2[j] != '\0'; j++) 
        {
            if (str1[i + j] != str2[j]) 
                break;
        }

        if (str2[j] == '\0') 
            return (str1 + i);
    }
    return NULL; 
}
