package selenium_utilities;

import java.util.ArrayList;
import java.util.ListIterator;

public class P4_ArrayList_Iterators 
{
	public static void main(String arg[])
	{
		ArrayList<Integer> n1 = new ArrayList<Integer>();
		n1.add(11);
		n1.add(12);
		n1.add(13);
		System.out.println("Direct Lements in arraylist:"+n1);

		ListIterator<Integer> v1 = n1.listIterator();		
		while(v1.hasNext())
		{
			System.out.println("Values are:"+v1.next());
		}
	}
}


//====[Output]===========================================
//

