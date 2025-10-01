//Sum of digits

#include <stdio.h>
void main()
{
	int num = 42123;
	int sum = 0;
	int rem;
	
	while(num>0)
	{
		rem = num%10;
		sum = sum + rem;
		num = num /10;
		
	}
	printf("%d",sum);	
}