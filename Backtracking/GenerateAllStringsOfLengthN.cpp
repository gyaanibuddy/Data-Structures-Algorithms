#include<iostream>
using namespace std;
int arr[1000]={0};
void fun(int n,int size)
{
	if(n<1)
	{
		for(int i = size-1;i>=0;i--)
		{
			cout<<arr[i];
		}	
		cout<<endl;
	}
	else
	{
		for(int i = 0;i<size;i++)
		{
			arr[n-1] = i;
			fun(n-1,size);
		}
	}
}
int main()
{
	int n;
	cout<<"Enter number"<<endl;
	cin>>n;
	fun(n,n);
	return 0;
}
