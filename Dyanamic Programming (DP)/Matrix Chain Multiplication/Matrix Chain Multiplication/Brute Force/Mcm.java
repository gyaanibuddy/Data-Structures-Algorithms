import java.util.*;
class Mcm
{
	public static int solve(int[] arr,int i,int j)
	{
		if(i>=j)
		{
			return 0;
		}
		int answer = Integer.MAX_VALUE;
		for(int k = i;k<j;k++)
		{
			int tempans = solve(arr,i,k) + solve(arr,k+1,j) + (arr[i-1]*arr[k]*arr[j]);
			if(answer>tempans)
			{
				answer = tempans;
			}
		}
		return answer;
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter length of array");
		int n = sc.nextInt();
		int[] arr = new int[n];
		System.out.println("Enter numbers");
		for(int i = 0;i<n;i++)
		{
			arr[i] = sc.nextInt();
		}
		System.out.println("Minimum cost = " + solve(arr,1,n-1));
	}
}
