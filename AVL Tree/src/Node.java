
public class Node 
{
	//values
	//unsure how I am going to balance these
	String ISBN;
	BookObj value;
	
	//"pointers"
	public Node left;
	public Node right;
	
	public int height;
	
	//default constructor
	public Node()
	{
		//Data properties
		ISBN = "";
		value = null;
	
		//AVL properties
		left = null;
		right =null;
		height = -1;
		
	}
	
	//Overloaded constructor
	public Node(String bookNum,BookObj bookVal)
	{
		//Data properties
		ISBN = bookNum;
		value = bookVal;
			
		//AVL properties
		left = null;
		right =null;
		height = 0;
				
	}
	
}
