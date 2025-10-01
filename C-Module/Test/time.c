// 	Q1.	Convert the time in hh,min and sec in total seconds

#include <stdio.h>
void main()
{
	int hh = 3;
	int min = 22;
	int sec = 1;
	
	int total;
	
	total = hh*60*60 + min * 60 + sec;
	printf("The total time in seconds is %d",total);
	
	
}