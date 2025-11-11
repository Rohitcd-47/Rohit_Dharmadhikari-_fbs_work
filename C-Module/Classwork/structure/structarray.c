#include <stdio.h>
#include <string.h>

typedef struct stud
{
	int roll;
	char name[20];
	int m;
}stud;

void main()
{
	stud sarr[3];
	printf("------ Enter the details of students ----\n\n\n");
	
	for(int i=0; i<3; i++)
	{
		printf("Enter roll no = ");
		scanf("%d",&sarr[i].roll);
		printf("Enter name : ");
		scanf("%s",sarr[i].name);
		printf("Enter marks of the student = ");
		scanf("%d",&sarr[i].m);
		
		//printf("Details of Student %d is saved !!!\n",++i);
	}

	printf("\n");
	for(int i=0;i<3;i++)
	{
		printf("Roll no %d ",sarr[i].roll);
		printf("Name %s ",sarr[i].name);
		printf("Marks %d \n",sarr[i].m);
	} 
	
}