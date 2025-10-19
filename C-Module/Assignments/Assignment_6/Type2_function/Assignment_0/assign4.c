#include <stdio.h>
int avg();
int main()
{
	int output = avg();
	printf("The average of five numbers are %d",output);
}
int avg()
{
	int a,b,c,d,e;
	scanf("%d%d%d%d%d",&a,&b,&c,&d,&e);
	int avg;
	
	avg = (a+b+c+d+e)/5;
	return avg;

}