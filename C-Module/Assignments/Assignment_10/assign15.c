//strdup()

#include <stdio.h>
#include <string.h>
#include <stdlib.h>

void main()
{
    char original[50] = "Hello World";
    char *copy = strdup(original);

    printf("Original: %s\n", original);
    printf("Duplicate: %s", copy);

    free(copy); // memory free karna zaroori hai
}
