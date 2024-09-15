package selenium_utilities;

public class Strings_Count_Of_UpperCase_LowerCase_P1
{
    public static void main(String[] args) 
    {
        String input = "Hello World! This is a Java Program.";
        
        // Declared Variables, to hold the count of uppercase and lowercase letters
        int upperCaseCount = 0;
        int lowerCaseCount = 0;

        for (int i = 0; i < input.length(); i++) 
        {
            char ch = input.charAt(i);

            // Check if the character is an uppercase letter
            if (Character.isUpperCase(ch))
            {
                upperCaseCount++;
            }
            // Check if the character is a lowercase letter
            else if (Character.isLowerCase(ch)) {
                lowerCaseCount++;
            }
        }

        // Display the counts
        System.out.println("Uppercase letters: " + upperCaseCount);
        System.out.println("Lowercase letters: " + lowerCaseCount);
    }
}


