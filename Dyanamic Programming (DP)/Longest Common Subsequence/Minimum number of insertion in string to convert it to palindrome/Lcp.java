import java.util.*;
class Lcp
{
	char[] arr1;
	int n;
	int[][] cache;
	public Lcp()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter First String");
		arr1 = sc.nextLine().toCharArray();
		n = arr1.length;
		cache = new int[n+1][n+1];
	}
	public void find()
	{
		StringBuilder sb = new StringBuilder(new String(arr1));
		char[] arr2 = new String(sb.reverse()).toCharArray();
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
		int noOfins = n - cache[n][n];
		System.out.println("Number of insertion = "+noOfins);
	}
	public static void main(String[] args)
	{
		Lcp obj = new Lcp();
		obj.find();
	}
}
