//9. Complex (real, imaginary)

#include <stdio.h>
#include <string.h>

typedef struct
{
	int real,img;
}complex;

void main()
{
	complex c1;
	c1.real = 10;
	c1.img = 5;
	
	printf("%d+%di",c1.real,c1.img);
}