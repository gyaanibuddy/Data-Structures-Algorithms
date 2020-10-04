#include<iostream>
using namespace std;
class Node
{
	public:
	int data;
	Node *next,*prev;
		Node(int data)
		{
			this->data = data;
			next = NULL;
			prev = NULL; 
		}
};
class Dll
{
	Node *head = NULL;
	int size = 0;
	public:
		void create()
		{
			int data = 0;
			int inp = 0;
			do
			{
				cout<<"Enter 1 for element 0 for exit"<<endl;
				cin>>inp;
				if(inp == 0)
				{
					break;
				}
				size++;
				Node *p = head;
				cout<<"Enter Element"<<endl;
				cin>>data;
				if(head == NULL)
				{
					head = new Node(data);
				}
				else
				{
					while(p->next!=NULL)
					{
						p = p->next;
					}
					p ->next = new Node(data);
					p->next->prev = p;
				}
			}while(true);
		}
		void traverse()
		{
			Node *p = head;
			while(p!=NULL)
			{
				cout<<p->data<<" ";
				p = p->next;
			}
			cout<<"\nLinklist Size = "<<size<<endl;
		}
		void insert()
		{
			int data = 0,pos = 0;
			cout<<"Enter Element"<<endl;
			cin>>data;
			cout<<"Enter Position"<<endl;
			cin>>pos;
			insert(data,pos);
		}
		void insert(int data,int pos)
		{
			Node *p = NULL, *q =NULL;
			if(head == NULL)
			{
				head = new Node(data);
			}
			else if(pos == 1)
			{
				p = head;
				q = new Node(data);
				q->next = p;
				p->prev = q;
				head = q;
			}
			else
			{
				int k = 1;
				p = head;
				while((p->next!=NULL)&&(k!=pos-1))
				{
					k++;
					p = p->next; 
				}
				Node *r = new Node(data);
				r->next = p->next;
				r->prev = q;
				p->next = r;
				if(r->next!=NULL)
					r->next->prev = r;				
			}
			size++;
		}
		void deleteElement()
		{
			int pos = 0;
			cout<<"Enter position"<<endl;
			cin>>pos;
			if(pos<1||pos>size)
			{
				cout<<"Invalid Position"<<endl;
				return;
			}
			deleteElement(pos);
		}
		void deleteElement(int pos)
		{
			Node *p =NULL,*q = NULL;
			if(head == NULL)
			{
				cout<<"List not present"<<endl;
			}
			else if(pos == 1)
			{
				p =head;
				head = head->next;
				if(head!=NULL)
					head ->prev =NULL;
				delete p;
				
			}
			else
			{
				p = head;
				int k = 1;
				while((p!=NULL)&&(k!=pos))
				{
					k++;
					p=p->next;
				}
				q = p->prev;
				q->next = p->next;
				if(p->next!=NULL)
					p->next->prev = q;
				delete p;
			}
			size--;
		}
};
int main()
{
	Dll obj;
	obj.create();
	int choice = 0;
	do
	{
		cout<<"\n1. Insert\n2. Traverse\n3. Delete\n4.Exit"<<endl;
		cin>>choice;
		switch(choice)
		{
			case 1: obj.insert();
				break;
			case 2: obj.traverse();
				break;
			case 3: obj.deleteElement();
				break; 
			case 4: return 0;
			default : cout<<"Enter Correct choice"<<endl;
		}
	}while(true);
	return 0;
}
