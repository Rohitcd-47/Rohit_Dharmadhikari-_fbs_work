//Write a C program to convert given minutes into hours and remaining minutes.

#include <stdio.h>
void time();
void main()
{
	time();
}
void time()
{
	int minutes,hours,remaining;
	printf("Enter the time in minutes = ");
	scanf("%d",&minutes);
	hours = minutes/60;
	remaining = minutes % 60;
	
	printf("Minutes in hours is %d:%d hours",hours,remaining);

}