//5. Write a program to check whether a person is eligible to vote (age = 18).

#include <stdio.h>
void eligible();
void main()
{
	eligible();
}
void eligible(){
	
	int age;
	printf("Enter the age = ");
	scanf("%d",&age);
	
	if(age>=18)
	{
		printf("Eligible to vote");
	}
	else
	{
		printf("Not eligible to vote");
	}
}