//20. strncasecmp() — Compare First n Characters (Case-insensitive)

#include <stdio.h>
#include <string.h>

void main() {
    char s1[20] = "HELLO";
    char s2[20] = "heillo";
    int result = strncasecmp(s1, s2, 4);
    printf("Result = %d", result);
}
