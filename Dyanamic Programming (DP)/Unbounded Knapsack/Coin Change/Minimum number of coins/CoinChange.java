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
	public int findCoins()
	{
		int[][] cache = new int[n+1][sum+1];
		for(int i = 0;i<sum+1;i++)
		{
			cache[0][i] = Integer.MAX_VALUE - 1; 
		}
		for(int i = 0;i<n+1;i++)
		{
			cache[i][0] = 0;
		}
		for(int i = 1;i<sum+1;i++)
		{
			if(i%coin[0]==0)
			{
				cache[1][i] = i/coin[0]; 
			}
			else
			{
				cache[1][i] = Integer.MAX_VALUE - 1;
			}
		}
		for(int i = 2;i<n+1;i++)
		{
			for(int j = 1;j<sum+1;j++)
			{
				if(coin[i-1]<=j)
				{
					cache[i][j] = Math.min(1+cache[i][j-coin[i-1]],
							cache[i-1][j]);
								
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
		System.out.println("Minimum number of coins = "+obj.findCoins());	
	}
}
