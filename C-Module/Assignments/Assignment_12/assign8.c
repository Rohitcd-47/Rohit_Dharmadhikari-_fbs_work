#include <stdio.h>
#include <string.h>

int numberofwords(char*);

void main()
{
    char str[40] = "  I am  joining firstbit solutions";
    int result = numberofwords(str);

    printf("Total number of words present in the string = %d", result);
}

int numberofwords(char* str)
{
    int count = 0;

    for(int i = 0; str[i] != '\0'; i++)
    {
        if(str[i] != ' ' && (i == 0 || str[i-1] == ' '))
        	count++;
    }

    return count;
}
