package environment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;


/**
 * The class Remote.
 */
public class Remote implements WebDriverProvider {

    /**
     * The constant LOGGER.
     */
    private static final Logger LOGGER = Logger.getLogger(Remote.class.getName());

    @Override
    public WebDriver createDriver(final DesiredCapabilities capabilities) {
        capabilities.setCapability("browserName", "android");
        capabilities.setCapability("version", "8.0");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("appPackage", "com.android.calculator2");
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
        try {
            return new RemoteWebDriver(getSelenoidUrl(), capabilities);
        } catch (Exception ex) {
            LOGGER.info("This is " + ex);
        }
        return null;
    }

    /**
     * The method getSelenoidUrl.
     *
     * @return hostURL.
     */
    private static URL getSelenoidUrl() {
        URL hostURL = null;
        try {
            hostURL = new URL(System.getProperty("http://192.168.0.8:4444/wd/hub", "http://192.168.0.8:4444/wd/hub"));
        } catch (MalformedURLException ex) {
            LOGGER.info("This is " + ex);
        }
        return hostURL;
    }
}
