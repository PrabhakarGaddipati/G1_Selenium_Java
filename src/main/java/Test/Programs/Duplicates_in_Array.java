package Test.Programs;

public class Duplicates_in_Array 
{
	public static void main (String args[])
	{		
		int a[] = {1,2,4,2};
		
		for(int i=0; i<a.length; i++)
		{
			for (int j=i+1; j<a.length; j++)
			{
				if(a[i]==a[j])
				{ 
					System.out.println("Value is Matched: "+a[j]);
				}
			}
		}

	}
} 

//Video: https://www.youtube.com/watch?v=SD-qXsIVu5c&ab_channel=SoftwareTestingAndAutomation
	