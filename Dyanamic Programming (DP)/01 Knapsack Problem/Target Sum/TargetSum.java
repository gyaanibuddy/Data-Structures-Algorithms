import java.util.*;
class TargetSum
{
	int[] arr;
	int n,sum;
	public TargetSum()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of elements in array");
		n = sc.nextInt();
		arr = new int[n];
		System.out.println("Enter number");
		for(int i = 0;i<n;i++)
		{
			arr[i] = sc.nextInt();
		}
		System.out.println("Enter Sum");
		sum = sc.nextInt();
	}
	public int count()
	{
		int sumarr = 0;
		for(int sum1:arr)
		{
			sumarr = sumarr + sum1;
		}
		int s1 = (sumarr+sum)/2;
		return countSubset(s1);
	}
	public int countSubset(int s1)
	{
		int[][] cache = new int[n+1][s1+1];
		for(int i = 0;i<s1+1;i++)
		{
			cache[0][i] = 0;
		}
		for(int i = 0;i<n+1;i++)
		{
			cache[i][0] = 1;
		}
		for(int i = 1;i<n+1;i++)
		{
			for(int j = 1;j<s1+1;j++)
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
		return cache[n][s1];

	}
	public static void main(String[] args)
	{
		TargetSum obj = new TargetSum();
		System.out.println("Number of subset = "+obj.count());
	}
}
