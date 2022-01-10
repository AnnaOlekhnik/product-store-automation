package project.store.ui.stepdefinitions;

import io.cucumber.java.en.Given;
import project.store.ui.config.dto.EnvironmentConfigDto;
import project.store.ui.pages.ItemPage;

public class ItemSteps {
    private EnvironmentConfigDto environmentConfig;

    public ItemSteps(final EnvironmentConfigDto environmentConfig) {
        this.environmentConfig = environmentConfig;
    }

    @Given("^I click Add Button$")
    public void clickButtonToAddItem() {
        ItemPage itemPage = new ItemPage();
        itemPage.clickAddButton();
    }
}
