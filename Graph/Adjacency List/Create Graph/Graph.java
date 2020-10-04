import java.util.*;
class Node
{
	int data;
	Node next;
	public Node()
	{
		data = 0;
		next = null;
	}
	public Node(int x)
	{
		data = x;
		next = null;
	}
}
public class Graph
{
	Node[] arr;
	int v,e;
	public Graph()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number of vertices");
		v = sc.nextInt();
		System.out.println("Enter Number of Edges");
		e = sc.nextInt();		
		arr = new Node[v];
		for(int i = 0;i<v;i++)
		{
			arr[i] = new Node(i+1);
		}
	}
	public void createLink()
	{
		Scanner sc = new Scanner(System.in);
		for(int i = 0;i<e;i++)
		{
			System.out.println("Link is present in between");
			int u = sc.nextInt();
			int v = sc.nextInt();
			Node p = arr[u-1];
			while(p.next!=null)
			{
				p = p.next;
			}
			p.next = new Node(v);
		}
	}
	public void print()
	{
		for(int i = 0;i<v;i++)
		{
			Node p = arr[i].next;
			System.out.print(arr[i].data);
			while(p!=null)
			{
				System.out.print("->"+p.data);
				p = p.next;
			}
			System.out.println();
		}
	}
	public static void main(String[] args)
	{	
		Graph obj = new Graph();
		obj.createLink();
		obj.print();
	}
}
