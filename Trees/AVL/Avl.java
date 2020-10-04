import java.util.*;
class Node
{
	int data;
	Node left;
	Node right;
	public Node(int x)
	{
		data = x;
		left = right = null;
	}
}
public class Avl
{
	Node root;
	public Avl()
	{
		root = null;
	}
	public int balanceFactori(Node t)
	{
		int hl = 0,hr = 0;
		if(t==null) 
		{
			return 0;
		}
		if(t.left!=null)
		{
			hl = 1 + height(t.left);
		}
		if(t.right!=null)
		{
			hr = 1 + height(t.right);
		}
		if(hl>hr)
			return hl - hr;
		else
			return (-1) * (hl-hr);
	}
	public int balanceFactord(Node t)
	{
		int hl = 0,hr = 0;
		if(t==null) 
		{
			return 0;
		}
		if(t.left!=null)
		{
			hl = 1 + height(t.left);
		}
		if(t.right!=null)
		{
			hr = 1 + height(t.right);
		}
		return hl - hr;
	}
	public int height(Node t)
	{
		int hl = 0,hr = 0;
		if(t==null)
		{
			return 0;
		}
		if(t.left == null &&t.right == null)
		{
			return 0;
		}
		if(t.left!=null)
		{
			hl = 1 + height(t.left);
		}
		if(t.right!=null)
		{
			hr = 1 + height(t.right); 
		}
		if(hl>hr)
			return hl;
		else
			return hr;
	}
	public Node ll(Node t)
	{
		Node y = t.left;
		t.left = y.right;
		y.right = t;
		return y;
	}
	public Node rr(Node t)
	{
		Node y = t.right;
		t.right = y.left;
		y.left = t;
		return y;
	}
	public Node lr(Node t)
	{
		Node y = t.left;
		Node p = y.right;
		y.right = p.left;
		p.left = y;
		t.left = p;
		t = ll(t);
		return t;
	}
	public Node rl(Node t)
	{
		Node y = t.right;
		Node p = y.left;
		y.left = p.right;
		p.right = y;
		t.right = p;
		t = rr(t);
		return t;
	}
	public void insert()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter data");
		int x = sc.nextInt();
		root = insert(root,x);
	}
	public Node insert(Node t,int x)
	{
		if(t == null)
		{
			return new Node(x);
		}
		if(x<t.data)
		{
			t.left = insert(t.left,x);
			if(balanceFactori(t) == 2)
			{
				if(x<t.left.data)
				{
					t = ll(t);
				}
				else
				{
					t = lr(t);
				}	
			}
		}
		if(x>t.data)
		{
			t.right = insert(t.right,x);
			if(balanceFactori(t) == 2)
			{
				if(x>t.data)
				{
					t = rr(t);
				}
				else
				{
					t = rl(t);
				}
			}
		}
		return t;
	}
	public void print()
	{
		inorder(root);	
		System.out.println();
	}
	public void inorder(Node t)
	{
		if(t!=null)
		{
			inorder(t.left);
			System.out.print(t.data+" ");
			inorder(t.right);
		}
	}
	public void delete()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter data");
		int x = sc.nextInt();
		root = delete(root,x);
	}
	public Node delete(Node t,int x)
	{
		if(t == null)
		{
			return null;
		}
		else if(x<t.data)
		{
			t.left = delete(t.left,x);
			if(balanceFactord(t) == -2)
			{
				if(balanceFactord(t.right)<=0)
				{
					t = rr(t);
				}
				else
				{
					t = rl(t);
				}
			}
		}
		else if(x>t.data)
		{
			t.right = delete(t.right,x);
			if(balanceFactord(t) == 2)
			{
				if(balanceFactord(t.left)>=0)
				{
					t = ll(t);
				}
				else
				{
					t = lr(t);
				}
			}
		}
		else if(t.data == x)
		{
			Node p = null;
			if(t.left == null && t.right == null)
			{
				t = null;
				return null;
			}
			else if(t.left != null && t.right == null)
			{
				p = t.left;
				t = null;
				return p;
			}
			else if(t.left == null && t.right != null)
			{
				p = t.right;
				t = null;
				return p;
			}
			else
			{
				p = t.right;
				while(p.left!=null)
				{
					p = p.left;
				}
				t.data = p.data;
				t.right = delete(t.right,p.data);
				if(balanceFactord(t) == 2)
				{
					if(balanceFactord(t.left)>=0)
					{
						t = ll(t);
					}
					else
					{
						t = lr(t);
					}
				}
			}
		}
		return t;
	}
	public void search()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter data");
		int x = sc.nextInt();
		if(search(root,x) == null)
		{
			System.out.println("Number Not Found");
		}
		else
		{
			System.out.println("Number Found");
		}
	}
	public Node search(Node t,int x)
	{
		if(t == null)
		{
			return null;
		}
		else
		{
			if(t.data == x)
			{
				return t;
			}
			else if(x<t.data)
			{
				return search(t.left,x);
			}
			else if(x>t.data)
			{
				return search(t.right,x);
			}
		}
		return t;
	}
	public static void main(String[] args)
	{
		Avl obj = new Avl();
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		do
		{
			System.out.println("1.Insert\n2.Print\n3.Delete\n4.Search\n5.Exit");
			choice = sc.nextInt();
			switch(choice)
			{
				case 1: obj.insert();
					break;
				case 2: obj.print();
					break;
				case 3: obj.delete();
					break;
				case 4: obj.search();
					break;
				case 5: return;
				default: System.out.println("Invalid choice");
			}
		}while(true);
	}
}
