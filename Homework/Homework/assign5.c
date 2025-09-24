//5. Write a C program to input five numbers and find their average.

#include <stdio.h>
int main()
{
	int a=4,b=5,c=7,d=3,e=12;
	int avg;
	
	avg = (a+b+c+d+e)/5;
	printf("The average of five numbers are %d",avg);
	return 0;

}