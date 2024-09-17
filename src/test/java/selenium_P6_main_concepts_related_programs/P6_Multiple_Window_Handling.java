package selenium_P6_main_concepts_related_programs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Set;

public class P6_Multiple_Window_Handling
{
        public static void main(String[] args)
        {
            // Set up the WebDriver (Chrome in this case)
            System.setProperty("web driver.chrome.driver", "path/to/chromedriver");
            WebDriver driver = new ChromeDriver();

            // Open the first window (main window)
            driver.get("https://www.example.com"); // Replace with your URL

            // Store the main window handle
            String mainWindowHandle = driver.getWindowHandle();
            System.out.println("Main Window Handle: " + mainWindowHandle);

            // By Clicking on the Tab (Or) Link, it will Open the second window
            driver.findElement(By.xpath("//a[@target='_blank']")).click(); // Example for opening a new window/tab

            // By Clicking on the Tab (Or) Link, it will Open the third window
            driver.findElement(By.xpath("//a[@target='_blank']")).click();

            // Get all open window handles
            Set<String> allWindowHandles = driver.getWindowHandles();
            String secondWindowHandle = null;
            String thirdWindowHandle = null;

            // Switch to the second window (find it in the window handles)
            for (String windowHandle : allWindowHandles)
            {
                if (!windowHandle.equals(mainWindowHandle))
                {
                    driver.switchTo().window(windowHandle);
                    System.out.println("Switched to Window: " + windowHandle);
                    secondWindowHandle = windowHandle;  //Here "Second Window Handle Stored into the "secondWindowHandle".
                    break;
                }
            }

            // Perform operations in the second window
            driver.get("https://www.second-example.com"); // Open URL in second window

            // Now switch to the third window
            allWindowHandles = driver.getWindowHandles(); // Get updated window handles
            for (String windowHandle : allWindowHandles)
            {
                if (!windowHandle.equals(mainWindowHandle) && !windowHandle.equals(secondWindowHandle))
                {
                    driver.switchTo().window(windowHandle);
                    System.out.println("Switched to Window: " + windowHandle);
                    thirdWindowHandle = windowHandle;
                    break;
                }
            }

            // Perform operations in the third window
            driver.get("https://www.third-example.com"); // Open URL in third window

            // Finally, switch back to the second window
            driver.switchTo().window(secondWindowHandle);
            System.out.println("Switched back to the Second Window: " + secondWindowHandle);

            // Perform any final actions in the second window if needed

            // Close all windows
            driver.quit();
        }
    }
