#include<iostream>
using namespace std;
class Node
{
	public:
		int data;
		Node* next;
		
		Node(int data)
		{
			this->data = data;
			next = NULL;
		}
};
class Sll
{
	Node* head = NULL;
	int size = 0;
	public:
		void create()
		{
			int di = 0;
			do
			{
				cout<<"Do you want to insert Element in Linklist(1 for insert 0 for stop)"<<endl;
				cin>>di;
				if(di == 0)
				{
					break;
				}
				size++;
				int data = 0;
				cout<<"Enter Element"<<endl;
				cin>>data;
				if(head == NULL)
				{
					head = new Node(data);
				}
				else
				{
					Node *p = head;
					while(p->next != NULL)
					{
						p = p->next;
					}
					p->next = new Node(data);
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
			cout<<endl;
			cout<<"Length of linklist = "<<size<<endl;
		}
		void insert()
		{
			int data = 0,pos = 0;
			cout<<"Enter Element"<<endl;
			cin>>data;
			cout<<"Enter position"<<endl;
			cin>>pos;
			insert(data,pos);
		}
		void insert(int data,int pos)
		{
			int k = 1;
			Node *p = NULL, *q = NULL;
			if(head == NULL)
			{
				head = new Node(data);
			}
			else if(pos == 1)
			{
				p = new Node(data);
				p->next = head;
				head = p;
			}
			else
			{
				p = head;
				while((p!=NULL)&&(k!=pos))
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
		void deleteFromList()
		{
			int pos = 0;
			cout<<"Enter Position"<<endl;
			cin>>pos;
			if(pos<1||pos>size)
			{
				cout<<"Invalid Position"<<endl;
				return;
			}
			deleteFromList(pos);
		}
		void deleteFromList(int pos)
		{
			int k = 1;
			Node *p=NULL,*q = NULL;
			if(head == NULL)
			{
				cout<<"LinkList not Present"<<endl;
				return;
			}
			else if(pos == 1)
			{
				p = head;
				head = head ->next;
				delete p;
			}
			else
			{
				p = head;
				q = head;
				while((p!=NULL)&&(k!=pos))
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
		void clearList()
		{
			Node *p = head,*q = head;
			while(p!=NULL)
			{
				q = p->next;
				delete(p);
				p = q;
				size--;
			}
			head = NULL;
		}
		void find()
		{
			int index = 0;
			cout<<"Enter nth index from last"<<endl;
			cin>>index;
			if(index<1||index>size)
			{
				cout<<"Invalid index"<<endl;
				return;
			}
			find(index);	
		}
		void find(int index)
		{
			int k = 1;
			Node *p = head;
			Node *ptr1 = head;
			Node *ptr2 = head;
			while((ptr1!=NULL)&&(k!=index))
			{
				k++;
				ptr1 = ptr1->next;
			}
			while(ptr1->next!=NULL)
			{
				ptr2 = ptr2->next;
				ptr1 = ptr1->next;
			}
			cout<<"Element at "<<index<<" = "<<ptr2->data<<endl;
		}
		void reverse()
		{
			Node *p = NULL,*q = NULL;
			while(head != NULL)
			{
				p = head->next;
				head->next = q;
				q = head;
				head = p;
			}
			head = q;
		}
		void reverseUsingRecursion()
		{
			head = reverseUsingRecursion(head);
		}
		Node* reverseUsingRecursion(Node *node)
		{
			if(node == NULL) return NULL;
			
			if(node->next == NULL) 
			{
				head = node;
				return node;
			}
			
			Node *p = reverseUsingRecursion(node->next);
			p->next = node;
			node ->next = NULL;
			return node;
		}
		void findMiddle()
		{
			Node *p = NULL, *q = NULL;
			p=q=head;
			int i =0;
			while(p->next!=NULL)
			{
				if(i == 0)
				{
					p = p->next;
					i=1;
				}
				else if(i==1)
				{
					q = q->next;
					p = p->next;
					i = 0;
				}
			}
			cout<<q->data;
		}
};
int main()
{
	Sll obj;
	obj.create();
	
	int choice = 0;
	do
	{
		cout<<endl<<"1. Insert\n2. Traverse\n3. Delete\n4. Clear List\n5. Find nth number from last\n6. Reverse\n7.Reverse Using Recursion\n8. Find Middle\n9. Exit"<<endl;
		cin>>choice;
		switch(choice)
		{
			case 1: obj.insert();
				break;
			case 2: obj.traverse();
				break;
			case 3: obj.deleteFromList();
				break;
			case 4: obj.clearList();
				break;
			case 5: obj.find();
				break;
			case 6: obj.reverse();
				break;
			case 7: obj.reverseUsingRecursion();
				break;
			case 8: obj.findMiddle();
				break;
			case 9: return 0;
			
			default: cout<<"Enter Correct option"<<endl;
				 break;
		}
	}while(true);
	return 0;
}
