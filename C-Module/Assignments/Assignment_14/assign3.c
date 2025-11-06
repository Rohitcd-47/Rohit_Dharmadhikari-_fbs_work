//3. Admin (id, name, salary, allowance)


#include <stdio.h>
#include <string.h>

struct admin
{
	int id;
	char name[20];
	int salary;
	int allowance;
};

void main()
{
	struct admin a1,a2;
	a1.id = 11;
	strcpy(a1.name,"Rohit");
	a1.salary = 100000;
	a1.allowance = 4000;
	
	printf("Details of Admin 1 \n");
	printf("Admin id :%d \n",a1.id);
	printf("Admin name : %s \n",a1.name);
	printf("Admin salary :%d \n",a1.salary);
	printf("Admin allowance :%d \n",a1.allowance);
	
	
	printf("Enter id ");
	scanf("%d",&a2.id);
	
	printf("Enter name ");
	scanf("%s",a2.name);
	
	printf("Enter salary ");
	scanf("%d",&a2.salary);
	
	printf("Enter allowance\n");
	scanf("%d",&a2.allowance);
	
	printf("Details of Employee 2 \n");
	
	printf("Employee id :%d \n",a2.id);
	printf("Employee name : %s \n",a2.name);
	printf("Employee salary :%d \n",a2.salary);
	printf("Employee allowance :%d \n",a2.allowance);
}