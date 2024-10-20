package selenium_06_main_concepts_related_programs;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

// Note: below Program - is for below
//1. Create a Screenshot Utility
//2. In Selenium, you can take screenshots at different points in time and across various classes to capture the state of your web application
// during test execution. To achieve this, you can use TakesScreenshot in combination with time-based filenames and
// organize your screenshots by class or test case. Below is a step-by-step guide on how to take screenshots with different timelines and classes in Selenium using Java.
public class P6_Screenshot_And_Related_Code
{
    // Method to take a screenshot with timestamp, class name, and method name
    public static void takeScreenshot(WebDriver driver, String className, String methodName)
    {
        // Create timestamp format for screenshot filenames
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        // Cast driver object to TakesScreenshot
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        // Set the destination for the screenshot (organized by class name, method name, and timestamp)
        String dest = "./screenshots/" + className + "_" + methodName + "_" + timestamp + ".png";

        try {
            // Copy the screenshot to the specified location
            FileUtils.copyFile(source, new File(dest));
            System.out.println("Screenshot taken: " + dest);
        } catch (IOException e) {
            System.out.println("Exception while taking screenshot: " + e.getMessage());
        }
    }
}

/*
2. Capture Method Name Dynamically in Test Classes
You can pass both the class name and method name to the takeScreenshot method inside your test methods.
TestNG’s ITestResult allows you to dynamically capture the test method name.
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExampleTest
{
    WebDriver driver;

    @BeforeMethod
    public void setup()
    {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://example.com");
    }

    @Test
    public void testExample()
    {
        // Perform actions on the page
        // Example: driver.findElement(...).click();
    }

    @Test
    public void anotherTestExample()
    {
        // Another test case logic here
    }

    @AfterMethod
    public void tearDown(ITestResult result)
    {
        // Capture screenshot after every test method
        String className = this.getClass().getSimpleName(); // Gets the current class name
        String methodName = result.getMethod().getMethodName(); // Gets the current test method name

        // Take screenshot with class name and method name
        ScreenshotUtil.takeScreenshot(driver, className, methodName);

        // Quit the browser after test
        driver.quit();
    }
}

//3.Example Screenshot Naming Structure: (below)
//./screenshots/ExampleTest_testExample_20241019_101500.png
//./screenshots/ExampleTest_anotherTestExample_20241019_101600.png

//----------------------------------------------------------------------------------------------------------------
//4. Optional: Capture Screenshots Only on Failure

        @AfterMethod
        public void tearDown(ITestResult result)
        {
            if (result.getStatus() == ITestResult.FAILURE)
            {
                String className = this.getClass().getSimpleName();
                String methodName = result.getMethod().getMethodName();

                // Take screenshot only when the test fails
                ScreenshotUtil.takeScreenshot(driver, className, methodName);    // This line is Important
            }
            driver.quit();
        }
