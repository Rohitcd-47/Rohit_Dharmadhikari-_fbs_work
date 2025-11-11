#include <stdio.h>
int findchar(char*,char*);
void main()
{
	char str[50],ch;
	printf("Enter the first name : ");
	gets(str);
	printf("\nEnter the character : ");
	scanf("%c",&ch);
		
	int res = findchar(str,&ch);
	if(res)
		printf("found");
	else
		printf("not found");
}
int findchar(char* str,char* ch)
{
	int i = 0;
	while(str[i] != '\0')
	{
		if(str[i] == *ch)
			return 1;
		i++;
	}
	return 0;
}