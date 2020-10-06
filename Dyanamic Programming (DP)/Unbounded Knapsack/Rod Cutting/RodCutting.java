import java.util.*;
class RodCutting
{
	int[] length,price;
	int n;
	public RodCutting()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter length of rod");
		n = sc.nextInt();
		System.out.println("Enter number of parts");
		int p = sc.nextInt();
		length = new int[p];
		price = new int[p];
		for(int i = 0;i<p;i++)
		{
			System.out.println("Enter length of part");
			length[i] = sc.nextInt();
			System.out.println("Enter price");
			price[i] = sc.nextInt();
		}
	}
	public int findMaxProfit()
	{
		int p = price.length;
		int[][] cache = new int[p+1][n+1];
		for(int i = 1;i<p+1;i++)
		{
			for(int j = 1;j<n+1;j++)
			{
				if(length[i-1]<=j)
				{
					cache[i][j] = Math.max(
							price[i-1]+cache[i][j-length[i-1]],
							cache[i-1][j]);
				}
				else
				{
					cache[i][j] = cache[i-1][j];
				}
			}
		}
		return cache[p][n];
	}
	public static void main(String[] args)
	{
		RodCutting obj = new RodCutting();
		System.out.println("Maximum obtainable value = "+obj.findMaxProfit());
	}
}
