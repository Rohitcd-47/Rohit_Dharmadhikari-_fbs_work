// Find greater among 3 numbers

#include <stdio.h>

void main()
{
	int a = -88 , b=47, c = 32;
	if(a>b)
	{
		if(a>c)
		{
			printf("%d",a);
		}
		else
		{
			printf("%d",c);
		}
	}
	
	else
	{
		if(a<b)
		{
			if(b>c)
			{
				printf("%d",b);
			}
			else
			{
				printf("%d",c);
			}
		}
	}
	
}