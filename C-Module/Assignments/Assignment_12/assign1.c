//1. Write a program to scan string from user then scan a single character and search it
//in a accepted string.

#include <stdio.h>
int main()
{
	char str[50],ch;
	printf("Enter the first name : ");
	gets(str);
	printf("\nEnter the character : ");
	scanf("%c",&ch);
	
	int i = 0;
	while(str[i] != '\0')
	{
		if(str[i] == ch)
		{
			printf("Found");
			return 0;
		}
		i++;
	}
	printf("Not found");
}