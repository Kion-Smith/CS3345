/*Kion Smith
 * kls160430
 * CS3345-501
 */
public class Node 
{
	//Nodes values
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
	public Node(long isbn,BookObj bookVal)
	{
		//Data properties
		key = isbn;
		book = bookVal;
			
		//AVL properties
		left = null;
		right =null;
		height = 1;
				
	}
	
}
