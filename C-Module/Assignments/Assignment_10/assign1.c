//strlen()

#include <stdio.h>
#include <string.h>

void main()
{
    char str[50];
    printf("Enter a string: ");
    gets(str);

    int len = strlen(str);
    printf("Length of string = %d", len);
}
