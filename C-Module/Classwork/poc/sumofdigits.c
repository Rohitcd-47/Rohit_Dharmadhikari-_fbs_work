#include <stdio.h>
void main ()
{
	int number = 73285;
	int r1,r2,r3,r4,q1,q2,q3,q4;
	int sum;
	
	r1 = number % 10; //5
	q1 = number/10;  // 7328
	
	r2 = q1 % 10; // 8
	q2 = q1/10; // 732
	
	r3 = q2%10; // 2
	q3 = q2/10; // 73
	
	r4 = q3%10; //3
	q4 = q3/10; // 7
	
	
	sum = r1+r2+r3+r4+q4;
	printf("Sum of 5 digits number 73285 is %d",sum);
	
}