import java.util.*;
class Lrs
{
	char[] arr1;
	int n;
	int[][] cache;
	public Lrs()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter First String");
		arr1 = sc.nextLine().toCharArray();
		n = arr1.length;
		cache = new int[n+1][n+1];		
	}
	public void count()
	{	
		for(int i = 1;i<n+1;i++)
		{
			for(int j = 1;j<n+1;j++)
			{
				if(arr1[i-1] == arr1[j-1]&&(i!=j))
				{
					cache[i][j] = 1 + cache[i-1][j-1];
				}
				else
				{
					cache[i][j] = Math.max(cache[i-1][j],cache[i][j-1]);
				}
			}
		}
		System.out.println("Longest Repeating Subsequence = "+cache[n][n]);
	}
	public static void main(String[] args)
	{
		Lrs obj = new Lrs();
		obj.count();
	}
}
