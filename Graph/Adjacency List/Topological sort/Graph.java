import java.util.*;
class Graph
{
	LinkedList<Integer> arr[];
	int v,e;
	public Graph()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of vertices");
		v = sc.nextInt();
		System.out.println("Enter number of Edges");
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
			System.out.println("Enter edge");
			int u = sc.nextInt();
			int v = sc.nextInt();
			arr[u].add(v);
		}
	}
	public void topology(int x,boolean[] visited,Stack<Integer> s)
	{
		visited[x] = true;
		for(int i:arr[x])
		{
			if(visited[i]!=true)
				topology(i,visited,s);
		}
		s.push(x);
	}
	public void topologySort()
	{
		Stack<Integer> s = new Stack<Integer>();
		boolean[] visited = new boolean[v];
		for(int i = 0;i<v;i++)
		{
			if(visited[i]!=true)
				topology(i,visited,s);
		}
		while(!s.empty())
		{
			System.out.print(s.pop()+" ");
		}
		System.out.println();
	}
	public static void main(String[] args)
	{
		Graph obj = new Graph();
		obj.createLink();
		obj.topologySort();
	}
}
