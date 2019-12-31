package environment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


/**
 * The interface WebDriverProvider.
 */
public interface WebDriverProvider {

    /**
     * The method createDriver.
     *
     * @param capabilities the capabilities
     * @return the web driver
     */
    WebDriver createDriver(DesiredCapabilities capabilities);
}
