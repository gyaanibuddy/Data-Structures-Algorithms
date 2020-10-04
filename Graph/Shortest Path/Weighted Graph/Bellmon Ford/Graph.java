import java.util.*;
class Node
{
	int src,dest,cost;
	public Node()
	{
		src = dest = cost = 0;
	}
	public Node(int s,int d,int c)
	{
		src = s;
		dest = d;
		cost = c;
	}
}
public class Graph
{
	Node arr[];
	int v,e;
	public Graph()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of vertices");
		v  = sc.nextInt();
		System.out.println("Enter number of edges");
		e = sc.nextInt();
		arr = new Node[e];		
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
		Scanner sc = new Scanner(System.in);
		int[] dist = new int[v];
		System.out.println("Enter source");
		int s = sc.nextInt();
		shortestPath(s,dist);	
	}
	public void shortestPath(int s,int[] dist)
	{
		for(int i = 0;i<v;i++)
		{
			dist[i] = Integer.MAX_VALUE;
		}	
		dist[s] = 0;
		
		for(int i = 0;i<(v-1);i++)
		{
			for(int j = 0;j<e;j++)
			{
				int u = arr[j].src;
				int v = arr[j].dest;
				int c = arr[j].cost;
				if(dist[u]!=Integer.MAX_VALUE && (dist[v]>dist[u]+c))
					dist[v] = dist[u] + c;
			}
		}
		//To detect negative cycle
		for(int j = 0;j<e;j++)
		{
				int u = arr[j].src;
				int v = arr[j].dest;
				int c = arr[j].cost;
				if(dist[u]!=Integer.MAX_VALUE && (dist[v]>dist[u]+c))
				{
					System.out.println("Negative cycle is present");
					return;
				}
		}
		print(dist,s);
	}
	public void print(int[] dist,int s)
	{
		for(int i = 0;i<v;i++)
		{
			System.out.println("Distance from "+s+" "+" to "+i+" = "+dist[i]);
		}	
	}
	public static void main(String[] args)
	{
		Graph obj = new Graph();
		obj.createLink();
		obj.find();
	}
}
