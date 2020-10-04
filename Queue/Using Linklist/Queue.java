import java.util.Scanner;
import java.util.Stack;
class Node
{
	int data;
	Node next;
	public Node(int data)
	{
		this.data = data;
		next = null;
	}
}
public class Queue
{	
	Node head;
	
	public Queue()
	{
		head = null;
	}
	public boolean isEmpty()
	{
		if(head == null)
			return true;
		return false;
	}
	public void enqueue(int data)
	{
		if(isEmpty())
		{
			head = new Node(data);
		}
		else
		{
			Node p = head;
			while(p.next!= null)
			{
				p = p.next;
			}
			p.next = new Node(data);
		}	
	}
	public int dequeue()
	{
		if(isEmpty())
		{
			System.out.println("Queue Empty");
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
		while(p!= null)
		{
			System.out.println(p.data);
			p = p.next;
		}
	}
	public void deleteQueue()
	{
		head = null;
	}
	public void reverse()
	{
		Stack s = new Stack();
		while(!isEmpty())
			s.push(dequeue());
		while(!s.empty())
			enqueue((int)s.pop());
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		Queue obj = new Queue();
		int choice;
		do
		{
			System.out.println("1. Enqueue\n2. Dequeue\n3. print\n4. Delete Queue\n5. Reverse Queue\n6. Exit");
			choice = sc.nextInt();
			switch(choice)
			{
				case 1: System.out.println("Enter Element");
					int data = sc.nextInt();
					obj.enqueue(data);
					break;
				case 2: System.out.println("Dequeue Element = "+obj.dequeue());
					break;
				case 3: obj.print();
					break;
				case 4: obj.deleteQueue();
					break;
				case 5: obj.reverse();
					break;
				case 6: return;
			}
		}while(true);	
	}
}
