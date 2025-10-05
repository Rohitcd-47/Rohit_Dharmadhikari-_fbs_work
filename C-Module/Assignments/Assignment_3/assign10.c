//10 	Find Sum of first and last digit of given number.
//	Input: n = 12345
//	Output: 6 (1 + 5)

#include <stdio.h>
#include <math.h>
void main()
{
	int n = 12345;
	int temp = n;
	
	int last = n%10;
	while(temp>=10)
	{
		temp = temp/10;
	}
	
	int first = temp;
	int sum = first + last;
	
	printf("The sum of first and last digit is = %d",sum);
	
}