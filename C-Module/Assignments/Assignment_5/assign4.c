//4. pyramid pattern
//Input: n = 5
//Output:
//*
//**
//***
//****
//*****

#include <stdio.h>
void main()
{
	int n= 5;
	for(int i=1;i<=5;i++)
	{
		for(int j=1;j<=5;j++)
		{
			if(j<=n-i+1)
			{
				printf("* ");
			}
		}
		printf("\n");
	}
}