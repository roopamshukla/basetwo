#include<stdio.h>
int bin_search(int arr[],int srch)
{
	int low=0,high=9;
	while(low<high)
	{
		
		int mid=(high+low)/2;
		if(srch>*(arr+mid))
			{
					low=mid+1;
			}
			else if(srch<*(arr+mid))
			{
					high=mid-1;
			}
			else
			{
			return mid;	
			}
	}
	return -1;
}
int main()
{
	int arr[10]={1,3,5,5,7,9,10,14,15,16};
	int index=bin_search(arr,5);
	if(index!=-1)
	printf("%d",index+1);
	else
	printf("number not found");
}
