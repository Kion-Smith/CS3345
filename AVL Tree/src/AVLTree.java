
public class AVLTree
{
	Node root;
	
	public AVLTree() 
	{
		root = null;
	}
	
	public Node insertNode(Node cur,int k,BookObj b)
	{
		int balance =0;;
		if(cur == null)
		{
			cur = new Node(k,b);
		}
		if(k < cur.key)
		{
			cur.left = insertNode(cur.left,k,b);
		}
		else if(k>cur.key)
		{
			cur.right = insertNode(cur.right,k,b);
		}
		else
		{
			return cur;
		}
		
		balance = getBalance(cur);
		
		
		if(balance>1 && k<cur.left.key)
		{
			System.out.println("Imbalance occurred at inserting  "+k+" fixed in right rotation");
			return rotateRight(cur);
		}
		
		if(balance<-1 && k<cur.right.key)
		{
			System.out.println("Imbalance occurred at inserting  "+k+" fixed in left rotation");
			return rotateLeft(cur);
		}
		
		if(balance>1 && k>cur.left.key)
		{
			System.out.println("Imbalance occurred at inserting  "+k+" fixed in left right rotation");
			cur.left = rotateLeft(cur.left);
			return rotateRight(cur);
		}
		
		if(balance<-1 && k>cur.right.key)
		{
			System.out.println("Imbalance occurred at inserting  "+k+" fixed in right left rotation");
			cur.right = rotateRight(cur.right);
			return rotateLeft(cur);
		}
		
		return cur;
	}
	
	public Node rotateLeft(Node n)
	{
		Node target = n.right;
		Node targetSub = target.left;		
		target.left = n;
		n.right = targetSub.left;
		
		n.setHeight( (compareHeight(n.left.getHeight(),n.right.getHeight())) + 1);
		target.setHeight( (compareHeight(n.left.getHeight(),n.right.getHeight())) +1);
		
		return n;
	}
	
	public Node rotateRight(Node n)
	{
		Node target = n.left;
		Node targetSub = target.right;
		target.right = n;
		n.left = targetSub.right;
		
		n.setHeight( (compareHeight(n.left.getHeight(),n.right.getHeight())) + 1);
		target.setHeight( (compareHeight(n.left.getHeight(),n.right.getHeight())) +1);
	
		return n;
	}
	

	public int compareHeight(int r,int l)
	{
		if(r>l)
		{
			return r;
		}
		else
		{
			return l;
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
