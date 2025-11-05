#include<stdio.h>
#include<stdlib.h>

void mergeArr(int*, int*, int*);

void main()
{
	int* arr= (int*) malloc(sizeof(int) * 4);
	printf("Enter elements of arr: ");
	
	for(int i=0; i < 4; i++)
	{
		scanf("%d",&arr[i]);
	}
	
	int* brr= (int*) malloc(sizeof(int) * 3);
	printf("Enter elements of brr: ");
	
	for(int i=0; i < 3; i++)
	{
		scanf("%d",&brr[i]);
	}
	
	int crr[7];
	mergeArr(arr,brr,crr); 
}

void mergeArr(int* arr, int* brr, int* crr)
{
	for(int i=0;i<4;i++)
		crr[i] = arr[i];
	
	
	for(int i=0,j=4;i<3;i++,j++)
		crr[j] = brr[i];
	
	for(int i=0;i<7;i++)
		printf("%d ",crr[i]);
}