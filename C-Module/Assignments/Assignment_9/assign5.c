//5. Print alternate elements in array.


#include <stdio.h>
void alternate(int*);
void main()
{
	int arr[5];
	printf("Enter elements = ");
	for(int i=0;i<5;i++)
		scanf("%d",&arr[i]);
	
	alternate(arr);
}

void alternate(int* arr)
{
	for(int i=0;i<5;i+=2)
		printf("%d ",arr[i]);	
}
