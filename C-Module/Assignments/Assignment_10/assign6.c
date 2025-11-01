// strcmp()

#include <stdio.h>
#include <string.h>

void main()
{
    char str1[50], str2[50];
    printf("Enter first string: ");
    gets(str1);
    printf("Enter second string: ");
    gets(str2);

    int result = strcmp(str1, str2);
    if(result == 0)
        printf("Strings are equal");
    else
        printf("Strings are not equal");
}
