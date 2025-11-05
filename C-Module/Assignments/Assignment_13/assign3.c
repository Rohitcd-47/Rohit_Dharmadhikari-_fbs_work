//3. Find sum of all numbers.

#include <stdio.h>
void sumofarr(int*);
void main()
{
	int* arr = (int*)malloc(sizeof(int)*5);
	printf("Enter elements = ");
	for(int i=0;i<5;i++)
	{
		scanf("%d",&arr[i]);
	}
	sumofarr(arr);

}

void sumofarr(int* arr)
{
	int sum = 0;
	for(int i=0;i<5;i++)
	{
		sum = sum + arr[i];
	}
	printf("The sum of all the elements present in the array = %d",sum);
}

