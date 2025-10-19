#include <stdio.h>
int area();
int main()
{
	int res = area();
	printf("Area of triangle = %d",res);
}
int area()
{
	int b,h;
	printf("Enter the base and height = ");
	scanf("%d %d",&b,&h);
	float ar = 0.5 * (b*h);
	return ar;
}