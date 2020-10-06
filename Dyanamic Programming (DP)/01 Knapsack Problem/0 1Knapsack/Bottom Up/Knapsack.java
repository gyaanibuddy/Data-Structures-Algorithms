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
			System.out.println("Enter weight");
			wt[i] = sc.nextInt();
			System.out.println("Enter value");
			val[i] = sc.nextInt();
		}
		System.out.println("Enter maximum weight of bag");
		w = sc.nextInt();
		cache = new int[n+1][w+1];
	}
	public int maxProfit()
	{
		for(int[] arr:cache)
		{
			Arrays.fill(arr,-1);
		}
		return maxProfit(w,wt.length);
	}
	public int maxProfit(int w,int n)
	{
		if(n == 0||w == 0) return 0;

		if(cache[n][w]!=-1)
		{
			return cache[n][w];
		}

		if(wt[n-1]>w) 
		{
			return cache[n][w] = maxProfit(w,n-1);
		}

		return cache[n][w] = Math.max(val[n-1]+maxProfit(w-wt[n-1],n-1),maxProfit(w,n-1));
	}
	public static void main(String[] args)
	{
		Knapsack obj = new Knapsack();
		System.out.println("Maximum Profit = "+ obj.maxProfit());
	}
}
