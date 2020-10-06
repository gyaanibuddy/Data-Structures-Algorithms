import java.util.*;
class Lcs
{
	String s1,s2;
	int n, m;
	int[][] cache;
	public Lcs()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter first String");
		s1 = sc.nextLine();
		System.out.println("Enter second String");
		s2 = sc.nextLine();
		n = s1.length();
		m = s2.length();
		cache = new int[n+1][m+1];		
	}
	public int findCount()
	{
		char[] arr1 = s1.toCharArray();
		char[] arr2 = s2.toCharArray();
		for(int[] arr:cache)
		{
			Arrays.fill(arr,-1);
		}
		return findCount(arr1,arr2,n,m);
	}
	public int findCount(char[] arr1,char[] arr2,int n,int m)
	{
		if(n == 0||m == 0)
		{
			return 0;
		}
		if(cache[n][m]!= -1)
		{
			return cache[n][m];
		}
		
		if(arr1[n-1] == arr2[m-1])
		{
			return cache[n][m] = 1 + findCount(arr1,arr2,n-1,m-1);
		}
		else
		{
			return cache[n][m] = Math.max(findCount(arr1,arr2,n-1,m),findCount(arr1,arr2,n,m-1));
		}
		
	}
	public static void main(String[] args)
	{
		Lcs obj = new Lcs();
		System.out.println("Size of Longest Common Subsequence = "+obj.findCount());
	}
}
