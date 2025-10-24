//3 Sum of numbers in given range.
//Find sum of numbers from start to end.
//Input: start = 1, end = 5
//Output: 15

#include <stdio.h>
void sumofrange(int*,int*);
void main()
{
	int start,end;
	printf("Enter the start and end of the range : ");
	scanf("%d %d",&start,&end);
	sumofrange(&start,&end);
}
void sumofrange(int* start,int* end)
{
	int sum=0;
	while(*start <= *end)
	{
		
		sum = sum + *start;
		(*start)++;

	}
	printf("%d",sum);
}