//strstr()

#include <stdio.h>
#include <string.h>

void main()
{
    char str[100] = "Welcome to C programming";
    char sub[20] = "C";

    char *ptr = strstr(str, sub);
    if(ptr)
        printf("Substring found at position: %ld", ptr - str + 1);
    else
        printf("Substring not found");
}
