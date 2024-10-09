package selenium_09_restassured_related;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

class Employees {
    private String name;
    private int rollNumber;
    private String phoneNumber;

    // Constructor
    public Employees(String name, int rollNumber, String phoneNumber)
    {
        this.name = name;
        this.rollNumber = rollNumber;
        this.phoneNumber = phoneNumber;
    }

    // Getters and Setters (optional, depending on your need)
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getRollNumber()
    {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber)
    {
        this.rollNumber = rollNumber;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }
}

public class POJO_to_JSON {
    public static void main(String[] args) {
        // Create ObjectMapper instance
        ObjectMapper mapper = new ObjectMapper();

        List<Employees> employeeList = new ArrayList<>();
        Employees e1 = new Employees("AAA", 111, "3333333333");
        employeeList.add(e1);

        Employees e2 = new Employees("BBB", 101, "9999999999");
        employeeList.add(e2);

        try
        {
            // Convert list of employees to a pretty-printed JSON string
            String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(employeeList);

            // Print pretty-printed JSON string
            System.out.println(jsonString);

        } catch (JsonProcessingException e)
        {
            e.printStackTrace();
        }
    }
}

