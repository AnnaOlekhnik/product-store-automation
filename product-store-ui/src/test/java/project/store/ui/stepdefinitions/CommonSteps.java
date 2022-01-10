package project.store.ui.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import project.store.ui.config.EnvironmentManager;
import project.store.ui.utils.CommonActions;
import project.store.ui.utils.SmartWait;

public class CommonSteps {

    @Given("^I navigate main Product store page$")
    public void navigateProductStoreMainPage() {
        String baseUrl = EnvironmentManager.getInstance().getBaseUrl();
        CommonActions.navigateMainPage(baseUrl);
    }

    @Then("I verify that popup window opens")
    public void verifyPopupWindowOpens() {
        SmartWait.waitUntil(()->CommonActions.getWindowHandles().size()>0);
        Assert.assertTrue(CommonActions.getWindowHandles().size()>0,  "Popup window did not open.");
    }

}
