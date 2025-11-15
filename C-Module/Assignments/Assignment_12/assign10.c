//10. Write a program to check the string is palindrome or not.

#include <stdio.h>
#include <string.h>

int checkpalindrome(char*);
void main()
{
	char str[40] = "zoom";

	if(checkpalindrome(str))
		printf("String is palindrome");
	else
		printf("String is NOT palindrome");
}

int checkpalindrome(char* str)
{
	int i=0,j=0;
	while(str[j] != '\0')
		j++;
	j--;
	
	while(i<j)
	{
		if(str[i]!=str[j])
			return 0;
		i++;
		j--;
	}
	return 1;
}