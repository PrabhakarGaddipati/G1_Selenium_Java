package java_01_programs_on_strings;

import java.util.Scanner;

public class P1_Palindrome_with_String 
{
	public static void main(String[] args) 
	{       
        Scanner scanner = new Scanner(System.in);       
        System.out.println("Enter any text:");
        
        String orginalText = scanner.nextLine();
        char[] ca = orginalText.toCharArray();        
        
        String reversedText = "";
                            
         for(int i=ca.length-1;i>=0;i--)
         {              
                reversedText = reversedText + ca[i];          
         }
        
         if(orginalText.equals(reversedText)) 
         {               
            System.out.println("Given Text is a palindrome");               
         } 
         else 
         {               
            System.out.println("Given Text is not a palindrome");              
         }       
         scanner.close();
        
 }
}

//====[Output]===========================================
//


//Code Link: https://www.evernote.com/shard/s433/client/snv?noteGuid=5ba15dba-1c80-4c98-b6c9-f972a1055a70&noteKey=723893f7ff2c882e&sn=https%3A%2F%2Fwww.evernote.com%2Fshard%2Fs433%2Fsh%2F5ba15dba-1c80-4c98-b6c9-f972a1055a70%2F723893f7ff2c882e&title=27.%2BJava%2Bprogram%2Bto%2Bcheck%2Bwhether%2Bthe%2Bgiven%2BString%2Btext%2Bis%2Ba%2BPalindrome
//Video Link: https://www.youtube.com/watch?v=dyDBv2QIO2U&list=PLsjUcU8CQXGGX_f8J-72CS8ikTjl-6qKJ&index=27&ab_channel=QAFox

