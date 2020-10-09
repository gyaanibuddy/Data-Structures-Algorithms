import java.util.*;
class CountSum
{
	int[] arr;
	int sum;
	int[][] cache;
	public CountSum()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of elements");
		int n = sc.nextInt();
		System.out.println("Enter numbers");
		arr = new int[n];
		for(int i = 0;i<n;i++)
		{
			arr[i] = sc.nextInt();
		}
		System.out.println("Enter sum");
		sum = sc.nextInt();
		cache = new int[n+1][sum+1];
	}
	public int countSum()
	{
		int n = arr.length;
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
				if(arr[i-1]<= j)
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
		CountSum obj = new CountSum();
		System.out.println("Number of subsets = "+ obj.countSum());
	}
}
