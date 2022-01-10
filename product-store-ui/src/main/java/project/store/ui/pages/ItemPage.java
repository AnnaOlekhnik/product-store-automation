package project.store.ui.pages;

import project.store.ui.base.BasePage;
import project.store.ui.utils.CommonActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItemPage extends BasePage {

    @FindBy(xpath = "//a[contains(.,'Laptops')]")
    private WebElement addBtn;

    public void clickAddButton(){
        CommonActions.clickElement(addBtn);
    }

    @Override
    protected WebElement getPageElement(String elementName) {
        return null;
    }
}
