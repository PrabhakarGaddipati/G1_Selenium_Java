package Test.Programs;

//consider two numbers as -> a=4 & b=5 
		int a = sc.nextInt(); 
		int b = sc.nextInt();
		
		a = a + b;  //a = 4 + 5 = 9
		b = a - b;  //b = 9 - 5 = 4
		a = a - b;  //a = 9 - 4 = 5
		
		System.out.println("Numbers after swapping : " + a + " " + b);
	}
}


import java.io.*;
import java.util.*;
  
class Test {
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

