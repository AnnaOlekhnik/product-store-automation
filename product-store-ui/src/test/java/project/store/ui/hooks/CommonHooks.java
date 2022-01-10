package project.store.ui.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.SkipException;
import project.store.ui.driver.DriverManager;
import project.store.ui.utils.CommonActions;

import java.util.Objects;

public class CommonHooks {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommonHooks.class);

    /**
     * Skips scenario.
     *
     * @param scenario to skip.
     */
    @Before(value = "@skipped")
    public void skip(final Scenario scenario) {
        String scenarioTitle = scenario.getName();
        if (scenarioTitle.contains("(")) {
            scenarioTitle = scenarioTitle.substring(scenarioTitle.indexOf("(") + 1);
            scenarioTitle = scenarioTitle.substring(0, scenarioTitle.indexOf(")"));
        } else {
            scenarioTitle = "skipped scenario without information";
        }
        throw new SkipException(scenarioTitle);
    }

    /**
     * Quits Web Driver after test is finish.
     */
    @After(value = "@quitWebDriverAfterTest")
    public void quitWebDriverAfterTest() {
        if (!Objects.isNull(DriverManager.getInstance().getWebDriver())) {
            CommonActions.quitWebDriver();
        }
    }
}
