package project.store.ui.config;


import project.store.ui.utils.JsonFileReader;
import org.json.simple.JSONObject;

import java.util.Objects;

/**
 * Sets up Environment data for test execution.
 */
public final class EnvironmentManager {
    private static final String ENVIRONMENT_CONFIGURATIONS_FILE_PATH =
            "../product-store-ui/src/main/resources/Environment.json";
    private static EnvironmentManager instance = null;
    private UiConfig uiConfig;
    private JSONObject environmentConfig;
    private JSONObject portalConfig;

    /**
     * Initializes an instance of {@link EnvironmentManager}.
     */
    private EnvironmentManager() {
        uiConfig = UiConfig.getInstance();
        setEnvironmentConfig();
    }

    /**
     * Initializes a singleton Environment Manager instance.
     *
     * @return singleton instance of {@link EnvironmentManager}.
     */
    public static EnvironmentManager getInstance() {
        if (Objects.isNull(instance)) {
            instance = new EnvironmentManager();
        }
        return instance;
    }

    /**
     * Sets the global environment config in a Json object.
     */
    private void setEnvironmentConfig() {
        environmentConfig = JsonFileReader.getJsonElementFromJsonArray(
                JsonFileReader.loadJsonObjectFromFile(ENVIRONMENT_CONFIGURATIONS_FILE_PATH),
                ReservedWords.ENVIRONMENTS.val(), ReservedWords.NAME.val(), uiConfig.getEnvironment());
    }

    /**
     * Gets the base URL from environment config file.
     *
     * @return Base Url string.
     */
    public String getBaseUrl() {
        return (String) portalConfig.get(ReservedWords.BASE_URL.val());
    }

}
