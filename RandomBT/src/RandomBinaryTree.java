/*Kion Smith
 * kls160430
 * CS3345-501
 */
public class RandomBinaryTree 
{
	//root of tree
	Node root;
	
	public RandomBinaryTree()
	{
		root = null;
	}

	//helper for inserting( like in avl tree)
	public void insert(int value)
	{
		root = insert(root,value);
	}
	
	public Node insert(Node cur,int value) 
	{
		//choose a random number between 1 and 2 to select the branch
		int branch = (int) (Math.random()*2)+1;
		
		// if nothing is in cur then add a node
		if(cur == null)
		{
			cur = new Node(value);
		}
		//add item to the left if 1 branch is 1
		else if(branch == 1)
		{
			cur.left = insert(cur.left,value);
		}
		// go right if branch is  2
		else if (branch ==2)
		{
			cur.right = insert(cur.right,value);
		}
		//increment height for avl checking later
		cur.height = maxHeight(height(cur.left),height(cur.right));
		return cur;
	}
	//helper method
	public boolean isBST()
	{
		// choose the min and max numbers to compare
		return isBST(root,1,50);
	}
	//check if is a bst
	public boolean isBST(Node cur ,int min,int max)
	{
		if(cur == null)
		{
			return true;
		}
		//check to see if min is greater than value or if max is greater than value
		else if(cur.value<min || cur.value>max)
		{
			return false;
		}
		else 
		{
			//keep checking min with cur value, and check max with cur value
			return ((isBST(cur.left,min,cur.value)&&isBST(cur.right,cur.value,max)));
		}

	}
	//helper method
	public boolean isAVL()
	{
		//if not a bst then cant be an avl
		if(isBST())
		{
			return isAVL(root);
		}
		else
		{
			return false;
		}
	}
	//check if it is an avl
	public boolean isAVL(Node cur)
	{
		if(cur == null)
		{
			return true;
		}
		//get absloute value and check it the cur value is greater than or equal to 2 
		else if(Math.abs(getBalance(cur))>1)
		{
			return false;
		}
		else
		{
			//check for the left and right branch if there is an imbalance
			return (isAVL(cur.left)&&isAVL(cur.right));
		}
	
	}
	
	//Old methods from avl tree from part 1 that are helpful here 
	
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
	//gets height
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
	//L-R to get balance
	public int getBalance(Node n)
	{
		if(n==null)
		{
			return 0;
		}
		else
		{
			return height(n.left)-height(n.right);
		}
	}
	

	
}
