package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;


/**
 * The class Appium driver factory.
 */
public class AppiumDriverFactory {

    /**
     * The method getDriver.
     *
     * @param device       the device
     * @param serverUrl    the server url
     * @param capabilities the capabilities
     * @return the driver
     */
    public AppiumDriver getDriver(final String device, final URL serverUrl, final DesiredCapabilities capabilities) {
        if ("android".equalsIgnoreCase(device)) {
            return new AndroidDriver(serverUrl, capabilities);
        } else if ("ios".equalsIgnoreCase(device)) {
            return new IOSDriver(serverUrl, capabilities);
        } else {
            throw new RuntimeException("Invalid device name");
        }
    }
}
