package page;

import base.BaseClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


/**
 * The class Page object.
 */
public class PageObject extends BaseClass {
    /**
     * The Driver.
     */
    protected AndroidDriver driver;

    /**
     * Instantiates a new Page object.
     *
     * @param newDriver the driver
     */
    public PageObject(final AndroidDriver<WebElement> newDriver) {
        this.driver = newDriver;
        PageFactory.initElements(new AppiumFieldDecorator(newDriver), this);
    }
}
