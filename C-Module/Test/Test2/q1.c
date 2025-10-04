//

#include <stdio.h>
void main()
{
	int unit= 55;
	
	if(unit<=50 && unit>0) 
	{
		printf("%drs",30*unit);
	}
	else if (unit>50 && unit<=150)
	{
		printf("%drs",40*unit);
	}
	else if(unit>150)
	{
		printf("%drs",50*unit);
	}
	
}