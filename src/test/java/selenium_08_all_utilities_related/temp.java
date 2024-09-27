package selenium_08_all_utilities_related;


public class temp
{
    public String getCurrentWindowHandle()
    {
        String handle = driver.getWindowHandle();
        logger.info("Current window handle: {}", handle);
        return handle;
    }

    // 2. Get all window handles
    public void closeWindow()
    {
        try
        {
            driver.close();
        } catch (Exception e)
        {
            logger.error("Failed to close the window.", e);
        }
    }

    // 4. Switch to parent window
    public void switchToParentWindow()
    {
        try
        {
            String parentWindow = driver.getWindowHandle();
            driver.switchTo().window(parentWindow);
        } catch (Exception e)
        {
            logger.error("Failed to switch to parent window.", e);
        }
    }

// ==============================
// JavaScript Interaction Methods
// ==============================

    // 5. Execute JavaScript in the browser
    public void executeJavaScript(String script)
    {
        try
        {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript(script);
        } catch (Exception e)
        {
            logger.error("Failed to execute JavaScript.", e);
        }
    }

    // 6. Scroll to a specific element using JavaScript
    public void scrollToElementUsingJavaScript(By locator)
    {
        try
        {
            WebElement element = waitForElementToBeVisible(locator, 10);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        } catch (Exception e)
        {
            logger.error("Failed to scroll to element: " + locator, e);
        }
    }

    // 7. Click an element using JavaScript
    public void clickUsingJavaScript(By locator)
    {
        try
        {
            WebElement element = waitForElementToBeVisible(locator, 10);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", element);
        } catch (Exception e)
        {
            logger.error("Failed to click element using JavaScript: " + locator, e);
        }
    }

// 8. Get the title of the current page using JavaScript

    public String getPageTitleUsingJavaScript()
    {
        try
        {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            return js.executeScript("return document.title;").toString();
        } catch (Exception e)
        {
            logger.error("Failed to retrieve page title using JavaScript.", e);
            return null;
        }
    }

// 9. Refresh the browser using JavaScript

    public void refreshBrowserUsingJavaScript()
    {
        try
        {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("history.go(0);");
        } catch (Exception e)
        {
            logger.error("Failed to refresh the browser using JavaScript.", e);
        }
    }

// 10. Scroll to the bottom of the page using JavaScript

    public void scrollToBottomOfPageUsingJavaScript()
    {
        try
        {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        } catch (Exception e)
        {
            logger.error("Failed to scroll to the bottom of the page.", e);
        }
    }

// 11. Highlight an element using JavaScript

    public void highlightElementUsingJavaScript(By locator)
    {
        try
        {
            WebElement element = waitForElementToBeVisible(locator, 10);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].style.border='3px solid red'", element);
        } catch (Exception e)
        {
            logger.error("Failed to highlight element: " + locator, e);
        }
    }

// 12. Get an element's inner text using JavaScript

    public String getInnerTextUsingJavaScript(By locator)
    {
        try
        {
            WebElement element = waitForElementToBeVisible(locator, 10);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            return js.executeScript("return arguments[0].innerText;", element).toString();
        } catch (Exception e)
        {
            logger.error("Failed to retrieve inner text using JavaScript for element: " + locator, e);
            return null;
        }
    }

