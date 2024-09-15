package selenium_programs;

public class Prime 
{
	public static void main(String[] args) 
	{
	    int n = 7;
	    int count = 0;
	     
	    if (n <= 1)
	    {
		    count++;   //--->First Condition Validation
	    }
	    
	    for (int i = 2; i <= n / 2; i++) 
	    {
	      if (n % i == 0)
	      {
	        count++;
	        System.out.println(i);
	      }
	    }

	    if ( count > 0)
	    	
	      System. out.println("The number is not prime");
	    else
	      System. out.println("The number is prime");
	  }
}
