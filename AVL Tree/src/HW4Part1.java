import java.io.*;
import java.util.*;
public class HW4Part1 
{
	
	
	public static void main (String[] args)
	{
		File f = new File("sometextfile.txt");
		try 
		{
			Scanner kb = new Scanner(f);
			
		}
		catch (FileNotFoundException e) 
		{
			System.out.println("File could not be found");
			e.printStackTrace();
		}
	}
}
