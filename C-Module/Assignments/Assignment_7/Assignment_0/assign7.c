//Write a C program to convert given minutes into hours and remaining minutes.

#include <stdio.h>
void time(int*);
void main()
{
	int minutes;
	printf("Enter the time : ");
	scanf("%d",&minutes);
	time(&minutes);
	
}
void time(int* minutes)
{
	
	int hours = *minutes/60;
	int remaining = *minutes % 60;
	
	printf("Minutes in hours is %d:%d hours",hours,remaining);
}