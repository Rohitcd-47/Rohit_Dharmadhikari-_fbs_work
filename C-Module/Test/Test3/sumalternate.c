//wap to add alternate numbers from given range

#include <stdio.h>
void main()
{
	int sum = 0;
	for (int i=1;i<=5;)
	{
		sum = sum + i;
		i = i+2;
	}
	printf("Sum of alternate number in the range of 1-5 is = %d",sum);
}