
//Write a C program to convert given minutes into hours and remaining minutes.

#include <stdio.h>
int main()
{
	int minutes = 200;
	int hours;
	int remaining;
	
	hours = minutes/60;
	remaining = minutes % 60;
	
	printf("20 minutes in hours is %d:%d hours",hours,remaining);
	return 0;
}