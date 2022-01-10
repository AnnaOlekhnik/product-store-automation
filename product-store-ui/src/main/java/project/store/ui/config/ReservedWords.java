package project.store.ui.config;

/**
 * Custom reserved words enum.
 */
public enum ReservedWords {
    BASE_URL("BaseUrl"),
    BROWSER("browser"),
    DOUBLE_DOT_AND_SLASH("../"),
    NAME("name"),
    ENVIRONMENTS("Environments"),
    ENVIRONMENT_NAME("environmentName"),
    EXPLICIT_TIME("explicitTimeWait"),
    IMPLICIT_TIME("implicitTimeWait"),
    PAGE_LOAD_TIME("pageLoadTimeWait"),
    SLEEP_TIME("sleepWaitTime"),
    STRING_EMPTY(""),
    CHROME_DRIVER_VERSION("chromeDriverVersion");

    private String word;

    /**
     * Initializes Reserved Words enum.
     *
     * @param word original word.
     */
    ReservedWords(final String word) {
        this.word = word;
    }

    /**
     * Gets the enum word value.
     *
     * @return original word.
     */
    public String val() {
        return word;
    }
}
