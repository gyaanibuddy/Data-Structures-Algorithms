import java.util.*;
class Unbounded
{
	int[] wt,val;
	int n,w;
	public Unbounded()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of elements");
		n = sc.nextInt();
		wt = new int[n];
		val = new int[n];
		for(int i = 0;i<n;i++)
		{
			System.out.println("Enter weight");
			wt[i] = sc.nextInt();
			System.out.println("Enter value");
			val[i] = sc.nextInt();
		}
		System.out.println("Enter Maximum Weight");
		w = sc.nextInt();
	}
	public int findProfit()
	{
		int[][] cache = new int[n+1][w+1];
		for(int i = 1;i<n+1;i++)
		{
			for(int j = 1;j<w+1;j++)
			{
				if(wt[i-1]<=j)
				{
					cache[i][j] = Math.max(
							val[i-1]+cache[i][j-wt[i-1]],
							cache[i-1][j]);
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
		Unbounded obj = new Unbounded();
		System.out.println("Maximum profit = "+obj.findProfit());
	}
}
