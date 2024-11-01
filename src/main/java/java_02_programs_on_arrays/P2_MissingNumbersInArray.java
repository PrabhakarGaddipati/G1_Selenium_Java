package java_02_programs_on_arrays;

import java.util.HashSet;

public class P2_MissingNumbersInArray
{
    public static void findMissingNumbers(int[] arr, int rangeStart, int rangeEnd)
    {
        HashSet<Integer> numbersSet = new HashSet<Integer>();
        for (int num : arr)
        {
            numbersSet.add(num);
        }

        // Step 2: Check for missing numbers in the specified range
        System.out.println("Missing numbers in the range " + rangeStart + " to " + rangeEnd + " are:");
        for (int i = rangeStart; i <= rangeEnd; i++)
        {
            if (!numbersSet.contains(i))
            {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args)
    {
        int[] array = {1, 3, 5, 6, 8, 9};  // Example input array
        int rangeStart = 1;
        int rangeEnd = 10;  // Define the range

        // Calling the method to find missing numbers
        findMissingNumbers(array, rangeStart, rangeEnd);
    }
}

//-------------------------------------------------------------------------------------------------
//Good Program ....

/*
OutPut:
------------
Missing numbers in the range 1 to 10 are:
2 4 7 10
 */