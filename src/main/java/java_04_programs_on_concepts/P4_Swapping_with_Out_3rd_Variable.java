package java_04_programs_on_concepts;

import java.util.Scanner;

public class P4_Swapping_with_Out_3rd_Variable
{
	public static void main(String[] args) 
	{  
		int x, y, t;// x and y are to swap	
		Scanner sc = new Scanner(System.in); 
		
		System.out.println("Enter the value of X and Y");	
		x = sc.nextInt();  
		y = sc.nextInt();  
		
		System.out.println("before swapping numbers: "+x +"  "+ y);  
		
		/*swapping */  
		t = x;  
		x = y;  
		y = t;  
		
		System.out.println("After swapping: "+x +"   " + y);  
		System.out.println( );  
	}    
}  

//====[Output]===========================================
//

