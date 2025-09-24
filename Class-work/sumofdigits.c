#include <stdio.h>
void main ()
{
	int number = 123;
	int r1,r2,r3,q1,q2;
	
	r1 = number % 10;
	q1 = number/10;
	r2 = q1 % 10;
	q2 = q1/10;
	
	r3 = r1+r2+q2;
	printf("Sum of digits of the number %d are %d",number,r3);
}