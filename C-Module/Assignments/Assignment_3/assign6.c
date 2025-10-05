//6 Check the given number is Perfect number or not.
//Input: n = 28
//Output: Perfect

#include <stdio.h>
void main()
{
	int n = 8;
	int i = 1,store=0;
	while(i<n)
	{
		if(n%i==0)
		{
			store = store + i;
		}
		i++;
	}
	printf("%d\n",store);
	
	if(store==n)
	{
		printf("Perfect number");
	}
	else
	{
		printf("Not perfect number");
	}
}

