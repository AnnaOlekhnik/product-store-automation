package project.store.ui.utils;

import project.store.ui.utils.constants.SearchBy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import project.store.ui.driver.DriverManager;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

/**
 * Manages and performs actions on Web elements.
 */
public final class CommonActions {
    private static final Logger LOGGER = LogManager.getLogger(CommonActions.class.getSimpleName());
    private static final String CLICK_JS_SCRIPT = "arguments[0].click();";
    private static JavascriptExecutor js = (JavascriptExecutor) DriverManager.getInstance().getWebDriver();

    /**
     * Private constructor for {@link CommonActions} utility class.
     */
    private CommonActions() {
    }

    public static void navigateMainPage(final String url) {

        DriverManager.getInstance().getWebDriver().navigate().to(url);
    }

    /**
     * Moves the mouse to a web element.
     *
     * @param webElement to do over mouse.
     */
    public static void moveToElement(final WebElement webElement) {
        DriverManager.getInstance().getWebDriverWait().until(ExpectedConditions.visibilityOf(webElement));
        Actions action = new Actions(DriverManager.getInstance().getWebDriver());
        action.moveToElement(webElement).click().build().perform();
    }

    /**
     * Sets an input Field.
     *
     * @param webElement WebElement to wait and fill.
     * @param text       Text to fill.
     */
    public static void setInputField(final WebElement webElement, final String text) {
        DriverManager.getInstance().getWebDriverWait().until(ExpectedConditions.visibilityOf(webElement));
        webElement.sendKeys(text);
    }

    /**
     * Waits and clicks on a webElement.
     *
     * @param webElement WebElement to wait and click.
     */
    public static void clickElement(final WebElement webElement) {
        DriverManager.getInstance();
        DriverManager.getInstance().getWebDriverWait().until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

    /**
     * Waits and clicks on a webElement using a javascript code.
     *
     * @param webElement WebElement to wait and click.
     */
    public static void clickElementByJavascript(final WebElement webElement) {
        DriverManager.getInstance();
        DriverManager.getInstance().getWebDriverWait().until(ExpectedConditions.elementToBeClickable(webElement));
        js.executeScript(CLICK_JS_SCRIPT, webElement);
    }

    /**
     * Waits and gets the text of an WebElement.
     *
     * @param webElement WebElement to wait and get the text.
     * @return Text of element.
     */
    public static String getTextElement(final WebElement webElement) {
        DriverManager.getInstance().getWebDriverWait().until(ExpectedConditions.visibilityOf(webElement));
        return webElement.getText();
    }

    /**
     * Verifies if Web element is Displayed.
     *
     * @param webElement WebElement.
     * @return True if the element is Displayed.
     */
    public static boolean isElementDisplayed(final WebElement webElement) {
        try {
            DriverManager.getInstance().getWebDriverWait().until(ExpectedConditions.visibilityOf(webElement));
            return true;
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    /**
     * Gets a list of WebElements.
     *
     * @param by      as SearchBy enum type.
     * @param locator as String.
     * @return a list of WebElements.
     */
    public static List<WebElement> findElementsBy(final SearchBy by, final String locator) {
        By searchBy = getBy(by, locator);
        return DriverManager.getInstance().getWebDriver().findElements(searchBy);
    }

    /**
     * Gets a WebElement.
     *
     * @param by      as SearchBy enum type.
     * @param locator as String.
     * @return a locator WebElement.
     */
    public static WebElement findElementBy(final SearchBy by, final String locator) {
        By searchBy = getBy(by, locator);
        return DriverManager.getInstance().getWebDriver().findElement(searchBy);
    }

    /**
     * Gets element text using JavaScriptExecutor.
     *
     * @param element as WebElement.
     * @return element text as String.
     */
    public static String getTextByJavaScript(final WebElement element) {
        return js.executeScript("return arguments[0].value;", element).toString();
    }

    /**
     * Gets window handles.
     *
     * @return list of actual window handles.
     */
    public static List<String> getWindowHandles() {
        return new ArrayList<>(DriverManager.getInstance().getWebDriver().getWindowHandles());
    }

    /**
     * Closes the driver of opened window.
     */
    public static void closeWindowDriver() {
        DriverManager.getInstance().getWebDriver().close();
    }


    /**
     * Quit the driver.
     */
    public static void quitWebDriver() {
        DriverManager.getInstance().quitDriver();
    }

    /**
     * Waits until the element gets displayed on page.
     *
     * @param by      of SearchBy enum type.
     * @param locator as String.
     */
    public static void waitUntilElementIsDisplayed(final SearchBy by, final String locator) {
        By searchBy = getBy(by, locator);
        DriverManager.getInstance().getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(searchBy));
    }

    /**
     * Gets By object given a locator.
     *
     * @param option  as SearchBy enum type.
     * @param locator as String.
     * @return By object.
     */
    private static By getBy(final SearchBy option, final String locator) {
        Map<SearchBy, By> byMap = new EnumMap<>(SearchBy.class);
        byMap.put(SearchBy.CSS, By.cssSelector(locator));
        byMap.put(SearchBy.ID, By.id(locator));
        byMap.put(SearchBy.XPATH, By.xpath(locator));
        byMap.put(SearchBy.CLASS, By.className(locator));
        return byMap.get(option);
    }

    /**
     * Checks if an element is clickable.
     *
     * @param element as WebElement.
     * @return true if element is clickable, false otherwise.
     */
    public static boolean isElementClickable(final WebElement element) {
        try {
            DriverManager.getInstance().getWebDriverWait().until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (NoSuchElementException e) {
            LOGGER.error("Web element isn't clickable.", e);
            return false;
        }
    }
}
