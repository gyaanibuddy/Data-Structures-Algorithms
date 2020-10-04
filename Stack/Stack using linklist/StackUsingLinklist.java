import java.util.*;

class Node
{
	public int data;
	public Node next;
	
	public Node(int data)
	{
		this.data = data;
		this.next = null;
	}
}
public class StackUsingLinklist
{
	Node head;
	public StackUsingLinklist()
	{
		head = null;
	}
	public boolean IsEmpty()
	{
		if(head == null)
			return true;
		return false;
	}
	public void push(int data)
	{
		if(head == null)
		{
			head = new Node(data);
		}
		else
		{
			Node p = head;
			head = new Node(data);
			head.next = p;
		}
	}
	public int pop()
	{
		if(IsEmpty())
		{
			System.out.println("Stack is empty");
			return Integer.MIN_VALUE;
		}
		else
		{
			int data = head.data;
			head = head.next;
			return data;
		}
	}
	public void print()
	{
		Node p = head;
		while(p!=null)
		{
			System.out.println(p.data);
			p = p.next;
		}
	}
	public void deleteStack()
	{
		head = null;
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		StackUsingLinklist obj = new StackUsingLinklist();
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
