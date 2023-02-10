package Test.Programs;

public class ReverseString_with_StringBulder 
{
	public static void main(String[] args) 
	{
		String str = "Main String to be Reversed";		
		
		StringBuilder sb = new StringBuilder(str);
		str = sb.reverse().toString();
		
		System.out.println("Reversed String : " + str);

	}
}
