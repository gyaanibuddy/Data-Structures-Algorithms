import java.util.*;
class Lcs
{
	int[][] cache;
	char[] arr1, arr2;
	int n,m;
	public Lcs()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter First String");
		arr1 = sc.nextLine().toCharArray();
		System.out.println("Enter Second String");
		arr2 = sc.nextLine().toCharArray();
		n = arr1.length;
		m = arr2.length;
		cache = new int[n+1][m+1];
		for(int[] arr:cache)
			Arrays.fill(arr,0);		
	}
	public int count()
	{
		for(int i = 1;i<n+1;i++)
		{
			for(int j = 1;j<m+1;j++)
			{
				if(arr1[i-1] == arr2[j-1])
				{
					cache[i][j] = 1 + cache[i-1][j-1];	
				}
				else
				{
					cache[i][j] = Math.max(cache[i-1][j],cache[i][j-1]);
				}
			}
		}
		return cache[n][m];
	}
	public static void main(String[] args)
	{
		Lcs obj = new Lcs();
		System.out.println("Longest common subsequence size = "+ obj.count());
	}
}
