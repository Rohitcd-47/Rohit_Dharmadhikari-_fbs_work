//5. SalesManager (id, name, salary, incentive, target)

#include <stdio.h>
#include <string.h>
struct salesmanager
{
	int id,target;
	char name[20];
	float salary,incentive;
};

void main()
{
	struct salesmanager e1,e2;
	e1.id = 10;
	strcpy(e1.name,"abc");
	e1.salary = 25000;
	e1.incentive = 0.2;
	e1.target = 40;
	
	printf("Salesmanager ID : %d\n",e1.id);
	printf("Salesmanager name : %s\n",e1.name);
	printf("Salesmanager salary : %f\n",e1.salary);
	printf("Salesmanager incentive : %f\n",e1.incentive);
	printf("Salesmanager targets : %d\n",e1.target);
	
	printf("\nDetails of HR2\n");
	
	scanf("%d",&e2.id);
	scanf("%s",e2.name);
	scanf("%f",&e2.salary);
	scanf("%f",&e2.incentive);
	scanf("%d",&e1.target);
	
	
	printf("HR ID : %d\n",e2.id);
	printf("HR name : %s\n",e2.name);
	printf("HR salary : %f\n",e2.salary);
	printf("HR commission : %f\n",e2.incentive);
	printf("HR targets %d\n",e1.target);

}