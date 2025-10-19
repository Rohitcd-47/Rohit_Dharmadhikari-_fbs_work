	//5. Write a C program to input five numbers and find their average.

#include <stdio.h>
void average(int,int,int,int,int);
void main()
{
	int a,b,c,d,e;
	printf("Enter 5 numbers : ");
	scanf("%d%d%d%d%d",&a,&b,&c,&d,&e);
	average(a,b,c,d,e);
}
void average(int a,int b,int c,int d,int e)
{
	int avg = (a+b+c+d+e)/5;
	printf("The average of five numbers are %d",avg);

}