package utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.PageObject;

/**
 * The class Waiters.
 */
public class Waiters extends PageObject {

    /**
     * The constant DELAY. This is delay for WebDriverWait is seconds.
     */
    private static final int DELAY = 10;

    /**
     * The private value webDriverWait.
     */
    private WebDriverWait webDriverWait;

    /**
     * Instantiates a new Waiters.
     *
     * @param driver the driver
     */
    public Waiters(final AndroidDriver<WebElement> driver) {
        super(driver);
        webDriverWait = new WebDriverWait(driver, DELAY);
    }


    /**
     * Wait for visibility of element located by web element.
     *
     * @param locator the locator.
     * @return the web element.
     */
    public WebElement waitForVisibilityOf(final AndroidElement locator) {
        return webDriverWait.until(ExpectedConditions.visibilityOf(locator));
    }
}
