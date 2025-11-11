#include <stdio.h>
void main()
{
	typedef struct stud
	{
		int roll,m;
		char name[20];
	}stud;
	
	stud july[5];
	stud aug[10];
	stud sept[15];
	
	for(int i=0; i<5; i++)
	{
		printf("Enter roll no = ");
		scanf("%d",&july[i].roll);
		printf("Enter name : ");
		scanf("%s",july[i].name);
		printf("Enter marks of the student = ");
		scanf("%d",&july[i].m);
		
		printf("Details saved !!!\n \n");
	}
	
	for(int i=0; i<10; i++)
	{
		printf("Enter roll no = ");
		scanf("%d",&aug[i].roll);
		printf("Enter name : ");
		scanf("%s",aug[i].name);
		printf("Enter marks of the student = ");
		scanf("%d",&aug[i].m);
		
		printf("Details saved !!!\n \n");
	}
	
	for(int i=0; i<15; i++)
	{
		printf("Enter roll no = ");
		scanf("%d",&sept[i].roll);
		printf("Enter name : ");
		scanf("%s",sept[i].name);
		printf("Enter marks of the student = ");
		scanf("%d",&sept[i].m);
		
		printf("Details saved !!!\n \n");
	}
	
	printf("\n");
	for(int i=0;i<5;i++)
	{
		printf("Roll no %d ",july[i].roll);
		printf("Name %s ",july[i].name);
		printf("Marks %d \n",july[i].m);
	} 
	
	printf("\n");
	for(int i=0;i<10;i++)
	{
		printf("Roll no %d ",aug[i].roll);
		printf("Name %s ",aug[i].name);
		printf("Marks %d \n",aug[i].m);
	} 
	
	printf("\n");
	for(int i=0;i<15;i++)
	{
		printf("Roll no %d ",sept[i].roll);
		printf("Name %s ",sept[i].name);
		printf("Marks %d \n",sept[i].m);
	} 
	
}