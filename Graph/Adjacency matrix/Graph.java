import java.util.*;
class Graph
{
	int v,e;
	int[][] mat;
	public Graph()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of Vertices");
		v = sc.nextInt();
		System.out.println("Enter number of Edges");
		e = sc.nextInt();
		mat = new int[v][v];
	}
	public void createLink()
	{
		Scanner sc = new Scanner(System.in);
		for(int i = 0;i<e;i++)
		{
			System.out.println("Enter the link");
			int u = sc.nextInt();
			int v = sc.nextInt();
			mat[u-1][v-1] = 1;
		}
	}
	public void print()
	{
		for(int i = 0;i<v;i++)
		{
			for(int j = 0;j<v;j++)
			{
				System.out.print(mat[i][j]+" ");
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
