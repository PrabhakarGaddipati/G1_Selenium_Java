package CoreJava.Programs;

import java.util.HashMap;
import java.util.Map;


public class Temp
{
    public static void main(String[] args)
    {
        String str = "Apple";
        Map<Character, Integer> m1 = new HashMap<>();
        char[] c1 = str.toCharArray();

        System.out.println("Values are:" + str);
        System.out.println();
    }
}