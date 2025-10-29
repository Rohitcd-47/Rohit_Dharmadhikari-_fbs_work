//3. Write a program to check whether a given year is a leap year.

#include <stdio.h>
void leapyear(int*);
void main()
{
	int year;
	printf("Enter year :");
	scanf("%d",&year);
	leapyear(&year);
}
void leapyear(int* year)
{
	if(*year%4==0 && *year%100 != 0 || *year%400 == 0)
	{
		printf("This is a leap year");
	}
	else 
	{
		printf("Not a leap year");
	}
}