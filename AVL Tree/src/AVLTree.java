
public class AVLTree
{
	Node root;
	
	public AVLTree() 
	{
		root = null;
	}
	
	public Node insertNode(Node n)
	{
		return n;
	}
	
	public Node rotateLeft(Node n)
	{
		Node target = n.left;
		Node targetSub = target.right;
		
		target.right = n;
		n.left = targetSub.right;
		
		
		return n;
	}

	public Node rotateRight(Node n)
	{
		return n;
	}
	
	public int getHeight(Node n)
	{
		return n.height;
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
