// 19. strcasecmp() — Case-insensitive String Compare

#include <stdio.h>
#include <string.h>

void main() {
    char s1[20] = "Ronit";
    char s2[20] = "rohit";
    int result = strcasecmp(s1, s2);
    printf("Result = %d", result);
}
