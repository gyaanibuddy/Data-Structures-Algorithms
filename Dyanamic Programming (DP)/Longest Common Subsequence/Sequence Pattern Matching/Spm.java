import java.util.*;
class Spm
{
	char[] arr1,arr2;
	int n,m;
	int[][] cache;
	public Spm()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter First string");
		arr1 = sc.nextLine().toCharArray();
		System.out.println("Enter Second string");
		arr2 = sc.nextLine().toCharArray();
		n = arr1.length;
		m = arr2.length;
		cache = new int[n+1][m+1];
	}
	public boolean find()
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
		if(cache[n][m] == arr1.length)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public static void main(String[] args)
	{
		Spm obj = new Spm();
		if(obj.find())
		{
			System.out.println("Sequence pattern match");
		}
		else
		{
			System.out.println("Sequence pattern not matches");
		}
	}
}
