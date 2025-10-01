//2. Accept three sides of a triangle from the user and determine whether the triangle is equilateral, 
//   isosceles, or scalene.

#include <stdio.h>
void main()
{
	int s1=5,s2=5,s3=5;
	
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