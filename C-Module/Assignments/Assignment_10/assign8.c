//strchr()

#include <stdio.h>
#include <string.h>

void main()
{
    char str[50] = "hello world";
    char *ptr = strchr(str, 'o');

    if(ptr)
        printf("First 'o' found at position: %ld", ptr - str + 1);
    else
        printf("Character not found");
}
