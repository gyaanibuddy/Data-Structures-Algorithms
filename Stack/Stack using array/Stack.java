import java.util.Scanner;
class Stack
{
	int MAXSIZE = 10;
	int[] arr;
	int top;
	public Stack()
	{
		arr = new int[MAXSIZE];
		top = -1;
	}
	public boolean IsEmpty()
	{
		if(top==-1)
			return true;
		return false;
	}
	public boolean IsFull()
	{
		if(top==MAXSIZE-1)
			return true;
		return false;
	}
	public void push(int data)
	{
		if(IsFull())
		{
			System.out.println("Stack overflow");
			return;	
		}
		else
		{
			top++;
			arr[top] = data; 
		}	
	}
	public int pop()
	{
		if(IsEmpty())
		{
			System.out.println("Stack underflow");
			return -1;				
		}
		else
		{
			int data = arr[top];
			top--;
			return data;
		}
	}
	public void print()
	{
		if(top == -1)
		{
			System.out.println("Stack Empty");
			return ;
		}	
		else
		{
			for(int i = top;i>=0;i--)
			{
				System.out.println(arr[i]);
			}
		}
	}
	public void deleteStack()
	{
		top = -1;
		arr = new int[MAXSIZE];
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		Stack obj = new Stack();
		int choice;
		do
		{
			System.out.println("1. push\n2. pop\n3. print\n4. Delete Stack\n5. Exit");
			choice = sc.nextInt();
			switch(choice)
			{
				case 1: System.out.println("Enter Element");
					int data = sc.nextInt();
					obj.push(data);
					break;
				case 2: System.out.println("Popped Element = "+obj.pop());
					break;
				case 3: obj.print();
					break;
				case 4: obj.deleteStack();
					break;
				case 5: return;
			}
		}while(true);	
	}
}
