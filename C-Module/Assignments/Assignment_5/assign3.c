//3. Print an inverted right-angled triangle pattern
//Input: n = 5
//Output:
//
//*****
//****
//***
//**
//*

#include <stdio.h>
void main()
{
	int n = 5;
	for(int i=1;i<=n;i++)
	{
		for(int j=1;j<=n;j++ )
		{
			if(j<=n-i+1)
			{
				printf("* ");
			}
		}
		printf("\n");
	}
}