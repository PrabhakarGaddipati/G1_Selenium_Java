package selenium_P8_all_utilities_related;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

public class P8_Assertions_Utility
{
    private WebDriver driver;

    // Constructor to initialize WebDriver
    public AssertionUtils(WebDriver driver)
    {
        this.driver = driver;
    }

    // Helper method to wait until the element is visible (you can implement it as per your framework)
    public static void waitForVisible(WebElement element)
    {
        // Code to wait until element is visible (can be WebDriverWait or FluentWait)
    }

    // 1. Assert if the element's text contains the expected text
    public static void assertEquals(WebElement element, String expected) {
        waitForVisible(element);
        String actual = element.getText();
        Assert.assertTrue(
                String.format("Actual text is '%s' but expected text is '%s'", actual, expected),
                actual.contains(expected)
        );
    }

    // 2. Assert if the actual text matches the expected text
    public static void assertEquals(String actual, String expected) {
        Assert.assertEquals(
                String.format("Actual text is '%s' but expected text is '%s'", actual, expected),
                actual, expected
        );
    }

    // 3. Assert if the element's text contains the expected text (with element in parameter)
    public static void assertElementTextContains(WebElement element, String expected)
    {
        waitForVisible(element);
        String actual = element.getText();
        Assert.assertTrue(
                String.format("Actual text is '%s' but expected text contains '%s'", actual, expected),
                actual.contains(expected)
        );
    }

    // 4. Assert if the element is displayed (visible on the page)
    public static void assertElementVisible(WebElement element) {
        waitForVisible(element);
        Assert.assertTrue("Element is not visible, but it should be", element.isDisplayed());
    }

    // 5. Assert if the element is enabled (interactive)
    public static void assertElementEnabled(WebElement element) {
        waitForVisible(element);
        Assert.assertTrue("Element is not enabled, but it should be", element.isEnabled());
    }

    // 6. Assert the page title contains the expected title
    public void assertPageTitleContains(String expected) {
        String actualTitle = driver.getTitle();
        Assert.assertTrue(
                String.format("Actual page title is '%s', but expected title contains '%s'", actualTitle, expected),
                actualTitle.contains(expected)
        );
    }

    // 7. Assert if the element contains a specific attribute value
    public static void assertElementAttributeContains(WebElement element, String attribute, String expectedValue) {
        waitForVisible(element);
        String actualValue = element.getAttribute(attribute);
        Assert.assertTrue(
                String.format("Attribute '%s' value is '%s', but expected value contains '%s'", attribute, actualValue, expectedValue),
                actualValue.contains(expectedValue)
        );
    }

    // 8. Assert if the element's text matches the expected text exactly
    public static void assertElementTextEquals(WebElement element, String expected) {
        waitForVisible(element);
        String actual = element.getText();
        Assert.assertEquals(
                String.format("Actual text is '%s' but expected text is '%s'", actual, expected),
                actual, expected
        );
    }

    // 9. Assert if the current URL contains the expected URL fragment
    public void assertCurrentUrlContains(String expectedUrlFragment) {
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(
                String.format("Actual URL is '%s', but expected URL contains '%s'", actualUrl, expectedUrlFragment),
                actualUrl.contains(expectedUrlFragment)
        );
    }

    // 10. Assert if the element is selected (for checkboxes, radio buttons, etc.)
    public static void assertElementSelected(WebElement element) {
        waitForVisible(element);
        Assert.assertTrue("Element is not selected, but it should be", element.isSelected());
    }

    // 11. Assert if the actual value matches the expected value (for numerical checks, etc.)
    public static void assertEquals(int actual, int expected) {
        Assert.assertEquals(
                String.format("Actual value is %d but expected value is %d", actual, expected),
                actual, expected
        );
    }

    // 12. Assert if the element's CSS property contains the expected value
    public static void assertElementCssValue(WebElement element, String property, String expectedValue) {
        waitForVisible(element);
        String actualValue = element.getCssValue(property);
        Assert.assertTrue(
                String.format("CSS property '%s' is '%s', but expected '%s'", property, actualValue, expectedValue),
                actualValue.contains(expectedValue)
        );
    }
}

