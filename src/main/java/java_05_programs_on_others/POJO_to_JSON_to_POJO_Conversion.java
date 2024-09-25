package java_05_programs_on_others;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.ArrayList;
import java.util.List;

public class POJO_to_JSON_to_POJO_Conversion
{
    public static void main(String[] args)
    {
        ObjectMapper mapper = new ObjectMapper();

        List<Employees> employeeList = new ArrayList<>();
        Employees e1 = new Employees("AAA", 111, "3333333333");
        employeeList.add(e1);

        Employees e2 = new Employees("BBB", 101, "9999999999");
        employeeList.add(e2);

        try
        {
            // Convert list of employees to a pretty-printed JSON string (POJO to JSON)
            String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(employeeList);
            System.out.println("POJO to JSON (Pretty Format):\n" + jsonString);

            // Convert the JSON string back to a list of Employees objects (JSON to POJO)
            List<Employees> employeeListFromJson = mapper.readValue(jsonString, new TypeReference<List<Employees>>() {});

            for (Employees emp : employeeListFromJson)
            {
                System.out.println(emp);
            }

        } catch (JsonProcessingException e)
        {
            e.printStackTrace();
        }
    }
}


class Employee
{
    private String name;
    private int rollNumber;
    private String phoneNumber;

    // Constructor
   public Employee()
   {
       // Default constructor for JSON-to-POJO conversion
   }

    public Employee(String name, int rollNumber, String phoneNumber)
    {
        this.name = name;
        this.rollNumber = rollNumber;
        this.phoneNumber = phoneNumber;
    }

    // Getters and Setters
    public String getName()
    {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString()
    {
        return "Employees [Name=" + name + ", " +
                                      "Roll Number=" + rollNumber + ", " +
                                       "Phone Number=" + phoneNumber + "]";
    }
}


