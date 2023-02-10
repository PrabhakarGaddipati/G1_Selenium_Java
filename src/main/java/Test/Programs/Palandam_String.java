package Test.Programs;

import java.util.*;   
public class Palandam_String
{  
	 public static void main(String[] args) 
     {
            Scanner sc = new Scanner(System.in);  
            System.out.println("Enter the String: ");  

           String str = sc.nextLine();
           String reverseStr = ""; 

           int strLength = str.length();     //---> we are finding the length,here

           for (int i = (strLength - 1); i >=0; --i)    //- -->Every Iteration we are decrasing the "i" value, Ex: 4,3,2,1,0
           {
                  reverseStr = reverseStr + str.charAt(i);   //---> Every Iteration --> One Letter Added by "+" Ex: r+a+d+a+r
           }

                  if (str.equals(reverseStr))
                  {
                        System.out.println(str + " is a Palindrome String.");
                  }
                else
                 {
                       System.out.println(str + " is not a Palindrome String.");
                 }
     }
}

