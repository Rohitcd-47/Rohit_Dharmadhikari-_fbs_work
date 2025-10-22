//10. Write a C program to input marks of five subjects, find the total marks, and calculate the percentage.

#include <stdio.h>
void total(int*,int*,int*,int*,int*);
void main()
{
	int m1,m2,m3,m4,m5;
	printf("Enter the marks of your five subjects : ");
	scanf("%d%d%d%d%d",&m1,&m2,&m3,&m4,&m5);
	total(&m1,&m2,&m3,&m4,&m5);
}
void total(float* x,float* y,float* a,float* b,float* c) 
{

	float total = *x+*y+*a+*b+*c;
	float percentage = (total/500)*100;
	
	printf("The total sum of marks of all subjects out of 100 is %d\n",total);
	printf("The percentage he got is %f",percentage);

}