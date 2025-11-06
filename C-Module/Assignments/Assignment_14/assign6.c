
//6. Date (date, month, year)

#include <stdio.h>
#include <string.h>

typedef struct
{
	int date,month,year;
}date;

void main()
{
	date t1;
	t1.date = 31;
	t1.month = 10;
	t1.year = 2003;
	
	printf("%d ",t1.date);
	printf("%d ",t1.month);
	printf("%d ",t1.year);
}