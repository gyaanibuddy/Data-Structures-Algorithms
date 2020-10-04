import java.util.*;
class Graph
{
	int[][] graph;
	int v,e;
	public Graph()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of vertices");
		v = sc.nextInt();
		System.out.println("Enter number of edges");
		e = sc.nextInt();
		graph = new int[v][v];
	}
	public void createLink()
	{
		Scanner sc = new Scanner(System.in);
		for(int i = 0;i<e;i++)
		{
			System.out.println("Enter link");
			int u = sc.nextInt();
			int v = sc.nextInt();
			System.out.println("Enter cost");
			int c = sc.nextInt();
			graph[u][v] = c;
			graph[v][u] = c;
		}
	}
	int minKey(int key[], boolean mstSet[])
    	{
        	int min = Integer.MAX_VALUE, min_index = -1;
 
        	for (int i = 0; i < v; i++)
        	{
        	    if (mstSet[i] == false && key[i] < min) 
        	    {
        	        min = key[i];
        	        min_index = i;
        	    }
 		}
        	return min_index;
    	 }	
 
	    void printMST(int parent[], int graph[][])
	    {
	        System.out.println("Edge \tWeight");
	        for (int i = 0; i < v; i++)
	        {
	        	if(parent[i]!=-1)
	            	System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
	        }
	    }
 
	 void primMST()
	 {
	        int parent[] = new int[v];
	 
	        int key[] = new int[v];
	 
	        boolean mstSet[] = new boolean[v];

	        for (int i = 0; i < v; i++) 
	        {
	            key[i] = Integer.MAX_VALUE;
	        }
		System.out.println("Enter source");
		Scanner sc = new Scanner(System.in);
		int src = sc.nextInt();
	        key[src] = 0; 
	        
	        parent[src] = -1; 
	        
	        for (int count = 0; count < v - 1; count++) 
	        {
		        int u = minKey(key, mstSet);
	       	mstSet[u] = true;
            		for (int i = 0; i < v; i++)
	                   if (graph[u][i] != 0 && mstSet[i] == false && graph[u][i] < key[i]) 
	                	{
	                    		parent[i] = u;
	                    		key[i] = graph[u][i];
	                	}
		 }
		 
	        printMST(parent, graph);
	 }
	 public static void main(String[] args)
	 {
		Graph obj = new Graph();
		obj.createLink();
		obj.primMST();
	 }
}
