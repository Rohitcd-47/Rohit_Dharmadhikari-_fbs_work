//9 	Check the given number is Palindrome number or not.
//	Input: n = 121
//	Output: Palindrome

#include <stdio.h>
void main()
{
	int n = 121;
	int temp = n;
	int rem,rev = 0;
	
	while(n>0)
	{
		rem = n%10;
		rev = rev*10 + rem;
		n = n/10;
	}
	if(temp == rev)
	{
		printf("%d is palindrome",temp);
	}
	else
	{
		printf("%d is not palindrome",temp);
	}
}