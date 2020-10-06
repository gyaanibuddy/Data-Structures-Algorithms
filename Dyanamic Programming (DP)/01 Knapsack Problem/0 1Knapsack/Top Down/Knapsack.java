import java.util.*;
class Knapsack
{
	int[] wt;
	int[] val;
	int[][] cache;
	int w;
	public Knapsack()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of items");
		int n = sc.nextInt();
		wt = new int[n];
		val = new int[n];
		for(int i = 0;i<n;i++)
		{
			System.out.println("Enter Weight");
			wt[i] = sc.nextInt();
			System.out.println("Enter value");
			val[i] = sc.nextInt();
		}
		System.out.println("Enter maximum weight");
		w = sc.nextInt();
		cache = new int[n+1][w+1];
	}
	public int findMax()
	{
		int n = wt.length;
		for(int i = 0;i<n+1;i++)
		{
			for(int j = 0;j<w+1;j++)
			{
				if(i == 0 || j == 0)
				{
					cache[i][j] = 0;
				}
				else if(wt[i-1]<=j)
				{
					cache[i][j] = 
					Math.max(val[i-1]+cache[i-1][j-wt[i-1]],cache[i-1][j]);
				}
				else
				{
					cache[i][j] = cache[i-1][j];
				}
			}
		}
		return cache[n][w]; 
	}
	public static void main(String[] args)
	{
		Knapsack obj = new Knapsack();
		System.out.println("Maximum profit = "+ obj.findMax());
	}
}
