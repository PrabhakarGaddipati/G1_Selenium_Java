package selenium_08_all_utilities_related;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

public class P8_Common_Methods
{
    private static final Logger logger = LogManager.getLogger(P8_Common_Methods.class);

    // ==============================
    // Element Interaction Methods
    // ==============================

     // 1. Enters text into an input field.
    public void enterText(WebDriver driver, By locator, String text, Duration timeout)
    {
        try
        {
            WebElement element = waitForElementToBeVisible(driver, locator, timeout);
            element.clear();
            element.sendKeys(text);
            logger.info("Entered text into element: {}", locator);
        }
        catch (Exception e)
        {
            logger.error("Failed to enter text in the element: {}", locator, e);
        }
    }

    // 2. Click on a button element (with JavaScript fallback)
    public void clickButton(WebDriver driver, By locator, Duration timeout)
    {
        try
        {
            WebElement button = waitForElementToBeClickable(driver, locator, timeout);
            button.click();
            logger.info("Button clicked successfully using Selenium click: {}", locator);
        }
        catch (Exception e)
        {
              logger.warn("Selenium click failed, attempting JavaScript click for: {}", locator);
            try
            {
                WebElement button = driver.findElement(locator);
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", button);
                logger.info("Button clicked successfully using JavaScript click: {}", locator);
            }
            catch (Exception jsException)
            {
                logger.error("JavaScript click also failed for element: {}", locator, jsException);
            }
                logger.error("Selenium click failed for element: {}", locator, e);
        }
    }

    // 3. Select a value from a dropdown element by visible text
    public void selectFromDropdown(WebDriver driver, By locator, String value, Duration timeout)
    {
        try
        {
            WebElement dropdownElement = waitForElementToBeVisible(driver, locator, timeout);

            Select dropdown = new Select(dropdownElement);
            dropdown.selectByVisibleText(value);
            logger.info("Selected value '{}' from dropdown: {}", value, locator);
        }
        catch (Exception e)
        {
            logger.error("Failed to select from dropdown: {}", locator, e);
        }
    }

    // 4. Submit a form
    public void submitForm(WebDriver driver, By locator)
    {
        try
        {
            WebElement form = driver.findElement(locator);
            form.submit();
            logger.info("Form submitted: {}", locator);
        }
        catch (Exception e)
        {
            logger.error("Failed to submit form: {}", locator, e);
        }
    }

    // 5. Drag and drop an element
    public void dragAndDrop(WebDriver driver, By sourceLocator, By targetLocator, Duration timeout)
    {
        try
        {
            WebElement source = waitForElementToBeVisible(driver, sourceLocator, timeout);
            WebElement target = waitForElementToBeVisible(driver, targetLocator, timeout);

            Actions actions = new Actions(driver);
            actions.dragAndDrop(source, target).perform();
            logger.info("Dragged and dropped from {} to {}", sourceLocator, targetLocator);
        }
        catch (Exception e)
        {
            logger.error("Failed to drag and drop from {} to {}", sourceLocator, targetLocator, e);
        }
    }

    // 6. Double-click an element
    public void doubleClick(WebDriver driver, By locator, Duration timeout)
    {
        try
        {
            WebElement element = waitForElementToBeVisible(driver, locator, timeout);

            Actions actions = new Actions(driver);
            actions.doubleClick(element).perform();
            logger.info("Double-clicked on element: {}", locator);
        }
        catch (Exception e)
        {
            logger.error("Failed to double-click on element: {}", locator, e);
        }
    }

    // 7. Right-click an element
    public void rightClick(WebDriver driver, By locator, Duration timeout)
    {
        try
        {
            WebElement element = waitForElementToBeVisible(driver, locator, timeout);

            Actions actions = new Actions(driver);
            actions.contextClick(element).perform();
            logger.info("Right-clicked on element: {}", locator);
        }
        catch (Exception e)
        {
            logger.error("Failed to right-click on element: {}", locator, e);
        }
    }

    // =================================
    // Alert and Pop-up Handling Methods
    // =================================

    // 8. Accept browser alerts
    public void handleAlert(WebDriver driver)
    {
        try
        {
            Alert alert = driver.switchTo().alert();
            alert.accept();
            logger.info("Accepted alert.");
        }
        catch (NoAlertPresentException e)
        {
            logger.warn("No alert found to accept.");
        }
        catch (Exception e)
        {
            logger.error("Failed to handle alert.", e);
        }
    }

