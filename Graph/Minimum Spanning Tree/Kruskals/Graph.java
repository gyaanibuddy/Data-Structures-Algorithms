import java.util.*;
class Node implements Comparator<Node>
{
	int src,des,cost;
	public Node()
	{
		src = des = cost = 0;
	}
	public Node(int s,int d,int c)
	{
		src = s;
		des = d;
		cost = c;
	}
	public int compare(Node n1, Node n2)
	{
		if(n1.cost<n2.cost)
			return -1;
		else if(n1.cost>n2.cost)
			return 1;
		else 
			return 0;
	}
	
}
class subset
{
	int parent,rank;
}
public class Graph
{
	Node arr[];
	int v,e;
	subset[] subsets; 
	public Graph()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of vertices");
		v = sc.nextInt();
		System.out.println("Enter number of edges");
		e = sc.nextInt();
		arr = new Node[e];
		subsets = new subset[v];
		for(int i = 0;i<v;i++)
		{
			subsets[i] = new subset();
		}
		for(int i = 0;i<v;i++)
		{
			subsets[i].parent = i;
			subsets[i].rank = 0;
		}
	}
	public int find(subset[] subsets,int i)
	{
		if(subsets[i].parent!=i)
			subsets[i].parent = find(subsets,subsets[i].parent); 
		
		return subsets[i].parent;
	}
	public void union(subset[] subsets,int x,int y)
	{
		int xroot = find(subsets,x);
		int yroot = find(subsets,y);
		if(subsets[xroot].rank < subsets[yroot].rank)
			subsets[xroot].parent = yroot;
		else if(subsets[xroot].rank > subsets[yroot].rank)
			subsets[yroot].parent = xroot;
		
		else
		{
			subsets[yroot].parent = xroot;
			subsets[xroot].rank++;
		}
		
	}
	public void createLink()	
	{
		Scanner sc = new Scanner(System.in);
		for(int i = 0;i<e;i++)
		{
			System.out.println("Enter Link");
			int u = sc.nextInt();
			int v = sc.nextInt();
			System.out.println("Enter cost");
			int c = sc.nextInt();
			arr[i] = new Node(u,v,c);
		}
	}
	public void find()
	{
		Vector<Node> vect = new Vector<Node>();
		Scanner sc = new Scanner(System.in);
		int edge = 0;
		PriorityQueue<Node> pq = new PriorityQueue<Node>(new Node());
		for(int i = 0;i<e;i++)
		{
			pq.offer(arr[i]);
		}
		int u1 = 0;
		int v1 = 0;
		Node n;
		int x,y;
		while(edge!=(v-1))
		{
			n = pq.remove();
			u1 = n.src;
			v1 = n.des;
			x = find(subsets,u1);
			y = find(subsets,v1);
			if(x!=y)
			{
				vect.add(n);
				union(subsets,x,y);
				edge++;
			}
		}
		print(vect);
	}
	public void print(Vector<Node> v)
	{
		for(int i = 0;i<v.size();i++)
		{
			System.out.println(v.get(i).src+" "+v.get(i).des+" "+v.get(i).cost);
		}
	}
	public static void main(String[] args)
	{
		Graph obj = new Graph();
		obj.createLink();
		obj.find();
	}
}
