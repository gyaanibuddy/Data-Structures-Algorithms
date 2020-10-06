import java.util.*;
class Lis
{
	int[] arr;
	int n;
	public Lis()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of elements in array");
		n = sc.nextInt();
		arr = new int[n];
		System.out.println("Enter Elements");
		for(int i = 0;i<n;i++)
		{
			arr[i] = sc.nextInt();
		}
	}
	public void find()
	{
		int[] lis = new int[n];
		Arrays.fill(lis,1);
		for(int i = 1;i<n;i++)
		{
			for(int j = 0;j<i;j++)
			{
				if((arr[j]<arr[i])&&(lis[i]<(lis[j]+1)))
				{
					lis[i] = lis[j] + 1;
				}
			}
		}
		Arrays.sort(lis);
		System.out.println("longest increasing subsequence length  = "+lis[n-1]);
	}
	public static void main(String[] args)	
	{
		Lis obj = new Lis();
		obj.find();
	}
}
