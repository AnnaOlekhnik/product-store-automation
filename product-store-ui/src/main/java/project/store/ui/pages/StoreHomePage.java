package project.store.ui.pages;

import project.store.ui.base.BasePage;
import project.store.ui.utils.CommonActions;
import project.store.ui.utils.constants.SearchBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static java.lang.String.format;

/**
 * Manages elements and actions on store home page.
 */
public class StoreHomePage extends BasePage {


    @FindBy(xpath = "//a[contains(.,'Laptops')]")
    private WebElement laptopTab;

    @FindBy(css = "#cartur")
    private WebElement cartTab;

    public void clickOnLaptopTab() {
        CommonActions.clickElement(laptopTab);
    }

    public void clickOnCartTab() {
        CommonActions.clickElement(cartTab);
    }

    public void clickOnItemByText(String targetModel){
        String xpath = format("//h4[./a[contains(.,'%s')]]", targetModel);
        CommonActions.findElementBy(SearchBy.XPATH, xpath);
    }

    /**
     * Gets a web element locator on page.
     *
     * @param elementName as String, represents element whose locator will be returned.
     * @return a specific web element locator.
     */
    @Override
    protected WebElement getPageElement(String elementName) {
        return null;
    }
}
