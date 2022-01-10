package project.store.ui.config.dto;

/**
 * Contains properties for Environment config data transfer object.
 */
public class EnvironmentConfigDto {
    private String portal;
    private String baseUrl;

    /**
     * Gets value contained in portal.
     *
     * @return portal value.
     */
    public String getPortal() {
        return portal;
    }

    /**
     * Sets a value in portal.
     *
     * @param portal is the value to set.
     */
    public void setPortal(final String portal) {
        this.portal = portal;
    }

    /**
     * Gets value contained in baseUrl.
     *
     * @return baseUrl value.
     */
    public String getBaseUrl() {
        return baseUrl;
    }

    /**
     * Sets a value in baseUrl.
     *
     * @param baseUrl is the value to set.
     */
    public void setBaseUrl(final String baseUrl) {
        this.baseUrl = baseUrl;
    }

}
