import java.util.*;
class Node
{
	int data;
	Node left;
	Node right;
	public Node(int data)
	{
		this.data = data;
		left = right = null;
	}
}
public class Bst
{
	Node root;
	public Bst()
	{
		root = null;
	}
	public void insert()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter data");
		int data = sc.nextInt();
		root = insert(root,data);
	}
	public Node insert(Node p, int data)
	{
		if(p == null)
			return new Node(data);
		if(data<p.data)
			p.left = insert(p.left,data);
		if(data>=p.data)
			p.right = insert(p.right,data);
		return p;
	}
	public void print()
	{
		System.out.print("Inorder = ");
		inorder(root);
		System.out.println();
	}
	public void inorder(Node p)
	{
		if(p!=null)
		{
			inorder(p.left);
			System.out.print(p.data+" ");
			inorder(p.right);
		}
	}
	public boolean search(int x)
	{
		 return search(root,x);
	}
	public boolean search(Node p, int x)
	{
		if(p == null)  return false;
		
		if(x == p.data) return true;
		
		if(x<p.data) return search(p.left,x);
		
		if(x>p.data) return search(p.right,x);
		
		return false;
	}
	public void deleteFromBst()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter data");
		int x = sc.nextInt();
		if(search(x))
		{
			root = deleteFromBst(root,x);
			System.out.println("Number deleted");
		}
		else
		{
			System.out.println("Number not found");
		}
	}
	public Node deleteFromBst(Node p,int x)
	{
		if(p == null)
		{
			return null;
		}
		if(x<p.data)
		{
			p.left = deleteFromBst(p.left,x);
			return p;
		}
		if(x>p.data)
		{
			p.right = deleteFromBst(p.right,x);
			return p;
		}
		else
		{
			if(p.left==null&&p.right == null)
			{
				return null;
			}
			if(p.left!=null&&p.right == null)
			{
				Node temp = p.left;
				p = null;
				return temp;	
			}
			if(p.right!= null&&p.left==null)
			{
				Node temp = p.right;
				p = null;
				return temp;
			}
			else
			{
				Node temp = p.right;
				while(temp.left!=null)
				{
					temp = temp.left;
				}
				p.data = temp.data;
				p.right = deleteFromBst(p.right,temp.data);
				return p;
			}
		}
	}
	public static void main(String[] args)
	{
		Bst obj = new Bst();
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		do
		{
			System.out.println("1. Insert\n2. print\n3. Delete\n4. Exit");
			choice = sc.nextInt();
			switch(choice)
			{
				case 1: obj.insert();
					break;
				case 2: obj.print();
					break;
				case 3: obj.deleteFromBst();
					break;
				case 4: return;
			}
		}while(true);
	}
}
