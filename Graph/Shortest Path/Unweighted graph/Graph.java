import java.util.*;
class Graph
{
	LinkedList<Integer> arr[];
	int v,e;
	public Graph()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter The number of vertices");
		v = sc.nextInt();
		System.out.println("Enter number of edges");
		e = sc.nextInt();
		arr = new LinkedList[v];
		for(int i = 0;i<v;i++)
		{
			arr[i] = new LinkedList();
		}		
	}
	public void createLink()
	{
		Scanner sc = new Scanner(System.in);
		for(int i = 0;i<e;i++)
		{
			System.out.println("Enter link");
			int u = sc.nextInt();
			int v = sc.nextInt();
			arr[u].add(v);
			arr[v].add(u);
		}
	}
	public void printShortestPath()
	{
		int[] previous = new int[v];
		int[] dist = new int[v];

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter source");
		int s = sc.nextInt();
		System.out.println("Enter destination");
		int d = sc.nextInt();
		
		if(bfs(s,d,previous,dist)==false)
		{
			System.out.println("Source and destination are not connected to each other");
			return;
		}
		else
		{
			//Vector to store path
			Vector<Integer> v = new Vector();
			int temp = d;
			while(temp!=-1)
			{
				v.add(temp);
				temp = previous[temp];
			}
			
			//print the path
			
			for(int i = v.size()-1;i>=0;i--)
			{
				System.out.print(v.get(i)+" ");
			}
			System.out.println();
		}		
	}
	public boolean bfs(int s,int d,int[] prev,int[]dist)
	{
		Queue<Integer> q = new LinkedList();
		boolean[] visited = new boolean[v];
		for(int i = 0;i<v;i++)
		{
			prev[i] = -1;
			dist[i] = Integer.MAX_VALUE;
		}
		
		visited[s] = true;
		dist[s] = 0;
		q.add(s);
		
		while(!q.isEmpty())
		{
			int x = q.poll();
			for(int i : arr[x])
			{
				if(visited[i] == false)
				{
					visited[i] = true;
					dist[i] = dist[x] + 1;
					prev[i] = x;
					q.add(i);
					
					if(i == d)
					 	return true;
				}
			}
		}
		return false;
	}
	public static void main(String[] args)
	{
		Graph obj = new Graph();
		obj.createLink();
		obj.printShortestPath();
	}
}
