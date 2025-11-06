//10. Product (id, name, quantity, price)

#include <stdio.h>
#include <string.h>

typedef struct
{
	int id,price,qt;
	char name[20];
}product;

void main()
{
	product p;
	p.id = 1001;
	strcpy(p.name,"toothpaste");
	p.price = 65;
	p.qt = 5;
	
	printf("Product id: %d\n",p.id);
	printf("Product name: %s\n",p.name);
	printf("Product price: %d\n",p.price);
	printf("Product quantity: %d\n",p.qt);
}