    // 9. Handle JavaScript alerts (accept or dismiss based on input)
    public void handleJavaScriptAlert(WebDriver driver, boolean accept)
    {
        try
        {
            Alert alert = driver.switchTo().alert();
            if (accept)
            {
                alert.accept();
                logger.info("Accepted JavaScript alert.");
            }
            else
            {
                alert.dismiss();
                logger.info("Dismissed JavaScript alert.");
            }
        }
        catch (NoAlertPresentException e)
        {
            logger.warn("No JavaScript alert found.");
        }
        catch (Exception e)
        {
            logger.error("Failed to handle JavaScript alert.", e);
        }
    }

    // 10. Dismiss browser alerts
    public void dismissAlert(WebDriver driver)
    {
        try
        {
            Alert alert = driver.switchTo().alert();
            alert.dismiss();
            logger.info("Dismissed alert.");
        }
        catch (NoAlertPresentException e)
        {
            logger.warn("No alert found to dismiss.");
        }
        catch (Exception e)
        {
            logger.error("Failed to dismiss alert.", e);
        }
    }

    // 11. Get text from browser alerts
    public String getAlertText(WebDriver driver)
    {
        try
        {
            Alert alert = driver.switchTo().alert();
            return alert.getText();
        }
        catch (NoAlertPresentException e)
        {
            System.err.println("No alert present to get text from.");
            e.printStackTrace();
            return null;
        }
    }

    // ==================================
    // Frame and Window Handling Methods
    // ==================================

    // 12. Switch to a specific frame by locator
    public void switchToFrame(WebDriver driver, By frameLocator)
    {
        try
        {
            WebElement frame = driver.findElement(frameLocator);
            driver.switchTo().frame(frame);
            logger.info("Switched to frame: {}", frameLocator);
        }
        catch (Exception e)
        {
            logger.error("Failed to switch to frame: {}", frameLocator, e);
        }
    }

    // 13. Switch back to the main page (default content)
    public void switchToDefaultContent(WebDriver driver)
    {
        try
        {
            driver.switchTo().defaultContent();
            logger.info("Switched to default content.");
        } catch (Exception e)
        {
            logger.error("Failed to switch to default content.", e);
        }
    }

    // 14. Method to switch to a specific window based on title
    public void switchToWindow(WebDriver driver, String windowTitle)
    {
        try
        {
            String mainWindowHandle = driver.getWindowHandle();
            Set<String> allWindowHandles = driver.getWindowHandles();

            for (String handle : allWindowHandles)
            {
                driver.switchTo().window(handle);
                if (driver.getTitle().equals(windowTitle))
                {
                    logger.info("Switched to window with title: {}", windowTitle);
                    return; // Exit once the target window is found and switched to
                }
            }
            // If window with the desired title is not found, log the failure
            logger.warn("No window found with title: {}", windowTitle);
        }
        catch (NoSuchWindowException e)
        {
            logger.error("Failed to switch to window. No such window found with title: {}", windowTitle, e);
        }
        catch (Exception e)
        {
            logger.error("Unexpected error while switching to window with title: {}", windowTitle, e);
        }
    }


    // Gets the current window handle.
    public String getCurrentWindowHandle(WebDriver driver)
    {
        String handle = driver.getWindowHandle();
        logger.info("Current window handle: {}", handle);
        return handle;
    }

    // Gets all window handles.
    public Set<String> getAllWindowHandles(WebDriver driver)
    {
        Set<String> handles = driver.getWindowHandles();
        logger.info("All window handles: {}", handles);
        return handles;
    }

    // 15. Close the current window
    public void closeWindow(WebDriver driver)
    {
        try
        {
            driver.close();
        } catch (Exception e)
        {
            System.err.println("Failed to close the window.");
            e.printStackTrace();
        }
    }

    // 16. Switch to parent window ----------------------------------------------------------------------???? (Need too Add some more methods, here...
    public void switchToParentWindow(WebDriver driver)
    {
        try
        {
            String parentWindow = driver.getWindowHandle();
            driver.switchTo().window(parentWindow);
        }
        catch (Exception e)
        {
            System.err.println("Failed to switch to parent window.");
            e.printStackTrace();
        }
    }

    // ==============================
    // JavaScript Interaction Methods
    // ==============================

