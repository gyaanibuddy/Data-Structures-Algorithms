import java.util.*;
class Mcm
{
	static int[][] cache;
	public int solve(int[] arr,int i,int j)
	{
		if(i>=j) return 0;
		
		if(cache[i][j]!=-1) return cache[i][j];
		
		int res = Integer.MAX_VALUE;
		for(int k = i;k<j;k++)
		{
			int tempans = solve(arr,i,k) + solve(arr,k+1,j) + arr[i-1]*arr[k]*arr[j];
			 if(res>tempans)
			 {
			 	res = tempans;
			 }
		}
		
		cache[i][j] = res;
		return res;
		
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter length of array");
		int n = sc.nextInt();
		int[] arr = new int[n];
		System.out.println("Enter numbers");
		for(int i = 0;i<n;i++)
		{
			arr[i] = sc.nextInt();
		}
		cache = new int[n+1][n+1];
		for(int[] a:cache)
		{
			Arrays.fill(a,-1);
		}
		Mcm obj = new Mcm();
		System.out.println("Minimum cost = "+obj.solve(arr,1,n-1));
			
	}
}
