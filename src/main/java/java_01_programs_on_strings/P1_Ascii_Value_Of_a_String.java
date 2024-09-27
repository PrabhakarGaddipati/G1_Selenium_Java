package java_01_programs_on_strings;

import java.util.Scanner;

public class P1_Ascii_Value_Of_a_String
{
    public static void main(String[] args)
    {
        // Create a Scanner object to take input from user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        for (int i = 0; i < input.length(); i++)
        {
            char character = input.charAt(i);   // Get each character
            System.out.println("Testing"+character);
            int asciiValue = (int) character;   // Convert character to ASCII value

            System.out.println("Value:" + asciiValue);
        }

        // Close the scanner object.
        scanner.close();
    }
}
