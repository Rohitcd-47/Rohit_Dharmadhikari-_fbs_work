//wap to find the power of any number 

#include <stdio.h>
//#include <math.h>

void main()
{
	int number,power;
	printf("Enter the number and the power = ");
	scanf("%d %d",&number,&power);
	
	int res = 1;
	while(power>0)
	{
		res = res*number;
		power--;
	}
	printf("Result = %d",res);
//	int res = pow(number,power);
//	printf("%d",res);
}