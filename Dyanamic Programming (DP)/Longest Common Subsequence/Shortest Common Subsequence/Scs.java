import java.util.*;
class Scs
{
	char[] arr1,arr2;
	int n,m;
	int[][] cache;
	public Scs()
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
		int shortcomsub = m + n - cache[n][m];
		return shortcomsub;
	}
	public static void main(String[] args)
	{
		Scs obj = new Scs();
		System.out.println("Shortest common subsequence length = "+obj.count());
	}
}
