//Student (rollNo, name, marks)

#include <stdio.h>
#include <string.h>
struct student
{
	int rollno;
	char name[20];
	int marks;
};

void main()
{
	struct student s1,s2;
	s1.rollno = 101;
	strcpy(s1.name,"rohit");
	s1.marks = 85;
	
	printf("Details of student 1");
	printf("\nRollno : %d",s1.rollno);
	printf("\nName : %s",s1.name);
	printf("\nMarks : %d",s1.marks);
	
	printf("\n\nEnter details of student 2\n");
	printf("Enter roll no :");
	scanf("%d",&s2.rollno);
	
	printf("Enter name : ");
	scanf("%s",s2.name);
	
	printf("Enter marks: ");
	scanf("%d",&s2.marks);
	
	printf("\nRollno : %d\n",s2.rollno);
	printf("Name : %s\n",s2.name);
	printf("Marks : %d\n",s2.marks);
}