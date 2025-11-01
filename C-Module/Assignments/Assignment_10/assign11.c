 // strpbrk()
 
#include <stdio.h>
#include <string.h>

void main()
{
    char str1[50] = "apple";
    char str2[50] = "le";

    char *ptr = strpbrk(str1, str2);

    if(ptr)
        printf("First matching character found at position: %ld", ptr - str1 + 1);
    else
        printf("No matching character found");
}
