package CoreJava.Programs;

public class P1_Count_Total_Number_Of_Words_In_String 
{
	public static void main(String[] args)
	  { 
		//return the number of words in a string         
		String example = "This is a good exercise"; 
		int length = example.split(" ").length;  //split string based on whitespace & //split returns array - find legth of array    

		System.out.println("The String Contais:" + length + " Words");

	  }	
}


//====[Output]===========================================
//The String Contais:5 Words


//Taken the Code from below link, it may help full
//Link:https://www.codegrepper.com/code-examples/java/count+the+number+of+words+in+a+string+java