    // 17. Execute JavaScript in the browser
    public void executeJavaScript(WebDriver driver, String script) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript(script);
        } catch (Exception e) {
            System.err.println("Failed to execute JavaScript.");
            e.printStackTrace();
        }
    }

    // 18. Scroll to a specific element using JavaScript
    public void scrollToElement(WebDriver driver, By locator) {
        try {
            WebElement element = waitForElementToBeVisible(driver, locator, 10);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        } catch (Exception e) {
            System.err.println("Failed to scroll to element: " + locator);
            e.printStackTrace();
        }
    }

    // ==============================
    // JavaScript Interaction Methods
    // ==============================

    // 19. Click an element using JavaScript
    public void clickUsingJavaScript(WebDriver driver, By locator) {
        try {
            WebElement element = waitForElementToBeVisible(driver, locator, 10);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            System.err.println("Failed to click element using JavaScript: " + locator);
            e.printStackTrace();
        }
    }

    // 20. Scroll to a specific element using JavaScript
    public void scrollToElement(WebDriver driver, By locator) {
        try {
            WebElement element = waitForElementToBeVisible(driver, locator, 10);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        } catch (Exception e) {
            System.err.println("Failed to scroll to element: " + locator);
            e.printStackTrace();
        }
    }

    // 21. Get the title of the current page using JavaScript
    public String getPageTitleUsingJavaScript(WebDriver driver) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            return js.executeScript("return document.title;").toString();
        } catch (Exception e) {
            System.err.println("Failed to retrieve page title using JavaScript.");
            e.printStackTrace();
            return null;
        }
    }

    // 22. Refresh the browser using JavaScript
    public void refreshBrowserUsingJavaScript(WebDriver driver) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("history.go(0);");
        } catch (Exception e) {
            System.err.println("Failed to refresh the browser using JavaScript.");
            e.printStackTrace();
        }
    }

    // 23. Scroll to the bottom of the page using JavaScript
    public void scrollToBottomOfPage(WebDriver driver) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        } catch (Exception e) {
            System.err.println("Failed to scroll to the bottom of the page.");
            e.printStackTrace();
        }
    }

    // 24. Highlight an element using JavaScript
    public void highlightElement(WebDriver driver, By locator)
    {
        try
        {
            WebElement element = waitForElementToBeVisible(driver, locator, 10);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].style.border='3px solid red'", element);
        }
        catch (Exception e)
        {
            System.err.println("Failed to highlight element: " + locator);
            e.printStackTrace();
        }
    }

    // 25. Get an element's inner text using JavaScript
    public String getInnerTextUsingJavaScript(WebDriver driver, By locator)
    {
        try
        {
            WebElement element = waitForElementToBeVisible(driver, locator, 10);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            return js.executeScript("return arguments[0].innerText;", element).toString();
        }
        catch (Exception e)
        {
            System.err.println("Failed to retrieve inner text using JavaScript for element: " + locator);
            e.printStackTrace();
            return null;
        }
    }

    // 26. Disable a button using JavaScript
    public void disableButtonUsingJavaScript(WebDriver driver, By locator) {
        try {
            WebElement button = waitForElementToBeVisible(driver, locator, 10);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].disabled = true;", button);
        } catch (Exception e) {
            System.err.println("Failed to disable button using JavaScript for element: " + locator);
            e.printStackTrace();
        }
    }

    // ==============================
    // Utility Methods
    // ==============================

    // 27. Wait for element to be visible
    public WebElement waitForElementToBeVisible(WebDriver driver, By locator, int timeout)
    {
        try
        {
            logger.info("Waiting for element to be visible: {}", locator);
            return new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.visibilityOfElementLocated(locator));
        }
        catch (NoSuchElementException | TimeoutException e)
        {
            logger.error("Exception occurred while waiting for element to be visible: {}", locator, e);
            throw e;  // Re-throw the exception to signal failure
        }
        catch (Exception e)
        {
            logger.error("An unexpected error occurred while waiting for element to be visible: {}", locator, e);
            throw e;  // Re-throw the exception to signal failure
        }
    }

    // 28. Wait for element to be clickable
    public WebElement waitForElementToBeClickable(WebDriver driver, By locator, int timeout)
    {
        try
        {
            logger.info("Waiting for element to be clickable: {}", locator);
            return new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.elementToBeClickable(locator));
        }
        catch (NoSuchElementException | TimeoutException e)
        {
            logger.error("Exception occurred while waiting for element to be clickable: {}", locator, e);
            throw e;  // Re-throw the exception to signal failure
        }
        catch (Exception e)
        {
            logger.error("An unexpected error occurred while waiting for element to be clickable: {}", locator, e);
            throw e;  // Re-throw the exception to signal failure
        }
    }

    /**
     * 29. data from an Excel file.
     * @param filePath  the path to the Excel file
     * @param sheetName the name of the sheet to read data from
     * @param row       the row number from which to read data (0-based index)
     * @param col       the column number from which to read data (0-based index)
     * @return the cell data as a String
     * @throws IOException              if there is an error reading the file
     * @throws IllegalArgumentException if the specified sheet, row, or column does not exist
     */
    public String readExcelData(String filePath, String sheetName, int row, int col) throws IOException
    {
        FileInputStream fis = null;
        Workbook workbook = null;
        String cellData = null;

        try
        {
            fis = new FileInputStream(new File(filePath));
            workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet(sheetName);

            if (sheet == null)
            {
                logger.error("Sheet not found: {}", sheetName);
                throw new IllegalArgumentException("Sheet not found: " + sheetName);
            }

            Row dataRow = sheet.getRow(row);
            if (dataRow == null)
            {
                logger.error("Row not found: {}", row);
                throw new IllegalArgumentException("Row not found: " + row);
            }

            Cell cell = dataRow.getCell(col);
            if (cell == null)
            {
                logger.error("Cell not found at row {} and column {}", row, col);
                throw new IllegalArgumentException("Cell not found at row " + row + " and column " + col);
            }

            cellData = cell.toString();
            logger.info("Successfully read data from Excel: {}", cellData);
        }
        catch (IOException e)
        {
            logger.error("IOException occurred while reading Excel data: {}", e.getMessage());
            throw e;  // Re-throw the exception to signal failure
        }
        catch (Exception e)
        {
            logger.error("An unexpected error occurred while reading Excel data: {}", e.getMessage(), e);
            throw e;  // Re-throw the exception to signal failure
        }
        finally
        {
            if (workbook != null)
            {
                workbook.close();  // Ensure workbook is closed
            }
            if (fis != null) {
                fis.close();  // Ensure file input stream is closed
            }
        }

        return cellData;
    }

    // 30. Capture screenshot and save it to a specific location
    public void captureScreenshot(WebDriver driver, String filePath)
    {
        try
        {
            TakesScreenshot screenshot = (TakesScreenshot) driver;

            File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(srcFile, new File(filePath));
            logger.info("Screenshot saved at: {}", filePath);
        }
        catch (Exception e)
        {
            logger.error("Failed to capture screenshot at: {}", filePath, e);
        }
    }


    // 31. Upload a file using Selenium
    public void uploadFile(WebDriver driver, By locator, String filePath)
    {
        try
        {
            WebElement uploadElement = driver.findElement(locator);
            uploadElement.sendKeys(filePath);
            logger.info("Uploaded file '{}'.", filePath);
        }
        catch (NoSuchElementException e)
        {
            logger.error("Failed to find element to upload file at: {}", locator, e);
        }
        catch (Exception e)
        {
            logger.error("Failed to upload file: {}", filePath, e);
        }
    }

    // 32. Download a file using Selenium (handle download dialog in Chrome)
    public void downloadFile(WebDriver driver, String downloadUrl) {
        try
        {
            driver.get(downloadUrl); // Navigates to the file's download URL
            logger.info("File download initiated for URL: {}", downloadUrl);
        }
        catch (TimeoutException e)
        {
            logger.error("Download page timed out for URL: {}", downloadUrl, e);
        }
        catch (Exception e)
        {
            logger.error("Failed to initiate file download for URL: {}", downloadUrl, e);
        }
    }

    // 33. Switch to a new browser tab/window
    public void switchToNewTab(WebDriver driver)
    {
        try
        {
            for (String handle : driver.getWindowHandles())
            {
                driver.switchTo().window(handle);
            }
            logger.info("Switched to new tab/window.");
        }
        catch (NoSuchWindowException e)
        {
            logger.error("Failed to switch to new tab/window.", e);
        }
        catch (Exception e)
        {
            logger.error("Unexpected error while switching to new tab/window.", e);
        }
    }

    // 34. Switch back to the original tab/window
    public void switchToOriginalTab(WebDriver driver, String originalWindowHandle)
    {
        try
        {
            driver.switchTo().window(originalWindowHandle);
            logger.info("Switched back to the original tab/window.");
        }
        catch (NoSuchWindowException e)
        {
            logger.error("Failed to switch back to original tab/window with handle: {}", originalWindowHandle, e);
        }
        catch (Exception e)
        {
            logger.error("Unexpected error while switching back to the original tab/window.", e);
        }
    }

    // 35. Handle a web-based alert (accept or dismiss)
    public void handleAlert(WebDriver driver, boolean accept) {
        try
        {
            Alert alert = driver.switchTo().alert();
            if (accept)
            {
                alert.accept();
                logger.info("Alert accepted.");
            }
            else
            {
                alert.dismiss();
                logger.info("Alert dismissed.");
            }
        }
        catch (NoAlertPresentException e)
        {
            logger.error("No alert present to handle.", e);
        }
        catch (Exception e)
        {
            logger.error("Failed to handle alert.", e);
        }
    }


    // 36. Handle multiple select options (Select dropdowns)
    public void selectMultipleOptions(WebDriver driver, By locator, List<String> optionsToSelect)
    {
        try
        {
            WebElement element = waitForElementToBeVisible(driver, locator, 10);
            Select select = new Select(element);
            for (String option : optionsToSelect)
            {
                select.selectByVisibleText(option);
            }
            System.out.println("Multiple options selected: " + optionsToSelect);
        } catch (Exception e) {
            System.err.println("Failed to select multiple options: " + optionsToSelect);
            e.printStackTrace();
        }
    }


    // 37. Deselect all options in a multiple select dropdown
    public void deselectAllOptions(WebDriver driver, By locator)
    {
        try
        {
            WebElement element = waitForElementToBeVisible(driver, locator, 10);
            Select select = new Select(element);
            select.deselectAll();
            System.out.println("All options deselected.");
        }
        catch (Exception e)
        {
            System.err.println("Failed to deselect all options.");
            e.printStackTrace();
        }
    }

    // 38. Get all selected options from a multiple select dropdown
    public List<String> getAllSelectedOptions(WebDriver driver, By locator)
    {
        try
        {
            WebElement element = waitForElementToBeVisible(driver, locator, 10);
            Select select = new Select(element);

            List<WebElement> selectedOptions = select.getAllSelectedOptions();
            List<String> selectedTexts = new ArrayList<>();

            for (WebElement option : selectedOptions)
            {
                selectedTexts.add(option.getText());
            }
            System.out.println("Selected options: " + selectedTexts);
            return selectedTexts;
        }
        catch (Exception e)
        {
            System.err.println("Failed to get selected options.");
            e.printStackTrace();
            return Collections.emptyList();
        }
    }


    // 39. Move mouse to an element (hover action)
    public void moveToElement(WebDriver driver, By locator) {
        try
        {
            WebElement element = waitForElementToBeVisible(driver, locator, 10);

            Actions actions = new Actions(driver);
            actions.moveToElement(element).perform();
            System.out.println("Mouse moved to element: " + locator);
        }
        catch (Exception e)
        {
            System.err.println("Failed to move mouse to element: " + locator);
            e.printStackTrace();
        }
    }

    // 40. Drag and drop an element to a target element
    public void dragAndDrop(WebDriver driver, By sourceLocator, By targetLocator)
    {
        try
        {
            WebElement sourceElement = waitForElementToBeVisible(driver, sourceLocator, 10);
            WebElement targetElement = waitForElementToBeVisible(driver, targetLocator, 10);

            Actions actions = new Actions(driver);
            actions.dragAndDrop(sourceElement, targetElement).perform();
            System.out.println("Dragged element from " + sourceLocator + " to " + targetLocator);
        }
        catch (Exception e)
        {
            System.err.println("Failed to drag and drop element.");
            e.printStackTrace();
        }
    }

    // 41. Double-click on an element
    public void doubleClickElement(WebDriver driver, By locator)
    {
        try
        {
            WebElement element = waitForElementToBeVisible(driver, locator, 10);
            Actions actions = new Actions(driver);
            actions.doubleClick(element).perform();
            System.out.println("Element double-clicked: " + locator);
        }
        catch (Exception e)
        {
            System.err.println("Failed to double-click element: " + locator);
            e.printStackTrace();
        }
    }

}

