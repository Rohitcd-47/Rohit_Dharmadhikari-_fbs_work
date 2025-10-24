//10 	Find Sum of first and last digit of given number.
//	Input: n = 12345
//	Output: 6 (1 + 5)

#include <stdio.h>
void sumofdigits(int*);

void main()
{
	int number;
	printf("Enter the number : ");
	scanf("%d",&number);
	sumofdigits(&number);
}

void sumofdigits(int* n)
{
	int temp = *n;
	
	int last = *n % 10;
	while(temp>=10)
	{
		temp = temp/10;
	}
	
	int first = temp;
	int sum = first + last;
	
	printf("The sum of first and last digit is = %d",sum);
	
}