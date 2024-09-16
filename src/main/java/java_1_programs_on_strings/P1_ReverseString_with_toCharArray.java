package java_1_programs_on_strings;


public class P1_ReverseString_with_toCharArray 
{
	public static void main(String[] args) 
	{
       
        String str = "Arun Motoori";
        String reversedStr="";         
        char[] ca = str.toCharArray();
        
         for(int i=ca.length-1; i>=0; i--)
         {              
            reversedStr += ca[i];              
         }

        System.out.println(reversedStr);

 }
}

//====[Output]===========================================
//irootoM nurA


//Note: In java string "toCharArray()" method converts the given string into a sequence of characters. 
//Video Explanation Link: https://www.youtube.com/watch?v=Zk2giJu0MMY&list=PLsjUcU8CQXGGX_f8J-72CS8ikTjl-6qKJ&index=26&ab_channel=QAFox

