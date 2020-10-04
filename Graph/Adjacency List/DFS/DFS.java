import java.util.*;
class DFS
{
	LinkedList<Integer> arr[];
	int v,e;
	public DFS()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of vertices");
		v = sc.nextInt();
		System.out.println("Enter number of Edges");
		e = sc.nextInt();
		arr = new LinkedList[v];
		for(int i = 0;i<v;i++)
		{
			arr[i] = new LinkedList<Integer>();
		}
	}
	public void addEdge()
	{
		Scanner sc = new Scanner(System.in);
		for(int i = 0;i<e;i++)
		{
			System.out.println("Enter Edge between");
			int u = sc.nextInt();
			int v = sc.nextInt();
			arr[u].add(v);
		}
	}
	public void dfs()
	{
		boolean[] visited = new boolean[v]; 
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter starting vertex");
		int x = sc.nextInt();
		dfs(x,visited);
		System.out.println();
	}
	public void dfs(int x,boolean[] visited)
	{
		visited[x] = true;
		System.out.print(x+" ");
		for(int i : arr[x])
		{
			if(visited[i]!=true)
				dfs(i,visited);
		}
	}
	public void dfsDisconnected()
	{
		boolean[] visited = new boolean[v]; 	
		
		for(int i = 0;i<v;i++)
		{
			if(visited[i]!=true)
				dfs(i,visited);
		}	
		System.out.println();
	}
	public static void main(String[] args)
	{
		DFS obj = new DFS();
		obj.addEdge();
		obj.dfs();
		obj.dfsDisconnected();
	}
}
