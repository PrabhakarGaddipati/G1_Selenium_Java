package Test.Programs;

public class Print_Elements_In_Arrays 
{
	public static void main(String args[])
	{
		//initialize the elements to the array
		int a[] = {11, 25, 55, 65, 75};
		int d;
    
		System.out.println("Elements in the arry are:");
		for(int i=0; i< a.length; i++)
		{
			int c_value = a[i];
			System.out.print(c_value+" ");
		}
	}
}
