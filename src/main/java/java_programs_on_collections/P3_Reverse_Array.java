package java_programs_on_collections;

public class P3_Reverse_Array 
{
	public static void main(String[] args) 
	{  
	        //Initialize array  
	        int [] arr = new int [] {1, 2, 3, 4, 5};  
	        System.out.println("Original array: ");  
	        
	       //Loop through the array in direct (norma) order  
	        for (int i=0; i < arr.length; i++) 
	        {  
	            System.out.print(arr[i] + " ");  
	        }  

	        System.out.println('\n'+"Array in reverse order: ");  
	        
	        //Loop through the array in reverse order  
	       for (int i = arr.length-1; i >= 0; i--) 
	        {  
	            System.out.print(arr[i] + " ");  
	        }  
	    }  
	}


//====[Output]===========================================
//

