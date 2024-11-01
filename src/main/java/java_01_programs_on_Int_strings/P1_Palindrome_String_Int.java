package java_01_programs_on_Int_strings;

import java.util.Scanner;

public class P1_Palindrome_String_Int 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String: ");

		String str = sc.nextLine();
		String reverseStr = "";

		int strLength = str.length();

		for (int i = (strLength - 1); i >= 0; --i)
		{
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

// Good Progaming Logic - Understand
//====[Output]===========================================



