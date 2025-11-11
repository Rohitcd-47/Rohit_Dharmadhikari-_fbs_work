//wap to check the string is pallindrome or not ?

#include <stdio.h>
void main()
{
	char str[20];
	printf("Enter the string : ");
	gets(str);
	printf("%s",str);
	
	char copy[20];
	strcpy(copy,str);
	
	
	strrev(str);
	printf("\nReverse string = %s",str);
	
	
	int result = strcmp(str,copy);
	if(result==0)
		printf("\nString is palindrome");
	else
		printf("\nString is not palindrome");
		
	//strcmp(strrev(str),strcpy(copy,str)) == 0 ? printf("Palindrome") : printf("Not palindrome")


}