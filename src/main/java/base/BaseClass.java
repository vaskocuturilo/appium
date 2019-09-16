package base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

import static utils.PropertiesReader.loadProperty;


/**
 * The type Base class.
 */
public class BaseClass {

    /**
     * The Driver.
     */
    private transient AndroidDriver<AndroidElement> driver;

    /**
     * The default constructor.
     */
    public BaseClass() {
        super();
        //empty
        return;
    }

    /**
     * The getter.
     *
     * @return driver.
     */
    public AndroidDriver<AndroidElement> getDriver() {
        return driver;
    }

    /**
     * Start.
     *
     * @param deviceName the device name
     * @param udid       the udid
     */
    @Parameters({"deviceName", "udid"})
    @BeforeTest(alwaysRun = true)
    public void start(final String deviceName, final String udid) {
        final DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        capabilities.setCapability(MobileCapabilityType.UDID, udid);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1.1");
        capabilities.setCapability("appPackage", "com.android.calculator2");
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");


        try {
            driver = new AndroidDriver<AndroidElement>(new URL(loadProperty("URL")), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);

        }
    }


    /**
     * Tear down.
     */
    @AfterTest(alwaysRun = true)
    public void stopDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

}
