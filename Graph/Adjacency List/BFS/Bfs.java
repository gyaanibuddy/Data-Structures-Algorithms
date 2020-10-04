import java.util.*;
class Bfs
{
	LinkedList<Integer> arr[];
	int v,e;
	public Bfs()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of vertices");
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
		for(int i = 0;i<this.e;i++)
		{
			System.out.println("Enter vertices of edges");
			int u = sc.nextInt();
			int v = sc.nextInt();
			arr[u].add(v);
		}
	}
	public void bfs()
	{
		boolean[] visited = new boolean[v];
		Queue q = new LinkedList();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Starting index");
		int x = sc.nextInt();
		q.add(x);
		
		while(q.size()!=0)
		{
			x = (int)q.poll();
			visited[x] = true;
			System.out.print(x+" ");
			
			for(int i:arr[x])
			{
				if(visited[i]!=true)
					q.add(i);
			}
		}
	}
	public static void main(String[] args)
	{
		Bfs obj = new Bfs();
		obj.createLink();
		obj.bfs();
	}
}
