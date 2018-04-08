 /*
 * Kion Smith
 * kls16430
 * CS3345-501 
 */
public class bTreeMain 
{
	public static void main(String [] args)
	{
		
		bTree t = new bTree();
		// Keys to insert 1, 12, 8, 2, 25, 6, 14, 28, 17, 7, 52, 16, 48, 68, 3, 26, 29, 53, 55, 45 
		t.insert(1);
		t.insert(12);
		t.insert(8);
		t.insert(2);
		t.insert(25);
		t.insert(6);
		t.insert(14);
		t.insert(28);
		t.insert(17);
		t.insert(7);
		t.insert(52);
		t.insert(16);
		t.insert(48);
		t.insert(68);
		t.insert(3);
		t.insert(26);
		t.insert(29);
		t.insert(53);
		t.insert(55);
		t.insert(45);
		
		//print the tree
		t.root.inOrder(0);
		
		
		
	}
}
