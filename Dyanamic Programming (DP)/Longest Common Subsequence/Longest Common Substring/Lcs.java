import java.util.*;
class Lcs
{
	char[] arr1,arr2;
	int n,m;
	int[][] cache;
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
		int result = Integer.MIN_VALUE;
		for(int i = 1;i<n+1;i++)
		{
			for(int j = 1;j<m+1;j++)
			{
				if(arr1[i-1] == arr2[j-1])
				{
					cache[i][j] = 1 + cache[i-1][j-1]; 
					result = Math.max(cache[i][j],result);
				}
				else
				{
					cache[i][j] = 0;
				}
			}
		}
		return result;
	}
	public static void main(String[] args)
	{
		Lcs obj = new Lcs();
		System.out.println("Longest common substring (length)= "+obj.count());
	}
}
