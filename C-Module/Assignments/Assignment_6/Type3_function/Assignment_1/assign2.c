// 2. Write a program to check given 3 digit number is pallindrome or not.  After reversing the digits the number still
//    become same.  121 - 121 or 231 - 132 not pallindrome.

#include <stdio.h>
void palindrome(int);
void main()
{
	int number;
	printf("Enter the number = ");
	scanf("%d",&number);
	palindrome(number); 
}
void palindrome(int num)
{
	if(num/100 == num %10)
	{
		printf("Number is pallindrome");
	}
	else
	{
		printf("Number is not pallindrome");
	}
	
}