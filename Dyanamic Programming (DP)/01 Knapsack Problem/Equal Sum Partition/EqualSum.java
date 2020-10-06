import java.util.*;
class EqualSum
{
	int[] arr;
	public EqualSum()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of elements in array");
		int n = sc.nextInt();
		arr = new int[n];
		System.out.println("Enter numbers");
		for(int i = 0;i<n;i++)
		{
			arr[i] = sc.nextInt();
		} 
	}
	public boolean equalPart()
	{
		int sum = 0;
		int n = arr.length;
		for(int i = 0;i<n;i++)
		{
			sum = sum + arr[i];
		}
		if(sum%2!=0)
			return false;
		else
			return	subsetSum(sum/2);
	}
	public boolean subsetSum(int sum)
	{
		int n = arr.length;
		boolean[][] cache = new boolean[n+1][sum+1];
		for(int i = 0;i<n+1;i++)
		{
			for(int j = 0;j<sum+1;j++)
			{
				if(i==0) cache[i][j] = false;
				else if(j==0) cache[i][j] = true;
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
		EqualSum obj = new EqualSum();
		if(obj.equalPart())
		{
			System.out.println("Equal partition possible");
		}
		else
		{
			System.out.println("Equal partition not possible");
		}
	}
}
