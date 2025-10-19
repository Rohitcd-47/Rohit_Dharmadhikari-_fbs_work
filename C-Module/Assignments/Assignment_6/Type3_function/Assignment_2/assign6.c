//	     6. Accept a number and check if it is divisible by 3, 5, or both.
//		(Print "Divisible by 3 but not by 5" or "Divisible by 5 but not by 3" or "Divisible by
//		both" or” Divisible by None”)

#include <stdio.h>
void divisibility(int);
void main()
{
	int number;
	printf("Enter the number = ");
	scanf("%d",&number);
	divisibility(number);
}
void divisibility(int num)
{
	if(num%3 == 0 && num % 5==0)
	{
		printf("Divisble by 3 and 5 both");
	}
	
	else if(num % 3 == 0)
	{
		printf("Number is divisible by 3 but not by 5");
	}
	
	
	else if (num % 5 ==0)
	{
		printf("Number is divisible by 5 but not by 3");
	}
	else
	{
		printf("Number is divisible by none");
	}
	
}




