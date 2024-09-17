package java_03_programs_on_collections;

public class Temp
{
    public static void main(String args[])
    {
        String s1 = "DataMachine";
        char[] c1 = s1.toCharArray();

        for (char c : c1)
        {
            System.out.print(c);
        }

        System.out.println("  "); //  Print   the current         state   of the  temporary       directory

        for (int i = c1.length - 1; i >= 0; i--)
        {
            //System.out.println("-----");
            System.out.print(c1[i]);
           // System.out.p
        }
    }

}

//Output:

