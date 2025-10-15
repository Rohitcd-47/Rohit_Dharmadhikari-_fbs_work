#include <stdio.h>
void main()
{
	int start,end;
	printf("Enter the range : ");
	scanf("%d %d",&start,&end);
	
	for(int i=start;i<=end;i++)
	{
		printf("%d = ",start);
		for(int j=1;j<=start;j++)
		{
			if(start%j==0)
			{
				printf("%d ",j);
			}
		}
		printf("\n");
		start++;
	}
}