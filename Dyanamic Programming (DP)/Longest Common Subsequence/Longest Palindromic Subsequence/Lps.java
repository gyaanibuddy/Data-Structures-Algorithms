import java.util.*;
class Lps
{
	char[] arr1;
	int n;
	int[][] cache;
	public Lps()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter First String");
		arr1 = sc.nextLine().toCharArray();
		n = arr1.length;
		cache = new int[n+1][n+1];
	}
	public int count()
	{
		String temp = new String(arr1);
		StringBuilder sb = new StringBuilder(temp);
		String s2 = new String(sb.reverse());
		char[] arr2 = s2.toCharArray();
		for(int i = 1;i<n+1;i++)
		{
			for(int j = 1;j<n+1;j++)
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
		return cache[n][n];
	}
	public static void main(String[] args)
	{
		Lps obj = new Lps();
		System.out.println("Longest common palindromic length = "+obj.count());
	}
}
