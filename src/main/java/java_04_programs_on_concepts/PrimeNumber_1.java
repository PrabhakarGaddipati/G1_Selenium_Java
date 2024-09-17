package java_04_programs_on_concepts;

import java.util.Scanner;

public class PrimeNumber_1 
{
	public static void main(String[] args) 
	{  
		Scanner s = new Scanner(System.in);  
		System.out.print("Enter a number : ");  
		
		int n = s.nextInt();  
		if (isPrime(n)) 
		{  
			System.out.println(n + " is a prime number");  
		} 
		else 
		{  
			System.out.println(n + " is not a prime number");  
		}  
	}  
	
	static boolean isPrime(int n)
	{
		// Check if number is <= 1    ---->(1st Condition Checking)
		if (n <= 1)
		{
			return false;
		}
		
		// Check for factors  		  ---->(2nd Condition Checking)
		for (int i = 2; i <= n/2; i ++ )
		{
			if (n % i == 0)
			{
				return false;
			}
		}
		return true;
	}

}

