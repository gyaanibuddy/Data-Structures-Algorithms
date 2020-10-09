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
	public void count()
	{
		for(int i = 1;i<n+1;i++)
		{
			for(int j = 1;j<m+1;j++)
			{
				if(arr1[i-1] == arr2[j-1])
				{
					cache[i][j] = 1+ cache[i-1][j-1];	
				}
				else
				{
					cache[i][j] = Math.max(cache[i-1][j],cache[i][j-1]);
				}
			}
		}
		int i = n;
		int j = m;
		String s = "";
		while(i>0&&j>0)
		{
			if(arr1[i-1] == arr2[j-1])
			{
				s = s + arr1[i-1];
				i--;
				j--; 
			}
			else
			{
				if(cache[i][j-1]>cache[i-1][j])
				{
					s = s + arr2[j-1];
					j--;	
				}
				else
				{
					s = s + arr1[i-1];
					i--;
				}
			}
		}
		while(i>0)
		{
			s = s + arr1[i-1];
			i--;
		}
		while(j>0)
		{
			s = s + arr2[j-1];
			j--;
		}
		StringBuilder sb = new StringBuilder(s);
		s = new String(sb.reverse());
		System.out.println(s);
	}
	public static void main(String[] args)
	{
		Scs obj = new Scs();
		obj.count();
	}
}
