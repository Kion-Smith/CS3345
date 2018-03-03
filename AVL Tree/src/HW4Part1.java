/*Kion Smith
 * kls160430
 * CS3345-501
 */
import java.io.*;
import java.util.*;
public class HW4Part1 
{
	
	
	public static void main (String[] args)
	{
		
		File f = new File("Books.txt");
		AVLTree avl = new AVLTree();
		
		
		try 
		{
			Scanner kb = new Scanner(f);
			
			//loop through file
			while(kb.hasNextLine())
			{
				String tempString = kb.nextLine();		
				
				String tempISBN = tempString.substring(0,tempString.indexOf(" "));
				Long ISBN = Long.parseLong(tempISBN);

				String temp = tempString.substring(tempString.indexOf(" ")+1);
				String bookName = temp.substring(0,temp.indexOf(" "));
				
				temp = tempString.substring(tempString.indexOf(" ")+1);
				String authorName = temp.substring(temp.indexOf(" ")+1);
				
				BookObj tempBook = new BookObj(bookName,authorName);
				
				//add the items to the avl tree using recursion helper
				avl.insert(ISBN,tempBook);
			}
			
			
			
		}
		catch (FileNotFoundException e) 
		{
			System.out.println("File could not be found");
			e.printStackTrace();
		}
	}
}
