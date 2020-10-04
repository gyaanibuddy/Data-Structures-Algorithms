import java.util.Scanner;
class Queue
{
	int arr[];
	int size;
	int rear, front;
	public Queue()
	{
		Scanner sc = new Scanner(System.in);
		rear = front = -1;
		System.out.println("Enter size of array");
		size = sc.nextInt();
		arr = new int[size];
	}
	public boolean isFull()
	{
		if((rear+1)%size == front)
			return true;
		return false;
		
	}
	public boolean isEmpty()
	{
		if(front == -1)
			return true;
		return false;
	}
	public void enqueue(int data)
	{
		if(isFull())
		{
			System.out.println("Queue overflow");
			return;
		}
		else
		{
			rear = (rear + 1)%size;
			arr[rear] = data;
			if(front == -1)
			{
				front = rear;
			}
		}
	}
	public int dequeue()
	{
		if(isEmpty())
		{
			System.out.println("Queue Underflow");
			return Integer.MIN_VALUE;
		}
		else
		{
			int data = arr[front];
			if(front == rear)
			{
				front = rear = -1;
			}
			else
			{
				front = (front+1)%size;
			}
			return data;
		}
	}
	public void print()
	{
		if(!isEmpty())
		{
			int i = 0;
			for(i = front;i!=rear;i = (i+1)%size)
			{
				System.out.println("Number = "+arr[i]+" index = "+i);
			}
			System.out.println("Number = "+arr[i]+" index = "+i);
		}
	}
	public void deleteQueue()
	{
		arr = new int[size];
		front = rear = -1;
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		Queue obj = new Queue();
		int choice;
		do
		{
			System.out.println("1. Enqueue\n2. Dequeue\n3. print\n4. Delete Queue\n5. Exit");
			choice = sc.nextInt();
			switch(choice)
			{
				case 1: System.out.println("Enter Element");
					int data = sc.nextInt();
					obj.enqueue(data);
					break;
				case 2: System.out.println("Dequeue Element = "+obj.dequeue());
					break;
				case 3: obj.print();
					break;
				case 4: obj.deleteQueue();
					break;
				case 5: return;
			}
		}while(true);	

	}
}
