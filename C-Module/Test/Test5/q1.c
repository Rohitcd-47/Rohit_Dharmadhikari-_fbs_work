//1. WAP to calculate selling price of book based on cost price and discount.
//( using function and nested if- else )

#include <stdio.h>
int sellingprice(int,int);
void main()
{
	int cost,discount;
	printf("Enter the cost price = ");
	scanf("%d",&cost);
	printf("Enter the discount you get : ");
	scanf("%d",&discount);
	
	float sellprice = sellingprice(cost,discount);
	printf("The selling price of book = %f",sellprice);
}

int sellingprice(int cost,int discount)
{
	float disc = (float)discount/100;
	float selling =(cost-(cost*disc));
	
	return selling;
}