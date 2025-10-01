//Number is pallindrome or not

#include <stdio.h>

//void main()
//{
//	int num = 202;
//	int n1,n2,n3,q1,q2;
//	int sum = 0;
//	
//	n1 = num % 10; // 1
//	//sum = sum *10 + n1;
//	
//	q1 = num / 10; // 12
//	n2 = q1 % 10; // 2
//	//sum = sum * 10 + n2;
//	
//	q2 = q1 / 10; // 1
//	//sum = sum * 10 + q2;
//	
//	int reverse = n1 * 100 + n2 *10 + q2;
//	
//	if ( reverse == num)
//	{
//		printf("Number is pallindrome");
//	}
//	else
//	{
//		printf("Number is not pallindrome");
//	}
//	
//}

// Another way of solving the same

void main()
{
	int num = 212;
	if (num/100 == num % 10)
	{
		printf("Number is pallindrome");
	}
	else
	{
		printf("Number is not pallindrome");
	}
	
}