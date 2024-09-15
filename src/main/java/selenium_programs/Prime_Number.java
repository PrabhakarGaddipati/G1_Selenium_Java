package selenium_programs;

public class Prime_Number 
{
	public static void main(String args[])
	{
		int x = 4;
		int count = 0;

		if (x>1)                         //First Condition Checking (Value always should be greater then 1)
		{
			for(int i=1; i<=x; i++) 
			{
				if(x%i==0)        
				{
					count ++;
				}
			}
				if(count==2)          //Second  Condition Checking
				{
					System.out.println("Prime Number");			
				}
				else
				{
					System.out.println("Not Prime Number");
				}					
		}
		else
		{
			System.out.println("Please Enter the valid value Greater then 1");
		}
	}
}
