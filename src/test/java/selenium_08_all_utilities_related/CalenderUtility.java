package selenium_08_all_utilities_related;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class CalenderUtility {

    WebDriver driver; // Assuming WebDriver is already initialized elsewhere in your test setup

    @Test
    public void testSelectTodayDate() {
        // Define the locators for the calendar button and the date elements in the date picker
        By calendarButtonLocator = By.id("calendarButton_id");  // Replace with actual locator
        By datePickerLocator = By.xpath("//td[contains(@class, 'day')]");  // Replace with actual XPath

        // Call the CalendarHandler method to select today's date
        CalendarHandler.selectTodayDate(driver, calendarButtonLocator, datePickerLocator);
    }



    public class CalendarHandler
    {
        // Method to select today's date in the calendar
        public static void selectTodayDate(WebDriver driver, By calendarButtonLocator, By datePickerLocator) {
            // Click on the calendar button to open the date picker
            WebElement calendarButton = driver.findElement(calendarButtonLocator);
            calendarButton.click();

            // Get today's date
            LocalDate today = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d");
            String todayDate = today.format(formatter);

            // Locate the date picker where the dates are displayed (change this XPath if needed)
            List<WebElement> allDates = driver.findElements(datePickerLocator);

            // Loop through the dates and select today's date
            for (WebElement dateElement : allDates) {
                if (dateElement.getText().equals(todayDate)) {
                    dateElement.click();
                    break;
                }
            }
        }
    }