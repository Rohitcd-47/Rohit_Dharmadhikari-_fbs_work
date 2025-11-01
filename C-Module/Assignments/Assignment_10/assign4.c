//strcat()

#include <stdio.h>
#include <string.h>

void main()
{
    char str1[50] = "Hello ";
    char str2[50] = "World!";
    
    strcat(str1, str2);
    printf("After concatenation: %s", str1);
}
