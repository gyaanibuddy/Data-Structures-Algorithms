import java.util.Scanner;
class Node
{
	int data,child;
	int rbit,lbit;
	Node left,right;
	public Node(int x)
	{
		data = x;
		left = right = null;
	}
}
class Tbt
{
	Node root;
	public Tbt()
	{
		root = new Node(-1);
		root.left = root.right = root;
		root.rbit = root.lbit = 0;
	}
	public void create()
	{
		create(root,0);
	}
	public void create(Node father,int child)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter data or -1 for exit");
		int data = sc.nextInt();
		if(data == -1)
			return;
		
		Node t = null;
		
		if(child == 0)
		{
			t = new Node(data);
			t.left = father.left;
			t.right = father;
			t.lbit = t.rbit = 0;
			t.child = 0;
			father.left = t;
			father.lbit = 1;
		}
		else
		{
			t = new Node(data);
			t.right = father.right;
			t.left = father;
			t.lbit = t.rbit = 0;
			t.child = 1;
			father.right = t;
			father.rbit = 1;
		}
		System.out.println("Enter left child of "+t.data);
		create(t,0);
		System.out.println("Enter right child of "+t.data);
		create(t,1);
	}	
	public void print()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("1. Preorder\n2. Inorder\n3. PreorderNon\n4. InorderNon");
		int x = sc.nextInt();
		switch(x)
		{
			case 1: preorder();
				break;
			case 2: inorder();
				break;
			case 3: preorderNon();
				break;
			case 4: inorderNon();
				break;
			default: System.out.println("Invalid input");
		}
	}
	public void preorderNon()
	{
		Node t = null;
		System.out.print("Non recursive Preorder = ");
		t = root.left;
		while(t!=root)
		{
			System.out.print(t.data+" ");
			t = preorder_succ(t);
		}
		System.out.println();
	}
	public Node preorder_succ(Node p)
	{
		if(p.lbit == 1)
			return p.left;
		while(p.rbit == 0&&p.right!=root)
		{
			p = p.right;
		} 
		return p.right;
	}
	public void inorderNon()
	{
		Node p = root.left;
		System.out.print("Non recursive Inorder = ");
		while(p.lbit == 1)
		{
			p = p.left;
		}
		while(p!=root)
		{
			System.out.print(p.data+" ");
			p = inorder_succ(p);
		}
		System.out.println();
	}
	public Node inorder_succ(Node p)
	{
		if(p.rbit == 0) return p.right;
		
		p = p.right;
		
		while(p.lbit == 1)
		{
			p = p.left;
		}
		return p;
	}
	public void inorder()
	{
		System.out.print("The inorder of tree = ");
		inorder(root.left);
		System.out.println();
	}
	public void inorder(Node p)
	{
		if(p!= null)
		{
			if(p.lbit == 1)
				inorder(p.left);
				
			System.out.print(p.data+" ");
			
			if(p.rbit == 1)
				inorder(p.right);
		}
	}
	public void preorder()
	{
		System.out.print("The preorder of tree = ");
		preorder(root.left);
		System.out.println();
	}
	public void preorder(Node p)
	{
		if(p!= null)
		{
			System.out.print(p.data+" ");
			
			if(p.lbit == 1)
				inorder(p.left);			
			if(p.rbit == 1)
				inorder(p.right);
		}
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		Tbt obj = new Tbt();
		int choice = 0;
		do
		{
			System.out.println("1.create\n2.print\n3.Exit");
			choice = sc.nextInt();
			switch(choice)
			{
				case 1: obj.create();
					break;
				case 2: obj.print();
					break;
				case 3: return;
			}
		}while(true);
	}
}
