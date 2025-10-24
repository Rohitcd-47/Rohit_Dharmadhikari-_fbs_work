#include <stdio.h>
void armstrong(int*);
void main()
{
	int number;
	printf("Enter the number : ");
	scanf("%d",&number);
	armstrong(&number);
	
}
void armstrong(int* number)
{
	int rem ,sum = 0, temp = *number;
	
	while (*number >0)
	{
		rem = *number % 10;
		sum = sum + rem*rem*rem;
		*number = *number/10;
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