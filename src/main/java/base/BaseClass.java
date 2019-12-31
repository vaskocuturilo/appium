package base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

import static utils.PropertiesReader.loadProperty;


/**
 * The class BaseClass.
 */
public class BaseClass {

    /**
     * The Driver.
     */
    private transient AndroidDriver<WebElement> driver;

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
    public AndroidDriver<WebElement> getDriver() {
        return driver;
    }


    /**
     * Start.
     *
     * @param deviceName the device name
     * @param udid       the udid
     */
    @Parameters({"deviceName", "udid"})
    @BeforeTest()
    public void start(final String deviceName, final String udid) {
        final DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        capabilities.setCapability(MobileCapabilityType.UDID, udid);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0.0");
        capabilities.setCapability("appPackage", "com.sebbia.delivery");
        capabilities.setCapability("appActivity", "com.sebbia.delivery.ui.orders.OrdersActivity");

        try {
            driver = new AndroidDriver<WebElement>(new URL(loadProperty("URL")), capabilities);
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
