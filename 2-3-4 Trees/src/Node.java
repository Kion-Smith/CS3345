 /*
 * Kion Smith
 * kls16430
 * CS3345-501 
 */
public class Node
{
	//hold parent/child of current nodes
	public Node parent;
	public Node children[];
	
	//keeps track of current level elements
	public int curAmount;
	public int currentLevel[];
	
	//default constructor
	public Node()
	{
		parent = null;
		children = new Node[4];
		currentLevel = new int[3];
		curAmount =0;
	}
	
	//insert and element into the currentLevel array
	public int insertElement(int key)
	{
		//increment the amount and assuming there is enough space for this level
		curAmount++;
		
		for(int i=2;i>=0;i--)
		{
			//if any element is empty check to see where item can be placed
			if(currentLevel[i] != '\0')
			{
				//if current item is bigger place key to the right
				if(key<currentLevel[i])
				{
					currentLevel[i+1] = currentLevel[i];
				}
				//if smaller place to the right
				else
				{
					currentLevel[i+1] = key;
					return i+1;
				}
			}
			
		}
		
		
		currentLevel[0] = key;
		return 0;
	}
	
	//remove and element from current level array
	public int removeElement()
	{
		//hold old element
		int hold = currentLevel[curAmount-1];
		//set the old element to null and decrement
		currentLevel[curAmount-1] ='\0';
		curAmount--;
		
		return hold;
	}
	
	//adding a child to an element
	public void addChild(int loc, Node cur)
	{
		//add node at location
		children[loc] = cur;
		if( cur != null)
		{
			//parent equal to current
			cur.parent = this;
		}
	}
	
	public Node removeChild(int loc)
	{
		//hold the child
		Node hold = children[loc];
		//set old location to null
		children[loc] = null;
		return hold;
	}
	
	//check to see if a child node has children;If not then its a leaf
	public boolean isALeaf()
	{
		if(children[0] != null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	//check to see  if the current level has 3 nodes, if does then need to permeative split
	public boolean isLevelFull()
	{
		if(curAmount != 3)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	//Loop through every child and print out the in order relationship of nodes
	public void inOrder(int level)
	{
		for(int i=0;i<curAmount;i++)
		{
			if(!isALeaf() )
			{
				children[i].inOrder(level+1);
			}
			System.out.println("Level = " +level+"| Element = "+ currentLevel[i]+" ");
			
		}
		
		if(!isALeaf() )
		{
			children[curAmount].inOrder(level+1);
		}
	}
	
	
	
	

}
