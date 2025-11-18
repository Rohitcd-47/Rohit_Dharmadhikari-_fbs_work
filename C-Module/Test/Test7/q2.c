//awp to check array is palindrome or not

#include <stdio.h>
#include <string.h>
int palindrome(int*,int);
void main()
{
	int arr[] = {1,2,3,4,4,3,2,1};
	int size = 8;
	int res = palindrome(arr,size);
	if(res==1)
		printf("Palindrome");
	else if(res==0)
		printf("Not");
}

int palindrome(int* arr,int size)
{
	int mid = size/2;
	for(int i=0; i<mid;i++)
	{
		if(arr[i] != arr[size-i-1])
			return 0;
	}
	return 1;
}