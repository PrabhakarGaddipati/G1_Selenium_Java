package java_01_programs_on_strings;

import java.util.Scanner;

public class P1_Palandrm_int
{
	public static void main(String[] args) 
	{  
		Scanner sc = new Scanner(System.in);  
		System.out.println("Enter the number: ");  	       

		String num = sc.nextLine();
		String reverse = ""; 


		for ( int i = num.length() - 1; i >= 0; i-- )  
		{
			reverse += num.charAt(i);  
		}
		
			if (num.equals(reverse))  
			{
				System.out.println("The entered string " +num +" is a palindrome.");  
			}
			else  
			{
				System.out.println("The entered string " +num +"  isn't a palindrome.");     
			}
	}
}
