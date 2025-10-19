//2. Accept three sides of a triangle from the user and determine whether the triangle is equilateral, 
//   isosceles, or scalene.

#include <stdio.h>
void triangle();
void main()
{
	triangle();
}
void triangle()
{
	int s1,s2,s3;
	printf("Give 3 sides = ");
	scanf("%d %d %d",&s1,&s2,&s3);
	
	if(s1==s2 && s1==s3)
	{
		printf("Triangle is equilateral ");
	}
	
	else if(s1==s2 || s1==s3 || s2==s3)
	{
		printf("Isoceles triangle");
	}
	
	else
	{
		printf("Scalene triangle");
	}
}