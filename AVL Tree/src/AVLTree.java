
public class AVLTree
{
	Node root;
	
	public AVLTree() 
	{
		root = null;
	}
	
	public Node insertNode(Node n,Node cur)
	{
		if(n == null)
		{
			return null;
		}
		if(n.compareTo(cur) == 1)
		{
			
		}
		else if(n.compareTo(cur) == 0)
		{
			
		}
	
		return n;
	}
	
	public Node rotateLeft(Node n)
	{
		Node target = n.right;
		Node targetSub = target.left;
		
		target.left = n;
		n.right = targetSub.left;
		
		
		return n;
	}
	
	public Node rotateRight(Node n)
	{
		Node target = n.left;
		Node targetSub = target.right;
		
		target.right = n;
		n.left = targetSub.right;
		
		
		return n;
	}

	
	public int getHeight(Node n)
	{
		if(n == null)
		{
			return -1;
		}
		else
		{
			return n.height;
		}
	}
	
	public int getBalance(Node n)
	{
		if(n == null)
		{
			return 0;
		}
		else
		{
			return n.left.height - n.right.height;
		}

	}
	
	
}
