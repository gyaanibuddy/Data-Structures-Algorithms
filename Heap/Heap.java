import java.util.*;
class Heap
{
	int[] arr;
	int n;
	public Heap()
	{
		System.out.println("Enter size of array");
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n];
		System.out.println("Enter Number");
		for(int i = 0;i<n;i++)
		{
			arr[i] = sc.nextInt();
		}
	}
	public void sort()
	{
		//this is used to build max heap
		//because last element parent is present at (n/2)-1
		for(int i = (n/2)-1;i>=0;i--)
		{
			heapify(n,i);
		}
		//this is use for sort
		for(int i = n-1;i>=0;i--)
		{
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			heapify(i,0);
		}
	}
	public void heapify(int size,int i)
	{
		int root = i;//consider root is largest
		int left = 2*i + 1;
		int right = 2*i + 2;
		
		//if left is greater then make root as left
		if(left<size && arr[left]>arr[root])
		{
			root = left;
		}
		//if right is greater then make root as right
		if(right<size && arr[right]>arr[root])
		{
			root = right;
		}
		
		//if the root is changed then swap element at root and i
		if(root!=i)
		{
			int temp = arr[root];
			arr[root] = arr[i];
			arr[i] = temp;
			
			heapify(size,root);	
		}
	}
	public void print() 
	{  
		for (int i=0;i<n;i++) 
		{
		    System.out.print(arr[i]+" ");
		} 
		System.out.println(); 
	} 
	public static void main(String[] args)
	{
		Heap obj = new Heap();
		obj.sort();
		System.out.println("Array in ascending order");
		obj.print();
	}
}
