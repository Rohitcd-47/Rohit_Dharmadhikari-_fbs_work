//3 Sum of numbers in given range.
//Find sum of numbers from start to end.
//Input: start = 1, end = 5
//Output: 15

#include <stdio.h>
void sumofrange(int,int);
void main()
{
	int start,end;
	sumofrange(1,4);
	sumofrange(10,12);
	sumofrange(7,12);
}
void sumofrange(int start,int end)
{
	int sum=0;
	while(start<=end)
	{
		sum = sum + start;
		start++;
	}
	printf("\n%d",sum);
}