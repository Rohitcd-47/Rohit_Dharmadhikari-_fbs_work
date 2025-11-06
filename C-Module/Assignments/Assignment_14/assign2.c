//2. Employee (id, name, salary)

#include <stdio.h>
#include <string.h>

struct employee
{
	int id;
	char name[20];
	int salary;
};

void main()
{
	struct employee e1,e2;
	e1.id = 11;
	strcpy(e1.name,"Rohit");
	e1.salary = 100000;
	
	printf("Details of Employee 1 \n");
	printf("Employee id :%d \n",e1.id);
	printf("Employee name : %s \n",e1.name);
	printf("Employee salary :%d \n",e1.salary);
	
	
	printf("Enter id ");
	scanf("%d",&e2.id);
	
	printf("Enter name ");
	scanf("%s",e2.name);
	
	printf("Enter salary ");
	scanf("%d",&e2.salary);
	
	printf("Details of Employee 2 \n");
	
	printf("Employee id :%d \n",e2.id);
	printf("Employee name : %s \n",e2.name);
	printf("Employee salary :%d \n",e2.salary);
}