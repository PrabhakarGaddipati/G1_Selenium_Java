package Test.Programs;
import java.util.Scanner;

public class Fibonacci 
{
	public static void main(String[] args) 
	{
		int n, a = 0, b = 0, c = 1; 
		String  s1 = "Data";

		try (Scanner s = new Scanner(System.in)) 
		{
			System.out.print("Enter value of n:");
			n = s.nextInt();
		}
		for(int i = 1; i <= n; i++)
		{
			a = b;
			b = c;
			c = a + b;
			System.out.print(a+" ");
		}
	}
}


