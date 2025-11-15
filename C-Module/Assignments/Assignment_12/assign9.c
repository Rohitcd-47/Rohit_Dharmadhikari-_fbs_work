//9. WAP to Take in Two Strings and Display the Larger String without Using Built-in Functions

#include <stdio.h>
#include <string.h>
int largerstring(char*,char*);
void main()
{
	char str1[50] = "Rohit Dharmadhikari";
	char str2[50] = "Students are the future";
	
	int result = largerstring(str1,str2);
	if(result==1)
		printf("Larger string : %s",str1);
	else if(result==2)
		printf("Larger string : %s",str2);
	else
		printf("Both strings are equal")
;}

int largerstring(char* str1,char* str2)
{
	int i=0,j=0;
	for(; str1[i] != '\0'; i++)
		continue;
	for(; str2[j] != '\0';j++)
		continue;
	
	if(i>j)
		return 1;
	else if (i<j)
		return 2;
	else
		return 0;
}