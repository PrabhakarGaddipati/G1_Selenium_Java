package Test.Programs;

import java.util.*;   
public class P1_Palindrome_String_Int
{  
	 public static void main(String[] args) 
     {
            Scanner sc = new Scanner(System.in);  
            System.out.println("Enter the String: ");  

           String str = sc.nextLine();
           String reverseStr = ""; 

          //--> we are finding the length,here
           int strLength = str.length();     

          //-->Every Iteration we are decrasing the "i" value, Ex: 4,3,2,1,0
           for (int i = (strLength - 1); i >=0; --i)    
           {
        	   //--> Every Iteration --> One Letter Added by "+" Ex: r+a+d+a+r
        	   reverseStr = reverseStr + str.charAt(i);  
           }

                  if (str.equals(reverseStr))
                  {
                        System.out.println(str + " is a Palindrome String.");
                  }
                else
                 {
                       System.out.println(str + " is not a Palindrome String.");
                 }
                  sc.close();
     }
}

//Comments: Test1
