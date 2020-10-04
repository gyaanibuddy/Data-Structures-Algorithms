#include<iostream>
using namespace std;
class Node
{
	public:
		int data;
		Node *next;
		Node(int data)
		{
			this->data = data;
			next = NULL;
		}	
};
class Cll
{
	Node *head = NULL;
	int size = 0;
	public:
		void create()
		{
			int data;
			int inp;
			do
			{
				cout<<"\n1.Element\n2.Exit\n";
				cin>>inp;
				if(inp == 2)
				{
					break;
				}
				else
				{
					cout<<"Enter Element"<<endl;
					cin>>data;
					if(head == NULL)
					{
						head = new Node(data);
						head ->next = head;
					}
					else
					{
						Node *p = head;
						do
						{
							p = p->next;
						}while(p->next!=head);
						p->next = new Node(data);
						p->next->next = head;
					}
				}
				size++;
			}while(true);
		}
		void traverse()
		{
			Node *p = head;
			if(head!=NULL)
			{
				do
				{
					cout<<p->data<<" ";
					p = p->next;
				}while(p!=head);
				cout<<endl<<"Size of linklist = "<<size<<endl;
			}
			else
			{
				cout<<endl<<"Size of linklist = "<<size<<endl;
			}
		}
		void insert()
		{
			int data,pos;
			cout<<"Enter Element"<<endl;
			cin>>data;
			cout<<"Enter position"<<endl;
			cin>>pos;
			insert(data,pos);
		}
		void insertAtFront(int data)
		{
			Node *q = new Node(data);
			Node * p = head;
			while(p->next!=head)
			{
				p = p->next;
			}
			p->next = q;
			q->next = head;
			head = q;
			
		}
		void insertAtEnd(int data)
		{
			Node *p = head;
			while(p->next!=head)
			{	
				p = p->next;
			}
			p->next =new Node(data);
			p->next->next = head;
		}
		void insert(int data,int pos)
		{
			if(head == NULL)
			{
				head = new Node(data);
			}
			else if(pos == 1)
			{
				insertAtFront(data);
			}
			else if(pos >= size)
			{
				insertAtEnd(data);
			}
			else
			{
				int k = 1;
				Node *p = head;
				Node *q = head;
				while((p->next!=head)&&(k!=pos))
				{
					k++;
					q = p;
					p = p->next;
				}
				q->next = new Node(data);
				q->next->next = p;
			}
			size++;
		}
		void deleteElement()
		{
			int pos;
			cout<<"Enter position"<<endl;
			cin>>pos;
			if(pos<1||pos>size)
			{
				cout<<"Invalid Position"<<endl;
				return;
			}
			deleteElement(pos);
		}
		void deleteAtFront()
		{
			if(head->next == head)
			{
				delete head;
				head =NULL;
			}
			else
			{
				Node *p = head;
				Node *q = head;
				while(p->next!=head)
				{
					p = p->next;
				}
				p->next = head->next;
				head = head->next;
				delete q;
			}
		}
		void deleteAtEnd()
		{
			if(head->next == head)
			{
				delete head;
				head = NULL;
			}
			else
			{
				Node *p = head,*q= head;
				while(p->next!=head)
				{
					q = p;
					p = p->next;
				}
				q->next = head;
				delete p;
			}
		}
		void deleteElement(int pos)
		{
			if(head == NULL)
			{
				cout<<"List is empty"<<endl;
			}
			else if(pos == 1)
			{
				deleteAtFront();
			}
			else if(pos == size)
			{
				deleteAtEnd();
			}
			else
			{
				int k = 1;
				Node *p= head,*q = head;
				while((p->next!=head)&&(k!=pos))
				{
					k++;
					q = p;
					p = p->next;
				}
				q->next = p->next;
				delete p;
			}
			size--;
		}
};
int main()
{
	Cll obj;
	obj.create();
	int choice = 0;
	do
	{
		cout<<"\n1. Insert\n2. Traverse\n3. Delete\n4. Exit"<<endl;
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
			
			default: cout<<"Invalid Choice"<<endl;
		}
	}while(true);
	return 0;
}
