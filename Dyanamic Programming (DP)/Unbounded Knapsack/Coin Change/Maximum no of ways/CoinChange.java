import java.util.*;
class CoinChange
{
	int[] coin;
	int n,sum;
	public CoinChange()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of coins");
		n = sc.nextInt();
		coin = new int[n];
		System.out.println("Enter coins");
		for(int i = 0;i<n;i++)
		{
			coin[i] = sc.nextInt();
		}
		System.out.println("Enter sum");
		sum = sc.nextInt();
	}
	public int findWays()
	{
		int[][] cache = new int[n+1][sum+1];
		for(int i = 0;i<sum+1;i++)
		{
			cache[0][i] = 0;
		}
		for(int i = 0;i<n+1;i++)
		{
			cache[i][0] = 1;
		}
		for(int i = 1;i<n+1;i++)
		{
			for(int j = 1;j<sum+1;j++)
			{
				if(coin[i-1]<=j)
				{
					cache[i][j] = cache[i][j-coin[i-1]] + cache[i-1][j];
				}
				else
				{
					cache[i][j] = cache[i-1][j];
				}
			}
		}
		return cache[n][sum];
	}
	public static void main(String[] args)
	{
		CoinChange obj = new CoinChange();
		System.out.println("Maximum number of ways = "+obj.findWays());
	}
}
