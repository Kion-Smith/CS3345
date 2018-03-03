/*Kion Smith
 * kls160430
 * CS3345-501
 */
public class AVLTree
{
	//Root node, holds the tree
	Node root;
	
	//default constructor
	public AVLTree()
	{
		root = null;
	}
	
	//Overloaded method used as a recursion helper function
	public void insert(long key,BookObj book)
	{
		//go through node to insert
		root = insert(root,key,book);
	}
	
	public Node insert(Node cur,long key,BookObj book)
	{
		//if node is null then create this node
		if(cur==null)
		{
			return (new Node(key,book));
		}
		
		//BST property when inserting
		//checking if cur key is less than node
		if(key<cur.key)
		{
			cur.left = insert(cur.left,key,book);
		}
		//checking if cur key is greater than node
		else if(key>cur.key)
		{
			cur.right = insert(cur.right,key,book);
		}
		else
		{
			//returns if there is a duplicate
			return cur;
		}
		
		//increment the height
		cur.height = maxHeight(height(cur.left),height(cur.right)) +1;
		
		//get the balance number for the property
		int balance = getBalance(cur);
		
		//check the balance property
		//check for Left left rotation
		if(balance>1&&key<cur.left.key)
		{
			System.out.println("Imbalance occurred at inserting ISBN "+key+"; Fixed using a Left left rotation");
			rotateRight(cur);
		}
		//check for Right right rotation
		if(balance<-1&&key>cur.right.key)
		{
			System.out.println("Imbalance occurred at inserting ISBN "+key+"; Fixed using a Right right rotation");
			rotateLeft(cur);
		}
		//check for the left right rotation
		if(balance>1&&key>cur.left.key)
		{
			System.out.println("Imbalance occurred at inserting ISBN "+key+"; Fixed using a Left right rotation");
			//rotate left then right
			cur.left = rotateLeft(cur.left);
			return rotateRight(cur);
		}
		//check for the right left rotation
		if(balance<-1&&key<cur.right.key)
		{
			System.out.println("Imbalance occurred at inserting ISBN "+key+"; Fixed using a Right left rotation");
			//rotate right then left
			cur.right = rotateRight(cur.right);
			return rotateLeft(cur);
		}
		
		return cur;
	}
	
	//Rotate to the left
	public Node rotateLeft(Node n)
	{
		Node target = n.right;//rotate target to node
		Node subTree  = target.left;//get its subtree
		
		target.left = n;//set targets old sub tree to nodes sub tree
		n.right = subTree;// set old sub tree to nodes subtree
		
		//increment the height of the tree
		n.height = maxHeight(height(n.left),height(n.right))+1;
		target.height = maxHeight(height(target.left),height(target.right))+1;
		
		return target;
	}
	
	//Rotate to the right
	public Node rotateRight(Node n)
	{
		Node target = n.left;//rotate target to node
		Node subTree = target.right;//get its subtree
		
		target.right = n; //set targets old sub tree to nodes sub tree
		n.left =subTree;// set old sub tree to nodes subtree
		
		//increment the height of the tree
		n.height = maxHeight(height(n.left),height(n.right))+1;
		target.height = maxHeight(height(target.left),height(target.right))+1;
		
		return target;
	}
	

	
	//get current height of node
	public int height(Node n)
	{
		if(n==null)
		{
			return -1;//empy node height is -1
		}
		else
		{
			return n.height;
		}
	}
	//Chooses the higher height form l or right node
	public int maxHeight(int h1,int h2)
	{
		if(h1>h2)
		{
			return h1;
		}
		else
		{
			return h2;
		}
	}
	
	
	//(L-R) gets balance at a given node
	public int getBalance(Node n)
	{
		if(n==null)
		{
			return -1;
		}
		else
		{
			return height(n.left)-height(n.right);
		}
	}
	

	
}
