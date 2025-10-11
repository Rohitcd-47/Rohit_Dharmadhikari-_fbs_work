// 2. Write a program to check given 3 digit number is pallindrome or not.  After reversing the digits the number still
//    become same.  121 - 121 or 231 - 132 not pallindrome.

#include <stdio.h>
void ispallindrome();
void main()
{
	ispallindrome();
}
void ispallindrome()
{
	int num;
	printf("Enter the 3-digit number = ");
	scanf("%d",&num);
	
	if(num/100 == num %10)
	{
		printf("Number is pallindrome");
	}
	else
	{
		printf("Number is not pallindrome");
	}
	
}