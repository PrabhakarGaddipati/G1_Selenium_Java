package java_programs_on_collections;

import java.util.ArrayList;
import java.util.Iterator;
  
class Test 
{
    public static void main(String[] args)
    {
        ArrayList<String> list = new ArrayList<String>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
  
        // Iterator to traverse the list
        Iterator<String> iterator = list.iterator();
  
        System.out.println("List elements : ");
  
        while (iterator.hasNext())
        System.out.print(iterator.next() + " ");
  
        System.out.println();
     }
}

//====[Output]===========================================
//

