//5. Write a program to check whether a person is eligible to vote (age = 18).

#include <stdio.h>
void eligible(int*);
void main()
{
	int age;
	printf("Enter the age : ");
	scanf("%d",&age);
	eligible(&age);
}
void eligible(int* age){
	
	if(*age>=18)
	{
		printf("Eligible to vote");
	}
	else
	{
		printf("Not eligible to vote");
	}
}