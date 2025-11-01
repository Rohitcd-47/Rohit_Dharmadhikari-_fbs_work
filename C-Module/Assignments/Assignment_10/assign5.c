// strncat()

#include <stdio.h>
#include <string.h>

void main()
{
    char str1[50] = "Good ";
    char str2[50] = "Morning";

    strncat(str1, str2, 4);
    printf("After limited concatenation: %s", str1);
}
