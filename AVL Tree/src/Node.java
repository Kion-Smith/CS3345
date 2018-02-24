
public class Node 
{
	//values
	//unsure how I am going to balance these
	String key;//ISBN
	BookObj value;
	
	//"pointers"
	public Node left;
	public Node right;
	
	public int height;
	
	//default constructor
	public Node()
	{
		//Data properties
		key = "";
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
		key = bookNum;
		value = bookVal;
			
		//AVL properties
		left = null;
		right =null;
		height = 0;
				
	}
	
	public int compareTo(Node compare)
	{

		try
		{
			Long og = Long.parseLong(key);
			Long c = Long.parseLong(compare.key);
			
			if(og>c)
			{
				return 1;
			}
			else
			{
				return 0;
			}
		}
		catch(Exception e)
		{
			System.out.println("Not a valid isbn number");
			e.printStackTrace();
		}
		
		return -1;
	}
}
