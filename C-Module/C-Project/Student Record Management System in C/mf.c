// Student Database Management Menu Driven Code.

#include <stdio.h>
#include <string.h>

typedef struct student
{
    int rollno, marks;
    char name[20];
} student;

// Function declarations
void storestudent(student*, int, int);
void displaystudent(student*, int);
int searchstudent(student*, int, int);
void updatestudent(student*, int);
void deletestudent(student*, int*, int);

void main()
{
    student table[50];
    int count = 0;
    int choice;

    printf("How many students' data you want to fill initially: ");
    scanf("%d", &count);
    storestudent(table, 0, count);

    while(1)
    {
        printf("\n--- MENU ---\n");
        printf("1. Display\n2. Add\n3. Search\n4. Update\n5. Delete\n6. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        if(choice == 1)
            displaystudent(table, count);

        else if(choice == 2)
        {
            int n;
            printf("Enter number of students you want to add: ");
            scanf("%d", &n);
            storestudent(table, count, n);
            count += n; 
        }

        else if(choice == 3)
        {
            int r;
            printf("Enter roll number to search: ");
            scanf("%d", &r);
            int result = searchstudent(table, count, r);
            if(result != -1)
                printf("\nStudent found: %s with marks %d\n", table[result].name, table[result].marks);
            else
                printf("\nStudent not found!\n");
        }

        else if(choice == 4)
            updatestudent(table, count);

        else if(choice == 5)
        {
            int r;
            printf("Enter roll number to delete: ");
            scanf("%d", &r);
            deletestudent(table, &count, r);
        }

        else if(choice == 6)
            break;

        else
            printf("Invalid choice!\n");
    }
}

void storestudent(student* table, int start, int n)
{
    for(int i=0; i<n; i++)
    {
        printf("\nEnter rollno: ");
        scanf("%d", &table[start + i].rollno);
        printf("Enter name: ");
        scanf("%s", table[start + i].name);
        printf("Enter marks: ");
        scanf("%d", &table[start + i].marks);
    }
}

void displaystudent(student* table, int size)
{
    if(size == 0)
    {
        printf("\nNo records found!\n");
        return;
    }

    printf("\n-----------------------------------------------------------\n");
    printf("%-15s %-20s %-10s\n", "Roll No", "Name", "Marks");
    printf("-----------------------------------------------------------\n");

    for(int i=0; i<size; i++)
    {
        printf("%-15d %-20s %-10d\n",
               table[i].rollno,
               table[i].name,
               table[i].marks);
    }

    printf("-----------------------------------------------------------\n");
}

int searchstudent(student* table, int size, int r)
{
    for(int i=0; i<size; i++)
    {
        if(table[i].rollno == r)
            return i; // return index
    }
    return -1;
}

void updatestudent(student* table, int size)
{
    int r;
    printf("Enter roll number to update: ");
    scanf("%d", &r);

    int pos = searchstudent(table, size, r);
    if(pos == -1)
    {
        printf("❌ Student not found!\n");
        return;
    }

    printf("Enter new name: ");
    scanf("%s", table[pos].name);
    printf("Enter new marks: ");
    scanf("%d", &table[pos].marks);

    printf("✅ Record updated successfully!\n");
}

void deletestudent(student* table, int* size, int r)
{
    int pos = searchstudent(table, *size, r);
    if(pos == -1)
    {
        printf("❌ Student not found!\n");
        return;
    }

    for(int i=pos; i<*size - 1; i++)
    {
        table[i] = table[i+1];
    }
    (*size)--;
    printf("✅ Student record deleted successfully!\n");
}
