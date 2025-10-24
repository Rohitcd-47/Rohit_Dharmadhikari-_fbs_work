//8 	Check the given number is Strong number or not.
//	Input: n = 145
//	Output: Strong

#include <stdio.h>
void strongnumber(int*);
void main()
{
	int number;
	printf("Enter the number : ");
	scanf("%d",&number);
	strongnumber(&number);
}
void strongnumber(int* n)
{
	int store = 0;
	int temp = *n;
	int rem;
	
	while(*n>0)
	{
		rem = *n % 10;
		int fact,i;
		i = 1;
		fact = 1;
		
		
		while(i<=rem)
		{
			fact = fact*i;
			i++;
		}
		store = store + fact;
		*n = *n/10;
		
	}
	if(temp==store)
	{
		printf("%d is strong number",temp);
	}
	else
	{
		printf("%d is not strong number",temp);
	}
}