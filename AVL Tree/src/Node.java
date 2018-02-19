
public class Node 
{
	//some data
	//idk what the data is yet
	String ISBN;
	BookObj value;
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
	
	
	public Node(String bookNum,int BookVal)
	{
		
	}
	
}
