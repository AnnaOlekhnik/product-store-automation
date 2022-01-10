package project.store.ui.runner;

import project.store.ui.driver.DriverManager;
import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterTest;

import java.util.Objects;

/**
 * Executes the features.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        features = {"src/test/resources/features/"},
        glue = {"project.store.ui"})

public class Runner extends AbstractTestNGCucumberTests {

    /**
     * Quits the Web Driver instance.
     */
    @AfterTest
    public void quitWebDriver() {
        if (!Objects.isNull(DriverManager.getInstance().getWebDriver())) {
            DriverManager.getInstance().quitDriver();
        }
    }
}
