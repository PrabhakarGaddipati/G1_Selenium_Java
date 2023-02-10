package Test.Programs;

import java.util.Scanner;

public class PrimeNumber_with_Forloop 
{
	public static void main(String[] args)
	   {
	      int num, i, count=0;
	      Scanner s = new Scanner(System.in);
	      
	      System.out.print("Enter a Number: ");
	      num = s.nextInt();
	      
	      for(i=2; i<num; i++)
	      {
	         if(num%i == 0)
	         {
	            count++;
	            break;
	         }
	      }
	      
	      if(count==0)
	         System.out.println("\nIt is a Prime Number.");
	      else
	         System.out.println("\nIt is not a Prime Number.");
	   }
}

//Note: Prime number is a number that is greater than 1 and divided by 1 or itself only.

