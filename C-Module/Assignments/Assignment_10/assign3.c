// strncpy ()
#include <stdio.h>
#include <string.h>

void main()
{
    char src[50], dest[50];
    printf("Enter a string: ");
    gets(src);

    strncpy(dest, src, 3);
    dest[3] = '\0'; // to end properly
    printf("First 3 characters copied = %s", dest);
}
