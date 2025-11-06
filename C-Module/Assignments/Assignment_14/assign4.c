//4. HR (id, name, salary, commission)

#include <stdio.h>
#include <string.h>
struct hr
{
	int id;
	char name[20];
	int salary;
	float commission;
};

void main()
{
	struct hr e1,e2;
	e1.id = 10;
	strcpy(e1.name,"abc");
	e1.salary = 25000;
	e1.commission = 0.2;
	
	printf("HR ID : %d\n",e1.id);
	printf("HR name : %s\n",e1.name);
	printf("HR salary : %d\n",e1.salary);
	printf("HR commission : %f\n",e1.commission);
	
	printf("\nDetails of HR2\n");
	
	scanf("%d",&e2.id);
	scanf("%s",e2.name);
	scanf("%d",&e2.salary);
	scanf("%f",&e2.commission);
	
	
	printf("HR ID : %d\n",e2.id);
	printf("HR name : %s\n",e2.name);
	printf("HR salary : %d\n",e2.salary);
	printf("HR commission : %f\n",e2.commission);
//	printf("Enter details of HR.\n");
//	printf()
}