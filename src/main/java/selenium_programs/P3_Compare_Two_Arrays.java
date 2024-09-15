package selenium_programs;

import java.util.Arrays;

public class P3_Compare_Two_Arrays 
{
	public static void main(String[] args) 
	{          
		int[] a = {0,1,2,3,4,5};            
		int[] b = {0,1,2,3,4,5};

		if(Arrays.equals(a,b)) 
		{
			System.out.println("Given arrays are equal");                   
		} 
		else 
		{         
			System.out.println("Given arrays are not equal");                   
		}            
	}
}

//====[Output]===========================================
//

