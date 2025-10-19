//5. Write a C program to input five numbers and find their average.

#include <stdio.h>
void average();
void main()
{
	average();
}
void average()
{
	int a,b,c,d,e;
	printf("Enter your five numbers = ");
	scanf("%d %d %d %d %d",&a,&b,&c,&d,&e);
	int avg;
	
	avg = (a+b+c+d+e)/5;
	printf("The average of five numbers are %d",avg);

}