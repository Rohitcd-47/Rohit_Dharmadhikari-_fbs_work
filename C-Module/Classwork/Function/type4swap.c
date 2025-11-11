//swapping number by type 4 function

#include <stdio.h>

int swap(int,int);

int main()
{
	int a = 12,b=13;
	b= swap(12,13);
	
	printf("After swapping : %d %d",a,b);
}

int swap(int a,int b)
{
	int temp = a;
	a = b;
	b = temp;
	//printf("%d %d",a,b);
	return b;
}