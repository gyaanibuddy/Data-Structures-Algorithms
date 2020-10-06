import java.util.*;
class CountSubsetForGivDiff
{
	int[] arr;
	int n,diff;
	public CountSubsetForGivDiff()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of elements");
		n = sc.nextInt();
		arr = new int[n];
		System.out.println("Enter Numbers");
		for(int i = 0;i<n;i++)
		{
			arr[i] = sc.nextInt();
		}
		System.out.println("Enter Difference");
		diff = sc.nextInt();
	}
	public int count()
	{
		int sum = 0;
		for(int x:arr)
		{
			sum = sum + x;
		}
		int s1 = (sum+diff)/2;
		return countSubset(s1);	
	}
	public int countSubset(int sum)
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
				if(arr[i-1]<=j)
				{
					cache[i][j] = cache[i-1][j-arr[i-1]] + cache[i-1][j]; 
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
		CountSubsetForGivDiff obj = new CountSubsetForGivDiff();
		System.out.println("Number of subset = "+obj.count());
	}
}
