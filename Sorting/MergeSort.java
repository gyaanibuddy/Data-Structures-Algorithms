public class MergeSort
{
	public static void main(String[] args) {
		
		int [] arr = {20,35,-15,7,55,1,-22};
		mergeSort(arr, 0, arr.length);


		System.out.println("Sorted Array is :");
		for(int a : arr)
			System.out.print(a + " ");
		System.out.println();

	}

	public static void mergeSort(int [] arr , int start, int end)
	{

		if(end - start < 2)
			return;

		int mid = (start + end) / 2;
		mergeSort(arr, start, mid);
		mergeSort(arr, mid, end);

		merge(arr, start, mid, end);

	}


	public static void merge(int [] arr , int start, int mid , int end)
	{

		if(arr[mid - 1] <= arr[mid])
			return;

		int [] tmp = new int[end - start];
		int tmp_index = 0;

		int i = start;
		int j = mid;

		while(i < mid || j < end)
		{
			if(i < mid && j < end)
			{
				tmp[tmp_index++] = arr[i] > arr[j] ? arr[j++] : arr[i++];
			}

			else if(i < mid)
				tmp[tmp_index++] = arr[i++];

			else
				tmp[tmp_index++] = arr[j++];	 
		}

		for(int t = start,count = 0 ; t < end ; t++)
			arr[t] = tmp[count++];

	}

}