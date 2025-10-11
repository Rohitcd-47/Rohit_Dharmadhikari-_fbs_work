//	5. Accept the price from user. Ask the user if he is a student (user may say y or n). If he
//	   is a student and he has purchased more than 500 than discount is 20% otherwise
//	   discount is 10%.But if he is not a student then if he has purchased more than 600
//	   discount is 15% otherwise there is not discount.
#include <stdio.h>
void discount();
void main()
{
	discount();
}
void discount()
{
	char s;
	printf("Are you a student (y/n) = ");
	scanf("%s",&s);
	int purchase;
	printf("Enter the amount you spend ");
	scanf(" %d",&purchase);
	
	int discount;
	
	if(s=='y')
	{
		if (purchase>500)
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
			
			if(purchase>600)
			{
				printf("Discount is 15 percent");
			}
			else
			{
				printf("No discount");
			}
		
	}
}

