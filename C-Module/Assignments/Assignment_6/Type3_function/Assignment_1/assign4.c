//4. Write a program to check whether a given character is a vowel or consonant.

#include <stdio.h>
void vowelcons(char);
void main()
{
	char ch;
	printf("Print the character : ");
	scanf("%c",&ch);
	vowelcons(ch);
}
	
void vowelcons(char ch)
{
	if(ch=='a'|| ch=='e'|| ch=='i'||ch=='o'||ch=='u'||ch=='A'|| ch=='E'||ch=='I'||ch=='O'||ch=='U')
	{
		printf("The char is vowel");
	}
	else
	{
		printf("The char is consonant");
	}
}