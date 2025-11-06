//7. Time (hour, min, sec)

#include <stdio.h>
#include <string.h>

typedef struct
{
	int hour,min,sec;
}time;

void main()
{
	time t1;
	printf("Enter hour: ");
	scanf("%d",&t1.hour);
	
	printf("Enter min: ");
	scanf("%d",&t1.min);
	
	printf("Enter sec: ");
	scanf("%d",&t1.sec);
	
	printf("%dhr %dmin %dsec",t1.hour,t1.min,t1.sec);
}