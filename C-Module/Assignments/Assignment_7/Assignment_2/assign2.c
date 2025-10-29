//2. Accept three sides of a triangle from the user and determine whether the triangle is equilateral, 
//   isosceles, or scalene.

#include <stdio.h>
void findtriangle(int*,int*,int*);
void main()
{
	int side1,side2,side3;
	printf("Enter the values of all 3 sides : ");
	scanf("%d%d%d",&side1,&side2,&side3);
	findtriangle(&side1,&side2,&side3);
}
void findtriangle(int* s1,int* s2,int* s3)
{
	if(*s1==*s2 && *s1==*s3)
	{
		printf("Triangle is equilateral ");
	}
	
	else if(*s1==*s2 || *s1==*s3 || *s2==*s3)
	{
		printf("Isoceles triangle");
	}
	
	else
	{
		printf("Scalene triangle");
	}
}