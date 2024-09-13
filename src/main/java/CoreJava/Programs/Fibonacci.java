package CoreJava.Programs;
//import java.util.Scanner;

public class Fibonacci 
{
	public static void main(String[] args) 
	{
		int first = 0; 
		int second = 1; 
		int n = 10; 
		
		 for(int i = 1; i <= n; i++)
		 {					
			 int third = first + second;
			 first = second;
			 second = third;
			 
			 System.out.println(first);  //---> This line is most imp, will print the Fibonacci Series
		 }
	}
}
