import java.util.*;
class Node
{
	int data;
	Node left;
	Node right;
	public Node(int data)
	{
		this.data = data;
		left=right=null;
	}
}
public class BinaryTree
{
	Node root;
	public BinaryTree()
	{
		root = null;
	}
	public void insert()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Element");
		int data = sc.nextInt();
		
		if(root == null)
		{
			root = new Node(data);
			return;
		}
		
		Queue q = new LinkedList();
		q.add(root);
		while(!q.isEmpty())
		{
			Node p = (Node)q.remove();
			if(p.left!=null)
			{
				q.add(p.left);
			}
			else
			{
				p.left = new Node(data);
				q = null;
				return;
			}
			if(p.right!=null)
			{
				q.add(p.right);
			}
			else
			{
				p.right = new Node(data);
				q = null;
				return;
			}
		}
		q=null;
	}
	public void preorder()
	{
		System.out.print("Preoreder with recursion = ");
		preorder(root);
		System.out.println();
	}
	public void inorder()
	{
		System.out.print("Inoreder with recursion = ");
		inorder(root);
		System.out.println();
	}
	public void inorder(Node p)
	{
		if(p!= null)
		{
			inorder(p.left);
			System.out.print(p.data+" ");
			inorder(p.right);
		}
	}
	public void inorderWithoutRecursion()
	{
		Node p = root;
		System.out.print("Inoreder without recursion = ");
		Stack s = new Stack();
		while(true)
		{
			while(p!=null)
			{
				s.push(p);
				p = p.left;
			}
			if(s.empty())
				break;
			p = (Node) s.pop();
			
			System.out.print(p.data+" ");
			p = p.right;
		}
		s = null;
		p = null;
		System.out.println();
	}
	public void preorderWithoutRecursion()
	{
		System.out.print("Preoreder without recursion = ");
		Node p = root;
		Stack s = new Stack();
		while(true)
		{
			while(p!=null)
			{
				System.out.print(p.data+" ");
				s.push(p);
				p = p.left;
			}
			if(s.empty())
				break;
			p = (Node)s.pop();
			p = p.right;
		}
		System.out.println();
		s = null;
		p = null;
	}
	public void preorder(Node p)
	{
		if(p!=null)
		{
			System.out.print(p.data+" ");
			preorder(p.left);
			preorder(p.right);
		}
	}
	public void postorder()
	{
		System.out.print("Postoreder with recursion = ");
		postorder(root);
		System.out.println();
	}
	public void postorder(Node p)
	{
		if(p!=null)
		{
			postorder(p.left);
			postorder(p.right);
			System.out.print(p.data+" ");
		}
	}
	public void postorderWithoutRecursion()
	{
		System.out.print("Postoreder without recursion = ");
		Stack s = new Stack();
		Node p = root;
		Node q = null;
		do
		{
			while(p!=null)
			{
				s.push(p);
				p = p.left;
			}
			while((p==null)&&!(s.empty()))
			{
				p = (Node)s.peek();
				if((p.right == null)||(p.right==q))
				{
					System.out.print(p.data+" ");
					s.pop();
					q = p;
					p = null;
				}
				else
				{
					p = p.right;
				}
			}
		}while(!s.empty());
		System.out.println();
	}
	public void levelOrder()
	{
		System.out.print("Level order = ");
		Node p = null;
		Queue q = new LinkedList();
		if(root == null) return;
		q.add(root);
		
		while(!q.isEmpty())
		{
			p = (Node) q.remove();
			System.out.print(p.data+" ");
			if(p.left!=null) q.add(p.left);
			if(p.right!=null) q.add(p.right);
		}
		q = null;
		System.out.println();
	}
	public void levelOrderInRev()
	{
		Queue q = new LinkedList();
		Node p = root;
		q.add(p);
		Stack s = new Stack();
		System.out.print("Level order in reverse order = ");
		while(!q.isEmpty())
		{
			p = (Node) q.remove();
			if(p.left != null) q.add(p.left);
			if(p.right != null) q.add(p.right);
			s.push(p);
		}
		while(!s.empty())
		{
			p = (Node)s.pop();
			System.out.print(p.data+" ");
		}
		System.out.println();
	}
	public void print()
	{
		Scanner sc = new Scanner(System.in); 
		System.out.println("1.Preorder\n2.Inorder\n3.PostOrder\n4.Level order\n5.Level order in reverse order");
		int choice = sc.nextInt();
		switch(choice)
		{
			case 1: preorder();
				preorderWithoutRecursion();
				break;
			case 2: inorder();
				inorderWithoutRecursion();
				break;
			case 3: postorder();
				postorderWithoutRecursion();
				break;
			case 4: levelOrder();
				break;
			case 5: levelOrderInRev();
				break;
			default: System.out.println("Invalid choice");
		}
	}
	public void findMax()
	{
		System.out.println("Maximum Number in Tree = "+findMax(root));
		System.out.println("Maximum Number in Tree using level order = "+findMaxUsingLevelOrder());
	}
	public int findMax(Node p)
	{
		int max = 0;
		int root_data = 0,left = 0,right = 0;
		if(p!=null)
		{
			root_data = p.data;
			left = findMax(p.left);
			right = findMax(p.right);
		}
		
		if(left>right)
			max = left;
		else
			max = right;
		
		if(root_data>max) max = root_data;
		
		return max;
	}
	public int findMaxUsingLevelOrder()
	{
		Node p = null;
		int max = Integer.MIN_VALUE;
		Queue q = new LinkedList();
		q.add(root);
		while(!q.isEmpty())
		{
			p =(Node) q.remove();
			if(max < p.data)
			{
				max = p.data;
			}
			if(p.left!=null)
			{
				q.add(p.left);
			}
			if(p.right!=null)
			{
				q.add(p.right);
			}
		}
		q = null;
		return max;
	}
	public void search()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number");
		int inp = sc.nextInt();
		System.out.print("With recursion = ");
		if(search(root,inp))
		{
			System.out.println("Number found");
		}
		else
		{
			System.out.println("Number not found");
		}
		System.out.print("Without recursion = ");
		if(search(inp))
		{
			System.out.println("Number found");
		}
		else
		{
			System.out.println("Number not found");
		}

	}
	public boolean search(int data)
	{
		Node p = null;
		Queue q = new LinkedList();
		q.add(root);
		boolean flag = false;
		while(!q.isEmpty())
		{
			p =(Node) q.remove();
			if(p.data == data)
			{
				flag = true;
				break;
			}
			if(p.left!=null) q.add(p.left);
			
			if(p.right!=null) q.add(p.right);
		}
		return flag;
	}
	public boolean search(Node p, int data)
	{
		boolean temp;
		if(p == null)
		{
			return false;
		}
		else
		{
			if(p.data == data)
			{
				return true;
			}
			else
			{
				temp = search(p.left,data);
				if(temp)
					return true;
				else 
					return search(p.right,data);
			}
		}
	}
	public void size()
	{
		System.out.println("Size of Tree = "+size(root));
		System.out.println("Size of Tree without recursion = "+sizeWithoutRec(root));	
	}
	public int size(Node p)
	{
		if(p==null)
			return 0;
		else
			return 1 + size(p.left) + size(p.right);
	}
	public int sizeWithoutRec(Node p)
	{
		Queue q = new LinkedList();
		q.add(p);
		int size = 0;
		while(!q.isEmpty())
		{
			p = (Node)q.remove();
			size++;
			if(p.left!=null) q.add(p.left);
			
			if(p.right!=null) q.add(p.right);
		}
		return size;
	}
	public void deleteTree()
	{
		root = deleteUsingRec(root);
		System.out.println("Tree is deleted");
	}
	public Node deleteUsingRec(Node p)
	{
		if(p == null) return null;
		deleteUsingRec(p.left);
		deleteUsingRec(p.right);
		return null;
	}
	public void height()
	{
		System.out.println("Height of tree = "+heightOfTree(root));
		System.out.println("Height of tree = "+findHeightOfTree());
	}
	public int heightOfTree(Node p)
	{
		int lheight= 0;
		int rheight = 0;
		if(p==null)
			return 0;
		else if(p.left == null && p.right == null)
			return 0;
		else
		{
			lheight = 1 + heightOfTree(p.left);
			rheight = 1 + heightOfTree(p.right);
			if(lheight<rheight)
			{
				return rheight;
			}
			else
			{
				return lheight;
			}
		}
	}
	public int findHeightOfTree()
	{
		int level = 0;
		Node p = null;
		if(root == null) return 0;
		Queue q = new LinkedList();
		q.add(root);
		q.add(null);
		while(!q.isEmpty())
		{
			p = (Node)q.remove();
			if(p == null)
			{
				if(!q.isEmpty())
				{
					q.add(null);
				}
				level++;
			}
			else
			{
				if(p.left!=null) q.add(p.left);
				
				if(p.right!=null) q.add(p.right);
			}
		}
		level--;
		return level;
	}
	public void deepestNodeInBinaryTree()
	{
		Node p = root;
		if(p==null) return;
		Queue q = new LinkedList();
		q.add(p);
		while(!q.isEmpty())
		{
			p = (Node) q.remove();
			if(p.left!=null) q.add(p.left);
			
			if(p.right!=null) q.add(p.right);
		}
		q = null;
		System.out.println("Node in tree = "+p.data);
	}
	public void noOfLeaves()
	{
		Node p = root;
		Queue q = new LinkedList();
		int count = 0;
		if(p==null) return;
		
		q.add(p);
		while(!q.isEmpty())
		{
			p = (Node)q.remove();
			
			if(p.left==null && p.right == null)
				count++;
			else
			{
				if(p.left!=null) q.add(p.left);
				
				if(p.right!=null) q.add(p.right);
			}
		}
		q = null;
		System.out.println("Number of leaves = "+count);
	}
	public void mirror()
	{
		mirror(root);
		preorder(root);
	}
	public Node mirror(Node p)
	{
		Node temp = null;
		if(p==null) return null;
		else
		{
			mirror(p.left);
			mirror(p.right);
			temp = p.left;
			p.left = p.right;
			p.right = temp;
		}
	}
	public static void main(String[] args)
	{
		Scanner sc  = new Scanner(System.in);
		BinaryTree obj = new BinaryTree();
		int choice = 0;
		do
		{
			System.out.println("1. Insert\n2. Print\n3. Find Maximum Number in Tree\n4. Search\n5. Size\n6. Delete Tree\n7. Height\n8. Deepest Node in binary tree\n9. Number of leaves\n10. Mirror\n11. Exit");
			choice = sc.nextInt();
			switch(choice)
			{
				case 1: obj.insert();
					break;
				case 2: obj.print();
					break;
				case 3: obj.findMax();
					break;
				case 4: obj.search();
					break;
				case 5: obj.size();
					break;
				case 6: obj.deleteTree();
					break;
				case 7: obj.height();
					break;
				case 8: obj.deepestNodeInBinaryTree();
					break;
				case 9: obj.noOfLeaves();
					break;
				case 10: obj.mirror();
					 break;
				case 11: return;
			}
		}while(true);
	}
}
