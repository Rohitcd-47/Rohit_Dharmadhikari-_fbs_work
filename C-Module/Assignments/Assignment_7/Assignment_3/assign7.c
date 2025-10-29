//7 Find factorial of given number.
//Input: n = 5
//Output: 120

#include <stdio.h>
void factorial(int*);
void main()
{
	int number;
	printf("Enter the number : ");
	scanf("%d",&number);
	factorial(&number);
}
void factorial(int* n)
{
	int i= 1,fact=1;
	
	while(i<= *n)
	{
		fact = fact*i;
		i++;
	}
	printf("%d",fact);
}