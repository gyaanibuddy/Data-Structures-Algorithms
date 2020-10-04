import java.util.*;
class Priority
{
	PriorityQueue<Integer> pq1,pq2;
	public Priority()
	{
		pq1 = new PriorityQueue<Integer>(Collections.reverseOrder());
		pq2 = new PriorityQueue<Integer>();		
	}
	public void insert()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number");
		int x = sc.nextInt();
		pq1.offer(x);
		pq2.offer(x);
	}
	public void findMax()
	{
		if(pq1.size()!=0)
		{
			int num = pq1.peek();
			System.out.println("Maximum element = "+num);
		}
	}
	public void findMin()
	{
		if(pq2.size()!=0)
		{
			int num = pq2.peek();
			System.out.println("Minimum element = "+num);
		}
	}
	public void deleteMin()
	{
		if(pq2.size()!=0)
		{
			int num = pq2.poll();
			System.out.println("Deleted element = "+num);
			pq1.remove(num);
		}
	}
	public void deleteMax()
	{
		if(pq1.size()!=0)
		{
			int num = pq1.poll();
			System.out.println("Deleted element = "+num);
			pq2.remove(num);
		}
	}
	public void solve()
	{
		Scanner sc = new Scanner(System.in);
		do
		{
			System.out.println("1.Insert\n2.Find Max\n3.Find Min\n4.Delete Min\n5.Delete Max\n6.Exit");
			int choice = sc.nextInt();
			switch(choice)
			{
				case 1: insert();
					System.out.println(pq1+" "+pq2);
					break;
				case 2: findMax();
					System.out.println(pq1+" "+pq2);
					break;
				case 3: findMin();
					System.out.println(pq1+" "+pq2);
					break;
				case 4: deleteMin();
					System.out.println(pq1+" "+pq2);
					break;
				case 5: deleteMax();
					System.out.println(pq1+" "+pq2);
					break;
				case 6: return;
				default: System.out.println("Invalid Input");
			}
		}while(true);
	}
	public static void main(String[] args)
	{
		Priority obj = new Priority();
		obj.solve();
	}
}
