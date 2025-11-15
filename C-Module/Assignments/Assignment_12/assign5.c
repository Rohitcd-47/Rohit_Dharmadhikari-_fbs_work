//5. WAP to Count the Number of Vowels in a String

#include <stdio.h>
#include <string.h>
#include <ctype.h>
int countvowels(char*);
void main()
{
	char str[40] = "ROhItee hey how are you ?";
	int count = countvowels(str);
	printf("The count of vowels in a given string = %d",count);
}

int countvowels(char* str)
{
	int cnt = 0;

	for(int i=0; str[i] != '\0'; i++)
	{
		char ch = tolower(str[i]);
		if(ch == 'a' || ch=='e'||ch=='i' ||ch == 'o' || ch=='u')
			cnt++;
		
	}
	return cnt;
}