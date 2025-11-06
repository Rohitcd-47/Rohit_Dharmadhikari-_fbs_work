//Distance ( feet, inch)

#include <stdio.h>
#include <string.h>

typedef struct
{
	int feet,inch;
}distance;

void main()
{
	distance d1;
	d1.feet = 5;
	d1.inch = 7;
	printf("Distance = %dft %d'inch",d1.feet,d1.inch);
}