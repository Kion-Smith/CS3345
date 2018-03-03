/*Kion Smith
 * kls160430
 * CS3345-501
 */
public class HW4Part2 
{
	public static void main(String[] args)
	{
		RandomBinaryTree rbt = new RandomBinaryTree();
		int randomSize = (int) (Math.random()*20)+4;//randomly select size from 4 - 20
		
		for(int i=0;i<randomSize;i++)
		{
			rbt.insert((int) (Math.random()*50)+1); //select value from 1 - 50
		}
		
		if(rbt.isBST())// if the tree is a bst
		{
			System.out.println("The random tree is a Binary Search Tree");
			
			if(rbt.isAVL()) // it the tree is an avl
			{
				System.out.println("And the tree is also an AVL Tree");
			}
			else
			{
				System.out.println("But the tree is NOT an AVL Tree");
			}
		}
		else // if both options fail
		{
			System.out.println("The random tree is NOT a Binary Seach Tree");
			System.out.println("And the tree is NOT an AVL Tree");
		}
		
	}
}
