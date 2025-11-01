//strrchr()

#include <stdio.h>
#include <string.h>

void main()
{
    char str[50] = "hello world";
    char *ptr = strrchr(str, 'o');

    if(ptr)
        printf("Last 'o' found at position: %ld", ptr - str + 1);
    else
        printf("Character not found");
}
