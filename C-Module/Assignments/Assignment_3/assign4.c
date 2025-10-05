//4 Check the given number is prime or not.
//Input: n = 7
//Output: Prime

#include <stdio.h>
void main()
{
	int n =17;
	int i = 2;
	int flag = 0;
	
	while(i<=7/2)
	{
		if(n%i==0)
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