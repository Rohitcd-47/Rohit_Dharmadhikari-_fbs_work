//	5. Accept the price from user. Ask the user if he is a student (user may say y or n). If he
//	   is a student and he has purchased more than 500 than discount is 20% otherwise
//	   discount is 10%.But if he is not a student then if he has purchased more than 600
//	   discount is 15% otherwise there is not discount.
#include <stdio.h>
void discount(char*,int*);
void main()
{
	char student;
	printf("Are you a student (y/n) : ");
	scanf("%c",&student);
	int purchase;
	printf("Enter the purchase amount : ");
	scanf("%d",&purchase);
	
	discount(&student,&purchase);
	
}
void discount(char* s,int* purchase)
{
	int discount;
	
	if(*s=='y')
	{
		if (*purchase>500)
		{
			printf("Discount is 20 percent");
		}
		else 
		{
			printf("Discount is 10 percent");
		}
	}
	else
	{
		if(*s=='n')
		{
			if(*purchase>600)
			{
				printf("Discount is 15 percent");
			}
			else
			{
				printf("No discount");
			}
		}
	}
}

