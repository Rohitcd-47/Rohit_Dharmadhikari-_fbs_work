//4. Write a program to check whether a given character is a vowel or consonant.

#include <stdio.h>
void vowelconsonant();
void main()
{
	vowelconsonant();
}
void vowelconsonant()
{
	char ch;
	printf("Print any alphabet = ");
	scanf("%c",&ch);
	
	if(ch=='a'|| ch=='e'|| ch=='i'||ch=='o'||ch=='u'||ch=='A'|| ch=='E'||ch=='I'||ch=='O'||ch=='U')
	{
		printf("The char is vowel");
	}
	else
	{
		printf("The char is consonant");
	}
}