// 13. Disable a button using JavaScript

    public void disableButtonUsingJavaScript(By locator)
    {
        try
        {
            WebElement button = waitForElementToBeVisible(locator, 10);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].disabled = true;", button);
        } catch (Exception e)
        {
            logger.error("Failed to disable button using JavaScript for element: " + locator, e);
        }
    }

    // Utility method to wait for the element to be visible
    private WebElement waitForElementToBeVisible(By locator, int timeoutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public String readExcelData(String filePath, String sheetName, int row, int col) throws IOException
    {
        // The logic remains the same, only WebDriver is not needed here.
    }

    // 30. Capture screenshot and save it to a specific location
    public void captureScreenshot(String filePath)
    {
        try
        {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(srcFile, new File(filePath));
            logger.info("Screenshot saved at: {}", filePath);
        } catch (Exception e)
        {
            logger.error("Failed to capture screenshot at: {}", filePath, e);
        }
    }

    // 31. Upload a file using Selenium
    public void uploadFile(By locator, String filePath)
    {
        try
        {
            WebElement uploadElement = driver.findElement(locator);
            uploadElement.sendKeys(filePath);
            logger.info("Uploaded file '{}'.", filePath);
        } catch (NoSuchElementException e)
        {
            logger.error("Failed to find element to upload file at: {}", locator, e);
        }
    }

    // 32. Download a file using Selenium
    public void downloadFile(String downloadUrl)
    {
        try
        {
            driver.get(downloadUrl);  // Navigates to the file's download URL
            logger.info("File download initiated for URL: {}", downloadUrl);
        } catch (TimeoutException e)
        {
            logger.error("Download page timed out for URL: {}", downloadUrl, e);
        }
    }

    // 33. Switch to a new browser tab/window
    public void switchToNewTab()
    {
        try
        {
            for (String handle : driver.getWindowHandles())
            {
                driver.switchTo().window(handle);
            }
            logger.info("Switched to new tab/window.");
        } catch (NoSuchWindowException e)
        {
            logger.error("Failed to switch to new tab/window.", e);
        }
    }

    // 34. Switch back to the original tab/window
    public void switchToOriginalTab(String originalWindowHandle)
    {
        try
        {
            driver.switchTo().window(originalWindowHandle);
            logger.info("Switched back to the original tab/window.");
        } catch (NoSuchWindowException e)
        {
            logger.error("Failed to switch back to original tab/window with handle: {}", originalWindowHandle, e);
        }
    }

    // 35. Handle a web-based alert
    public void handleAlert(boolean accept)
    {
        try
        {
            Alert alert = driver.switchTo().alert();
            if (accept)
            {
                alert.accept();
                logger.info("Alert accepted.");
            } else
            {
                alert.dismiss();
                logger.info("Alert dismissed.");
            }
        } catch (NoAlertPresentException e)
        {
            logger.error("No alert present to handle.", e);
        }
    }

    // 36. Handle multiple select options
    public void selectMultipleOptions(By locator, List<String> optionsToSelect)
    {
        try
        {
            WebElement element = waitForElementToBeVisible(locator, 10);
            Select select = new Select(element);
            for (String option : optionsToSelect)
            {
                select.selectByVisibleText(option);
            }
        } catch (Exception e)
        {
            logger.error("Failed to select multiple options: {}", e.getMessage());
        }
    }

    // 37. Deselect all options
    public void deselectAllOptions(By locator)
    {
        try
        {
            WebElement element = waitForElementToBeVisible(locator, 10);
            Select select = new Select(element);
            select.deselectAll();
        } catch (Exception e)
        {
            logger.error("Failed to deselect all options.", e);
        }
    }

    // 38. Get all selected options?????????????????????????????
    public void moveToElement(By locator)
    {
        try
        {
            WebElement element = waitForElementToBeVisible(locator, 10);
            Actions actions = new Actions(driver);
            actions.moveToElement(element).perform();
        } catch (Exception e)
        {
            logger.error("Failed to move mouse to element: {}", locator, e);
        }
    }

    // 40. Drag and drop an element to a target element
    public void dragAndDrop(By sourceLocator, By targetLocator)
    {
        try
        {
            WebElement sourceElement = waitForElementToBeVisible(sourceLocator, 10);
            WebElement targetElement = waitForElementToBeVisible(targetLocator, 10);
            Actions actions = new Actions(driver);
            actions.dragAndDrop(sourceElement, targetElement).perform();
        } catch (Exception e)
        {
            logger.error("Failed to drag and drop element.", e);
        }
    }

    // 41. Double-click on an element
    public void doubleClickElement(By locator)
    {
        try
        {
            WebElement element = waitForElementToBeVisible(locator, 10);
            Actions actions = new Actions(driver);
            actions.doubleClick(element).perform();
        } catch (Exception e)
        {
            logger.error("Failed to double-click element: {}", locator, e);
        }
    }

    public void enterText(By locator, String text, Duration timeout)
    {
        try
        {
            WebElement element = waitForElementToBeVisible(locator, timeout);
            element.clear();
            element.sendKeys(text);
            logger.info("Entered text into element: {}", locator);
        } catch (Exception e)
        {
            logger.error("Failed to enter text in the element: {}", locator, e);
        }
    }

    // 2. Click on a button element (with JavaScript fallback)
    public void clickButton(By locator, Duration timeout)
    {
        try
        {
            WebElement button = waitForElementToBeClickable(locator, timeout);
            button.click();
            logger.info("Button clicked successfully using Selenium click: {}", locator);
        } catch (Exception e)
        {
            logger.warn("Selenium click failed, attempting JavaScript click for: {}", locator);
            try
            {
                WebElement button = driver.findElement(locator);
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", button);
                logger.info("Button clicked successfully using JavaScript click: {}", locator);
            } catch (Exception jsException)
            {
                logger.error("JavaScript click also failed for element: {}", locator, jsException);
            }
        }
    }

    // 3. Select a value from a dropdown element by visible text
    public void selectFromDropdown(By locator, String value, Duration timeout)
    {
        try
        {
            WebElement dropdownElement = waitForElementToBeVisible(locator, timeout);
            Select dropdown = new Select(dropdownElement);
            dropdown.selectByVisibleText(value);
            logger.info("Selected value '{}' from dropdown: {}", value, locator);
        } catch (Exception e)
        {
            logger.error("Failed to select value from dropdown: {}", locator, e);
        }
    }

// ==============================
// Utility Methods
// ==============================

    // 4. Wait for an element to be visible
    public void takeScreenshot(String filePath)
    {
        try
        {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File(filePath));
            logger.info("Screenshot saved at: {}", filePath);
        } catch (Exception e)
        {
            logger.error("Failed to take screenshot", e);
        }
    }

    // 8. Check if an element is present
    public boolean isElementPresent(By locator)
    {
        try
        {
            driver.findElement(locator);
            logger.info("Element is present: {}", locator);
            return true;
        } catch (NoSuchElementException e)
        {
            logger.warn("Element is not present: {}", locator);
            return false;
        }
    }

    // 9. Get text from an element
    public String getElementText(By locator, Duration timeout)
    {
        try
        {
            WebElement element = waitForElementToBeVisible(locator, timeout);
            String text = element.getText();
            logger.info("Text from element {}: {}", locator, text);
            return text;
        } catch (Exception e)
        {
            logger.error("Failed to get text from element: {}", locator, e);
            return null;
        }
    }

    // 10. Perform mouse hover action on an element
    public void hoverOverElement(By locator, Duration timeout)
    {
        try
        {
            WebElement element = waitForElementToBeVisible(locator, timeout);
            Actions actions = new Actions(driver);
            actions.moveToElement(element).perform();
            logger.info("Hovered over element: {}", locator);
        } catch (Exception e)
        {
            logger.error("Failed to hover over element: {}", locator, e);
        }
    }

    // ==============================
