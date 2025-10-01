//10. Write a C program to input marks of five subjects, find the total marks, and calculate the percentage.

#include <stdio.h>
int main()
{
	int m1 = 45;
	int m2 = 67;
	int m3 = 77;
	int m4 = 88;
	int m5 = 89;
	
	float total;
	float percentage;
	
	total = m1+m2+m3+m4+m5;
	percentage = (total/500)*100;
	
	printf("The total sum of marks of all subjects out of 100 is %f\n",total);
	printf("The percentage he got is %f",percentage);
	return 0;
}