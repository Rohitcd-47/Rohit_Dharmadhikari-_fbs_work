// strrev("rohit") ? "tihor"

#include <stdio.h>
#include <string.h>

char* mystrrev(char*);
void main()
{
	char str[20] = "rohit";
	char* result =  mystrrev(str);
	printf("After reversing the string : %s",result);
}

char* mystrrev(char* str)
{
	char temp[20];
	strcpy(temp,str);
	int size =  strlen(temp);
//	printf("%d",size);
	
	for(int i=size-1,j=0; i>=0 ; i--,j++)
	{
		str[i] = temp[j];
	}
	return str;
}	