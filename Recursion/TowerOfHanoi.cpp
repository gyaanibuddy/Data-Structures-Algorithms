#include<iostream>
using namespace std;
void toh(int n,char src,char dest,char inter)
{
	if(n==1)
	{
		cout<<"Move disk 1 from "<<src<<" to "<<dest<<endl;
		return;
	}
	//Move disks from source node to the intermediatory node using destination node
	toh(n-1,src,inter,dest);
	cout<<"Move disk "<<n<<" from "<<src<<" to "<<dest<<endl;
	//Move disks from intermediatory node to the destination node using source node
	toh(n-1,inter,dest,src);
}
int main()
{
	toh(3,'a','c','b');
	return 0;
}
