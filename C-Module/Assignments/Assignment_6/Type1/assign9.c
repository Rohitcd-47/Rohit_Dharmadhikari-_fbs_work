#include <stdio.h>
void totper();
void main()
{
	totper();
}
void totper()
{
	int m1,m2,m3,m4,m5;
	printf("Enter marks of your five subjects = ");
	scanf("%d %d %d %d %d",&m1,&m2,&m3,&m4,&m5);
	
	float total;
	float percentage;
	
	total = m1+m2+m3+m4+m5;
	percentage = (total/500)*100;
	
	printf("The total sum of marks of all subjects out of 100 is %f\n",total);
	printf("The percentage he got is %f",percentage);
}