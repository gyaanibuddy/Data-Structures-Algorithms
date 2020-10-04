#include<iostream>
using namespace std;
int fact(int n)
{
	if(n<2)
	{
		return 1;
	}
	return n*fact(n-1);
}
int main()
{
	int n;
	cout<<"Enter number"<<endl;
	cin>>n;
	int ans = fact(n);
	cout<<"Factorial of "<<n<<" is "<<ans<<endl;
	return 0;
}
