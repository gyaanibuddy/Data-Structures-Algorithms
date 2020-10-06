import java.util.*;
class Mid
{
	char[] arr1,arr2;
	int n,m;
	int[][] cache;
	public Mid()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter First String");
		arr1 = sc.nextLine().toCharArray();
		System.out.println("Enter Second String");
		arr2 = sc.nextLine().toCharArray();
		n = arr1.length;
		m = arr2.length;
		cache = new int[n+1][m+1];
	}
	public void count()
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
		int del = n - cache[n][m];
		int ins = m - cache[n][m];
		System.out.println("Number of insertion = "+ins);
		System.out.println("Number of deletion = "+del);
	}
	public static void main(String[] args)
	{
		Mid obj = new Mid();
		obj.count();
	}
}
