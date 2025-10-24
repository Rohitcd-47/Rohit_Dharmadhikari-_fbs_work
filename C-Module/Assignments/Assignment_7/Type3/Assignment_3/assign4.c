//4 Check the given number is prime or not.
//Input: n = 7
//Output: Prime

#include <stdio.h>
void primenumber(int*);
void main()
{
	int number;
	printf("Enter the number : ");
	scanf("%d",&number);
	primenumber(&number);
}

void primenumber(int* n)
{
	int i=2,flag=0;
	while(i<= *n/2)
	{
		if(*n%i==0)
		{
			flag = 1;
			break;
		}
		i++;
	} 
	if(flag==0)
	{
		printf("Prime number");
	}
	else
	{
		printf("Not prime");
	}
}