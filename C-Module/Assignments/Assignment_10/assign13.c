//strcspn()

#include <stdio.h>
#include <string.h>

void main()
{
    char str1[50] = "computer";
    char str2[50] = "ut";

    int len = strcspn(str1, str2);
    printf("First matching character appears after %d characters", len);
}
