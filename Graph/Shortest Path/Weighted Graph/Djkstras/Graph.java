import java.util.*;
class Node implements Comparator<Node> { 
	public int node; 
	public int cost; 

	public Node() 
	{ 
	} 

	public Node(int node, int cost) 
	{ 
		this.node = node; 
		this.cost = cost; 
	} 

	@Override
	public int compare(Node node1, Node node2) 
	{ 
		if (node1.cost < node2.cost) 
			return -1; 
		if (node1.cost > node2.cost) 
			return 1; 
		return 0; 
	} 
} 
public class Graph
{
	LinkedList<Integer> arr[];
	private Set<Integer> settled; 
	private PriorityQueue<Node> pq; 
	int[][] weight;
	int v,e;
	public Graph()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of nodes");
		v = sc.nextInt();
		System.out.println("Enter number of edges");
		e = sc.nextInt();
		arr = new LinkedList[v];
		for(int i = 0;i<v;i++)
		{
			arr[i] = new LinkedList();
		}
		weight = new int[v][v];
		settled = new HashSet<Integer>(); 
		pq = new PriorityQueue<Node>(v, new Node()); 
	}
	public void createLink()
	{
		int u,v;
		Scanner sc = new Scanner(System.in);
		for(int i = 0;i<e;i++)
		{
			System.out.println("Enter link");
			u = sc.nextInt();
			v = sc.nextInt();
			arr[u].add(v);
			System.out.println("Enter cost");
			weight[u][v] = sc.nextInt();
		}	
	}
	public void find()
	{
		Scanner sc = new Scanner(System.in);
		int[] parent,dist;
		parent = new int[v];
		dist = new int[v];
		System.out.println("Enter source");
		int s = sc.nextInt();
		System.out.println("Enter destination");
		int d = sc.nextInt();
		
			if(search(s,d)==false)
			{
				System.out.println("Source and destination are not connected");
				return;
			}			
			shortestPath(s,parent,dist);
			Vector<Integer> v = new Vector<Integer>();
			int temp = d;
			while(temp!=-1)
			{
				v.add(temp);
				temp = parent[temp];
			}
		System.out.println("Minimum distance to reach "+d+" from "+s+" = "+dist[d]);
			System.out.print("Shortest path = ");
			for(int i = v.size()-1;i>=0;i--)
			{
				System.out.print(v.get(i)+" ");
			}
			System.out.println();
	}	
	public boolean search(int s,int d)
	{
		Queue<Integer> q = new LinkedList();
		q.add(s);
		while(!q.isEmpty())
		{
			int x = q.poll();
			for(int i:arr[x])
			{
				q.add(i);
				
				if(i == d)
					return true;
			}
		}
		return false;
	}
	public void shortestPath(int s,int[] parent,int[] dist)
	{
		for(int i = 0;i<v;i++)
		{
			parent[i] = -1;
			dist[i] = Integer.MAX_VALUE;
		}
		dist[s] = 0;
		pq.add(new Node(s,0));
		while (settled.size()!=v) 
		{ 
			int u = 0;
			try
			{
				u = pq.remove().node;
			}
			catch(Exception e)
			{
				break;
			} 
			settled.add(u); 
			int edgeDistance = -1;
			int newDistance = -1;
			for(int i : arr[u])
			{
				if(!settled.contains(i))
				{
			edgeDistance =	weight[u][i];				
			 		newDistance = dist[u] + edgeDistance;
				 	if(newDistance<dist[i])
				 	{
				 		dist[i] = newDistance;
				 		parent[i] = u;
				 	}
				 	pq.add(new Node(i,dist[i]));
				}
			}
		} 

	}
	public static void main(String[] args)
	{
		Graph obj = new Graph();
		obj.createLink();
		obj.find();
	}
}
