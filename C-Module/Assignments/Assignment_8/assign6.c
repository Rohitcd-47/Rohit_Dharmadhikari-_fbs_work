//6. Accept array and print only prime numbers of array.

#include <stdio.h>
void main()
{
	int arr[4];
	printf("Enter elements = ");
	for(int i=0;i<4;i++)
	{
		scanf("%d",&arr[i]);
	}
	
	for(int i=0;i<4;i++)
	{
		if(arr[i] <= 1)
		{
			continue;
		}
		else if(arr[i] == 2)
		{
			printf("%d ",arr[i]);
			i++;
		}
		
		int flag = 0;
		for(int j=2;j<arr[i];j++)
		{
			if(arr[i] % j == 0)
			{
				flag = 0;
				break;
			}
			else
			{
				flag++;
			}
		}
		
		if(flag>0)
		{
			printf("%d ",arr[i]);
		}
	
	}
}

