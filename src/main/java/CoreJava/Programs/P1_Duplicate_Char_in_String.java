package CoreJava.Programs;

public class P1_Duplicate_Char_in_String 
{
	 public static void main(String argu[]) 
	 {
		  String str = "w3schools";
		  int cnt = 0;
		  
		  char[] inp = str.toCharArray();
		  System.out.println("Duplicate Characters are:");
		  
		  //Below for lopp is for Compare "i"  and "j"  Values, and Print the Matched values in "i"  and "j"
		  for (int i = 0; i < str.length(); i++)
		  {
				   for (int j = i+1; j < str.length(); j++)
				   {
						    if (inp[i] == inp[j])
							{
							     System.out.println(inp[j]);
							     cnt++;
							     break;
						    }
				     }
		     }
	   } 
 }

//====[Output]===========================================
//


//Updates are done.


