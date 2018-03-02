
public class Node 
{
	//values
	//unsure how I am going to balance these
	long key;//ISBN
	BookObj book;
	
	//"pointers"
	public Node left;
	public Node right;
	
	public int height;
	
	//default constructor
	public Node()
	{
		//Data properties
		key = 0;
		book= null;
	
		//AVL properties
		left = null;
		right =null;
		height = 0;
		
	}
	
	//Overloaded constructor
	public Node(int isbn,BookObj bookVal)
	{
		//Data properties
		key = isbn;
		book = bookVal;
			
		//AVL properties
		left = null;
		right =null;
		height = 0;
				
	}
	
	public void setHeight(int h)
	{
		height =h;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	
}
