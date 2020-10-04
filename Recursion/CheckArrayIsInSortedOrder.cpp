#include<iostream>
using namespace std;
bool checkArray(int n,int *arr)
{
	if(n==1)
	{
		return true;
	}
	else
	{
		return arr[n-1]<arr[n-2]?false:checkArray(n-1,arr);
	}
}
int main()
{
	int n;
	cout<<"Enter size of array"<<endl;
	cin>>n;
	int arr[n];
	cout<<"Enter "<<n<<" numbers for array"<<endl;
	for(int i = 0;i<n;i++)
	{
		cin>>arr[i];
	}
	cout<<checkArray(n,arr)<<endl;
	return 0;
}
