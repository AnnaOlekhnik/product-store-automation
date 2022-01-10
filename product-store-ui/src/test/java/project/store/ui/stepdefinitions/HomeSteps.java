package project.store.ui.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import project.store.ui.config.dto.EnvironmentConfigDto;
import project.store.ui.pages.StoreHomePage;

public class HomeSteps {
    private StoreHomePage homePage;
    private EnvironmentConfigDto environmentConfig;

    public HomeSteps(final EnvironmentConfigDto environmentConfig) {
        homePage = new StoreHomePage();
        this.environmentConfig = environmentConfig;
    }

    @Given("^I click on laptop tab$")
    public void clickLaptopTab() {
        homePage.clickOnLaptopTab();
    }

    @And("I click on {string} item")
    public void clickLaptopTab(String item) {
        homePage.clickOnItemByText(item);
    }

    @When("I click on Cart tab")
    public void clickCart(){
        homePage.clickOnCartTab();
    }
}