// JS Actions
// ==============================
// 11. Highlight an element using JavaScript
    public void scrollToBottomUsingJavaScript()
    {
        try
        {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            logger.info("Scrolled to the bottom of the page");
        } catch (Exception e)
        {
            logger.error("Failed to scroll to the bottom of the page", e);
        }
    }

    // More methods can follow the same structure...
    public void acceptAlert()
    {
        try
        {
            Alert alert = driver.switchTo().alert();
            alert.accept();
            logger.info("Alert accepted");
        } catch (NoAlertPresentException e)
        {
            logger.warn("No alert present to accept", e);
        }
    }

    // 14. Dismiss an alert popup
    public void dismissAlert()
    {
        try
        {
            Alert alert = driver.switchTo().alert();
            alert.dismiss();
            logger.info("Alert dismissed");
        } catch (NoAlertPresentException e)
        {
            logger.warn("No alert present to dismiss", e);
        }
    }

    // 15. Retrieve alert text
    public String getAlertText()
    {
        try
        {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            logger.info("Retrieved alert text: {}", alertText);
            return alertText;
        } catch (NoAlertPresentException e)
        {
            logger.error("No alert present to retrieve text from", e);
            return null;
        }
    }

    // 16. Switch to a frame by its index
    public void switchToFrameByIndex(int index)
    {
        try
        {
            driver.switchTo().frame(index);
            logger.info("Switched to frame by index: {}", index);
        } catch (NoSuchFrameException e)
        {
            logger.error("Failed to switch to frame by index: {}", index, e);
        }
    }

    // 17. Switch to a frame by its name or ID
    public void switchToFrameByNameOrID(String nameOrID)
    {
        try
        {
            driver.switchTo().frame(nameOrID);
            logger.info("Switched to frame by name or ID: {}", nameOrID);
        } catch (NoSuchFrameException e)
        {
            logger.error("Failed to switch to frame by name or ID: {}", nameOrID, e);
        }
    }

    // 18. Switch to a frame by WebElement
    public void switchToFrameByElement(By locator)
    {
        try
        {
            WebElement frameElement = driver.findElement(locator);
            driver.switchTo().frame(frameElement);
            logger.info("Switched to frame by WebElement: {}", locator);
        } catch (NoSuchFrameException e)
        {
            logger.error("Failed to switch to frame by WebElement: {}", locator, e);
        }
    }

    // 19. Switch back to the default content from a frame
    public void switchToDefaultContent()
    {
        try
        {
            driver.switchTo().defaultContent();
            logger.info("Switched back to default content");
        } catch (Exception e)
        {
            logger.error("Failed to switch back to default content", e);
        }
    }

    // 21. Switch to a window by its title
    public void switchToWindowByTitle(String title)
    {
        try
        {
            Set<String> windowHandles = driver.getWindowHandles();
            for (String windowHandle : windowHandles)
            {
                driver.switchTo().window(windowHandle);
                if (driver.getTitle().equals(title))
                {
                    logger.info("Switched to window with title: {}", title);
                    return;
                }
            }
            logger.warn("No window found with the title: {}", title);
        } catch (Exception e)
        {
            logger.error("Failed to switch to window with title: {}", title, e);
        }
    }

    // 22. Switch to a window by its URL
    public void switchToWindowByUrl(String url)
    {
        try
        {
            Set<String> windowHandles = driver.getWindowHandles();
            for (String windowHandle : windowHandles)
            {
                driver.switchTo().window(windowHandle);
                if (driver.getCurrentUrl().equals(url))
                {
                    logger.info("Switched to window with URL: {}", url);
                    return;
                }
            }
            logger.warn("No window found with the URL: {}", url);
        } catch (Exception e)
        {
            logger.error("Failed to switch to window with URL: {}", url, e);
        }
    }

