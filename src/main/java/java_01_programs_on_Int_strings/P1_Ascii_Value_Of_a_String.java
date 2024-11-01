package java_01_programs_on_Int_strings;

import java.util.Scanner;

public class P1_Ascii_Value_Of_a_String
{
public static void main(String args[])
{
    String name = "wDataOne";

    for (int i = 0; i < name.length(); i++)
    {
        int c1 = name.charAt(i);
        int s1 = (int) c1;
        System.out.println("Value" + s1);
    }
  }
}

// Good Programing Logic - Understand
