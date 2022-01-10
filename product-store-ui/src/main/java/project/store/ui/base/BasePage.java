package project.store.ui.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import project.store.ui.driver.DriverManager;
import project.store.ui.utils.CommonActions;

/**
 * Represents and encapsulates common pages objects attributes.
 */
public abstract class BasePage {
    private WebDriver driver;
    private WebDriverWait driverWait;
    protected static final Logger LOGGER = LogManager.getLogger(CommonActions.class.getSimpleName());
    /**
     * Initializes an instance of {@link BasePage}.
     */
    public BasePage() {
        setDriver(DriverManager.getInstance().getWebDriver());
        setDriverWait(DriverManager.getInstance().getWebDriverWait());
        PageFactory.initElements(getDriver(), this);
    }

    /**
     * Gets the driver.
     *
     * @return driver property
     */
    protected WebDriver getDriver() {
        return driver;
    }

    /**
     * Sets a value in driver.
     *
     * @param driver value to set in driver property
     */
    protected void setDriver(final WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Sets a value in driverWait.
     *
     * @param driverWait value to set in driverWait property
     */
    protected void setDriverWait(final WebDriverWait driverWait) {
        this.driverWait = driverWait;
    }

    /**
     * Gets a web element locator on page.
     *
     * @param elementName as String, represents element whose locator will be returned.
     * @return a specific web element locator.
     */
    protected abstract WebElement getPageElement(final String elementName);

    /**
     * Gets text value displayed in web element.
     *
     * @param field Web Element
     * @return returns text displayed in web element
     */
    public String getText(final String field) {
        WebElement fieldLocator = getPageElement(field);
        return CommonActions.getTextElement(fieldLocator).replace("\n", "");
    }

    /**
     * Clicks the web element on Speed Dial Codes page.
     *
     * @param fieldName Name of Web Element.
     */
    public void clickElement(final String fieldName) {
        WebElement webElement = getPageElement(fieldName);
        CommonActions.clickElement(webElement);
    }


    /**
     * Verifies if web element is displayed.
     * @param fieldName as String
     * @return true if web element is displayed, otherwise false.
     */
    public boolean isElementDisplayed(final String fieldName) {
        WebElement element = getPageElement(fieldName);
        return CommonActions.isElementDisplayed(element);
    }
}
