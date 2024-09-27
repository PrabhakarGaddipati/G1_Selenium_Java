import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainCalendarTest
{
    public static void main(String[] args)
    {
        // Initialize WebDriver
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        // Open the web application
        driver.get("https://example.com");

        // Define the XPath for the calendar input, date picker, and date elements
        String calendarInputXpath = "//input[@id='calendar']";  // Example XPath for the calendar input element
        String datePickerXpath = "//div[@class='datepicker']";  // Example XPath for the date picker window
        String dateXpath = "//td[contains(@class, 'day')]";     // XPath for the date cells in the picker

        // Call the CalendarUtility method to handle calendar interaction
        CalendarUtility.CalendarMethodHandling(driver, calendarInputXpath, datePickerXpath, dateXpath);

        // Close the browser after operation
        driver.quit();
    }
}
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CalendarUtility
{

    // Method to handle calendar selection dynamically
    public static void CalendarMethodHandling(WebDriver driver, String calendarInputXpath, String datePickerXpath, String dateXpath)
    {
        try
        {
            // Step 1: Click the calendar input to open the date picker
            WebElement calendarInput = driver.findElement(By.xpath(calendarInputXpath));
            calendarInput.click();

            // Step 2: Wait for the date picker window to be displayed
            WebElement datePicker = driver.findElement(By.xpath(datePickerXpath));
            if (!datePicker.isDisplayed())
            {
                throw new RuntimeException("Date picker window did not open as expected");
            }

            // Step 3: Get today's date dynamically from the system
            String todayDay = getTodayDate();

            // Step 4: Select today's date from the date picker using the dateXpath parameter and the day
            // XPath locator is constructed dynamically by appending today's day to the dateXpath
            WebElement dateElement = driver.findElement(By.xpath(dateXpath + "[text()='" + todayDay + "']"));
            dateElement.click();

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    // Helper method to return the current system date (day only) as a string
    private static String getTodayDate()
    {
        LocalDate today = LocalDate.now(); // Get today's date
        DateTimeFormatter dayFormatter = DateTimeFormatter.ofPattern("d"); // Format for day only
        return today.format(dayFormatter); // Return today's day as a string
    }
}

/////////////////////////////////////// [ Need to Add New Methods ] ////////////////////////////////////////////////////

