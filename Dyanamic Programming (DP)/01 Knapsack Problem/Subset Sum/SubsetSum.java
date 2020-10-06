import java.util.*;
class SubsetSum
{
	int[] arr;
	int sum;
	boolean[][] cache;
	public SubsetSum()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of numbers in array");
		int n = sc.nextInt();
		arr = new int[n];
		System.out.println("Enter numbers");
		for(int i = 0;i<n;i++)
		{
			arr[i] = sc.nextInt();
		}
		System.out.println("Enter sum");
		sum = sc.nextInt();
		cache = new boolean[n+1][sum+1];
	}
	public boolean findSubset()
	{
		int n = arr.length;
		for(int i = 0;i<n+1;i++)
		{
			for(int j = 0;j<sum+1;j++)
			{
				if(i == 0)
					cache[i][j] = false;
				else if(j == 0)
					cache[i][j] = true;
				else if(arr[i-1]<=j)
				{
					cache[i][j] = cache[i-1][j-arr[i-1]] || cache[i-1][j];
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
		SubsetSum obj = new SubsetSum();
		if(obj.findSubset())
		{
			System.out.println("Subset is present");
		}
		else
		{
			System.out.println("Subset is not present");
		}
	}
}
