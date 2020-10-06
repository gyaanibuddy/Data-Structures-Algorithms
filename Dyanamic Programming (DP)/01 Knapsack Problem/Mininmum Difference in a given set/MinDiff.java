import java.util.*;
class MinDiff
{
	int[] arr;
	int n;
	boolean[][] cache;
	public MinDiff()
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
	}  
	public int findMinDiff()
	{
		int sum = 0;
		for(int i = 0;i<n;i++)
		{
			sum = sum +arr[i];
		}
		cache = new boolean[n+1][sum+1];
		int min = subsetSum(sum);
		return min;
	}
	public int subsetSum(int sum)
	{
		for(int i= 0;i<sum+1;i++)
		{
			cache[0][i] = false;
		}
		for(int i= 0;i<n+1;i++)
		{
			cache[i][0] = true;
		}
		for(int i = 1;i<n+1;i++)
		{
			for(int j = 1;j<sum+1;j++)
			{
				if(arr[i-1]<=j)
				{
					cache[i][j] = cache[i-1][j-arr[i-1]] || cache[i-1][j];
				}
				else
				{
					cache[i][j] = cache[i-1][j];
				}
			}
		}
		Vector v = new Vector();
		for(int i = 0;i<= (sum/2);i++)
		{
			if(cache[n][i])
			{
				v.add(i);
			}
		}
		int min = Integer.MAX_VALUE;
		for(int i = 0;i<v.size();i++)
		{
			min = Math.min(min,(sum-2*(int)v.get(i)));
		}
		return min;
	}
	public static void main(String[] args)
	{
		MinDiff obj = new MinDiff();
		System.out.println("Minimum difference = "+obj.findMinDiff());
	}
}
