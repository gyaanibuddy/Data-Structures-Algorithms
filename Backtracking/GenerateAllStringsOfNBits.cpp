#include<iostream>
using namespace std;
int arr[1000] = {0};
void generateString(int n,int size)
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
		arr[n-1] = 0;
		generateString(n-1,size);
		arr[n-1] = 1;
		generateString(n-1,size);
	}
}
int main()
{
	int n;
	cout<<"Enter the size of bits"<<endl;
	cin>>n;
	generateString(n,n);
	return 0;
}
