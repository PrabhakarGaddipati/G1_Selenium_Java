package Test.Programs;

import java.util.Scanner;

public class Swapping 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter two numbers: ");

		//consider two numbers as -> a=4 & b=5 
		int a = sc.nextInt(); 
		int b = sc.nextInt();
		
		a = a + b;  //a = 4 + 5 = 9
		b = a - b;  //b = 9 - 5 = 4
		a = a - b;  //a = 9 - 4 = 5
		
		System.out.println("Numbers after swapping : " + a + " " + b);
	}
}


