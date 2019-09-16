package page;

import base.BaseClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;


/**
 * The type Page object.
 */
public class PageObject extends BaseClass {


    /**
     * Instantiates a new Page object.
     *
     * @param androidDriver the element android driver
     */
    public PageObject(final AndroidDriver<AndroidElement> androidDriver) {
        super();
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }
}