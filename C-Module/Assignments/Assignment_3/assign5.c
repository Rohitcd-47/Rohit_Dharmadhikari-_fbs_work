#include <stdio.h>
void main ()
{
	int num = 153;
	int rem ,sum = 0, temp = num;
	
	while (num >0)
	{
		rem = num % 10;
		sum = sum + rem*rem*rem;
		num = num/10;
	}
	
	if (sum == temp)

	{
		printf("Number is Armstrong");
	}	
	else
	{
		printf("Number is not Armstrong");
	}
}