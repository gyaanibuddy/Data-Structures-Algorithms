public class ShellSort
{														
	public static void main(String[] args) {
		
		int [] arr = {5,17,-25,11,96,-3};
		int tmp = 0;

		for(int gap = arr.length/2 ; gap > 0 ; gap = gap / 2)
		{
			for(int x = gap; x < arr.length ; x++)
			{
				int y ;
				int newElement = arr[x];

				for(y = x; y-gap >= 0 && arr[y-gap] > newElement ; y = y - gap)
				{
					arr[y] = arr[y-gap];
				}

				arr[y] = newElement;
				
			}
		
		}

		System.out.println("Sorted Array is :");
        for(int i = 0; i < arr.length; i++)
        {
            if(i == arr.length-1)
            {
                System.out.print(arr[i]);
            }
            else
            {
                System.out.print(arr[i] + ", ");
            }
        }
		System.out.println();

	}
}