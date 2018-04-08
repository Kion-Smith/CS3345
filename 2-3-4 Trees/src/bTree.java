
 /*
 * Kion Smith
 * kls16430
 * CS3345-501 
 */
public class bTree 
{
	//root node
	public Node root;
	
	//default constructor
	public bTree()
	{
		root = new Node();
	}
	
	//general insertion of a key
	public void insert (int key)
	{
		Node cur = root;
		
		//loop until cur is not equal to null
		while(cur != null)
		{
			//if the current level is full then split
			if(cur.isLevelFull() )
			{
				split(cur);
				//hold on to the parent and select next leaf/location
				cur = cur.parent;
				cur = chooseChild(cur, key);
			}
			//if a leaf is reached then break
			else if(cur.isALeaf())
			{
				break;
			}
			else
			{
				//find the next good leaf
				cur = chooseChild(cur, key);
			}
			
		}
		//insert into the the tree
		cur.insertElement(key);
	}
	
	public void split(Node cur)
	{
		//hold variables
		int hold3,hold2,holdIndex;
		Node parent,child3,child2;
		
		//hold the last few elements
		hold2 = cur.removeElement();
		hold3 = cur.removeElement();
		
		//hold the children to be reassigned
		child2 = cur.removeChild(2);
		child3 = cur.removeChild(3);
		
		
		Node right = new Node();
		//if nothing in cur
		if(cur == root)
		{
			//set root to a new node and then add item
			root =new Node();
			parent = root;
			root.addChild(0, cur);
		}
		else
		{
			//getting  parent of current node and setting it
			parent = cur.parent;
		}
		
		//get the index of the parents insetion
		holdIndex = parent.insertElement(hold3);
		
		for(int i = (parent.curAmount)-1;i>holdIndex;i--)
		{
			Node temp = parent.removeChild(i);
			parent.addChild(i+1, temp);
		}
		
		//add right to parent
		parent.addChild(holdIndex+1, right);
		
		//set the children back to there new postions
		right.insertElement(hold2);
		right.addChild(0, child2);
		right.addChild(1, child3);
		
	}
	
	//select the next possible child
	public Node chooseChild(Node cur,int key)
	{
		int i=0;
		for(i =0;i<cur.curAmount;i++)
		{
			if(key<cur.currentLevel[i])
			{
				return cur.children[i];
			}
		}
		
		return cur.children[i];
	}
	

}
