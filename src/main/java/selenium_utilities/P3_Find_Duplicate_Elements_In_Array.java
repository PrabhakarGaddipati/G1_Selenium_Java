package selenium_utilities;

public class P3_Find_Duplicate_Elements_In_Array 
{
	public static void main(String[] args) 
	{  
        //Initialize array  
        int arr[] = new int [] {1, 2, 3, 4, 2, 7, 8, 8, 3};  
        
        System.out.println("Duplicate elements in given array: ");  
        
        //Searches for duplicate element
        for(int i = 0; i < arr.length; i++) 
        {  
	            for(int j = i + 1; j < arr.length; j++) 
	            {  
		               //if any match from arr[i] & arr[j], then it is print in the Console
	            	    if(arr[i] == arr[j])
		                {
		                    System.out.println(arr[j]);  
		                }
	            }  
        }  
	}
}


//====[Output]===========================================
//
