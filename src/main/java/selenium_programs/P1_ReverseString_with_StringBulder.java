package selenium_programs;

public class P1_ReverseString_with_StringBulder 
{
	public static void main(String[] args) 
	{
		String str = "Main String to be Reversed";		
		
		StringBuilder sb = new StringBuilder(str);
		str = sb.reverse().toString();
		
		System.out.println("Reversed String : " + str);

	}
}

//====[Output]===========================================
//Reversed String : desreveR eb ot gnirtS niaM