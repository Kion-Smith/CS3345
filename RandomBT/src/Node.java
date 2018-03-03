/*Kion Smith
 * kls160430
 * CS3345-501
 */
public class Node
{
	
	public int value; // the key
	
	//the pointers
	public Node left;
	public Node right;
	
	//height of node
	public int height;
	
	//default constructor
	public Node()
	{
		value =0;
		left=null;
		right=null;
		height =0;
		
	}
	
	//overloaded constructor
	public Node(int v)
	{
		value = v;
		left=null;
		right=null;
		height =0;
	}
}