// 23. Close the current window

    public void closeCurrentWindow()
    {
        try
        {
            driver.close();
            logger.info("Closed current window");
        } catch (Exception e)
        {
            logger.error("Failed to close current window", e);
        }
    }

// 24. Maximize the browser window

    public void maximizeWindow()
    {
        try
        {
            driver.manage().window().maximize();
            logger.info("Browser window maximized");
        } catch (Exception e)
        {
            logger.error("Failed to maximize the browser window", e);
        }
    }

// 25. Get the page title

    public String getPageTitle()
    {
        try
        {
            String title = driver.getTitle();
            logger.info("Retrieved page title: {}", title);
            return title;
        } catch (Exception e)
        {
            logger.error("Failed to retrieve page title", e);
            return null;
        }
    }

// 26. Refresh the page

    public void refreshPage()
    {
        try
        {
            driver.navigate().refresh();
            logger.info("Page refreshed successfully");
        } catch (Exception e)
        {
            logger.error("Failed to refresh the page", e);
        }
    }

// 27. Navigate to a specific URL

    public void navigateToUrl(String url)
    {
        try
        {
            driver.navigate().to(url);
            logger.info("Navigated to URL: {}", url);
        } catch (Exception e)
        {
            logger.error("Failed to navigate to URL: {}", url, e);
        }
    }

// 28. Get the current page URL

    public String getCurrentPageUrl()
    {
        try
        {
            String currentUrl = driver.getCurrentUrl();
            logger.info("Retrieved current page URL: {}", currentUrl);
            return currentUrl;
        } catch (Exception e)
        {
            logger.error("Failed to retrieve current page URL", e);
            return null;
        }
    }

// 29. Check if an element is displayed

    public boolean isElementDisplayed(By locator, Duration timeout)
    {
        try
        {
            WebElement element = waitForElementToBeVisible(locator, timeout);
            boolean isDisplayed = element.isDisplayed();
            logger.info("Element is displayed: {}", locator);
            return isDisplayed;
        } catch (Exception e)
        {
            logger.error("Failed to check if element is displayed: {}", locator, e);
            return false;
        }
    }

// 30. Check if an element is enabled

    public boolean isElementEnabled(By locator, Duration timeout)
    {
        try
        {
            WebElement element = waitForElementToBeVisible(locator, timeout);
            boolean isEnabled = element.isEnabled();
            logger.info("Element is enabled: {}", locator);
            return isEnabled;
        } catch (Exception e)
        {
            logger.error("Failed to check if element is enabled: {}", locator, e);
            return false;
        }
    }

// 31. Check if an element is selected

    public boolean isElementSelected(By locator, Duration timeout)
    {
        try
        {
            WebElement element = waitForElementToBeVisible(locator, timeout);
            boolean isSelected = element.isSelected();
            logger.info("Element is selected: {}", locator);
            return isSelected;
        } catch (Exception e)
        {
            logger.error("Failed to check if element is selected: {}", locator, e);
            return false;
        }
    }
}

