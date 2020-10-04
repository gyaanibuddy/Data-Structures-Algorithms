#include<iostream>
using namespace std;
class Node
{
	public:
	int data;
	Node *next;
		Node(int data)
		{
			this -> data = data;
			next = NULL;	
		}
};
int main()
{
	int np,m;
	cout<<"Enter number of players"<<endl;
	cin>>np;
	cout<<"Enter mth player(mth player gets eliminited)"<<endl;
	cin>>m;
	Node *p,*q;
	p = q = new Node(1);
	for(int i = 2;i<=np;i++)
	{
		p->next = new Node(i);
		p = p->next;
	}
	p->next = q;
	for(int i = 2;i<=np;i++)
	{
		for(int j = 1;j<m;j++)
		{
			p = p->next;
		}
		p->next = p -> next -> next;
	}
	cout<<p->data<<endl;
	return 0;
}
