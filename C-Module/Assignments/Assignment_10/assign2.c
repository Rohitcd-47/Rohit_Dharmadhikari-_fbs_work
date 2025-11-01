//strcpy

#include <stdio.h>
#include <string.h>

void main()
{
    char src[50], dest[50];
    printf("Enter a string to copy: ");
    gets(src);

    strcpy(dest, src);
    printf("Copied string = %s", dest);
}
