package selenium_08_all_utilities_related;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.testng.Assert;

public class DatabaseUtility {

    private static Connection connection;

    // Method 1: Database Connectivity
    public static Connection connectToDatabase() {
        try {
            // Oracle Database URL, username, and password (update with your details)
            String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
            String username = "your_db_username";
            String password = "your_db_password";

            // Load Oracle JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Create the connection to the database
            connection = DriverManager.getConnection(dbURL, username, password);
            System.out.println("Connected to Oracle database successfully!");

        } catch (Exception e) {
            System.out.println("Error while connecting to Oracle database: " + e.getMessage());
        }
        return connection;
    }

    // Method 2: Data Validation Method
    public static boolean validateDataInDatabase(String query, String expectedValue) {
        boolean isDataPresent = false;
        try {
            // Create statement and execute query
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            // Iterate through result set and validate
            while (resultSet.next()) {
                String retrievedData = resultSet.getString(1); // assuming the value to validate is in the first column
                System.out.println("Retrieved Data: " + retrievedData);

                // Assert to check if the retrieved data matches the expected value
                Assert.assertEquals(retrievedData, expectedValue, "Data validation failed!");
                isDataPresent = true;
            }
        } catch (Exception e) {
            System.out.println("Error during data validation: " + e.getMessage());
        }
        return isDataPresent;
    }
}

//Now, we'll create a TestNG test class that uses the DatabaseUtility class.

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utility.DatabaseUtility;
import java.sql.Connection;

public class CDMDatabaseTest {

    Connection connection;

    @BeforeClass
    public void setUp() {
        // Establish the Oracle database connection before the test
        connection = DatabaseUtility.connectToDatabase();
    }

    @Test
    public void testDatabaseInsertValidation() {
        // Selenium operations for inserting/submitting data (Assuming you've done this)

        // Database query to validate data
        String query = "SELECT column_name FROM table_name WHERE condition_column = 'your_condition'";
        String expectedValue = "Expected Data"; // Replace with the value you're validating

        // Call the database utility method to validate data
        boolean isDataValid = DatabaseUtility.validateDataInDatabase(query, expectedValue);

        // Assert to verify data is present in the database
        assert isDataValid : "Data was not found or validated successfully!";
    }

    @AfterClass
    public void tearDown() {
        try {
            // Close the database connection
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            System.out.println("Error while closing the database connection: " + e.getMessage());
        }
    }
}
