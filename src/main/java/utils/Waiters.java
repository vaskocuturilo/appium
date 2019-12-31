package utils;

import base.BaseClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.PageObject;

public class Waiters extends PageObject {

    /**
     * The constant DELAY. This is delay for WebDriverWait is seconds.
     */
    private static final int DELAY = 5;

    /**
     * The private value webDriverWait.
     */
    private WebDriverWait webDriverWait;

    public Waiters(AndroidDriver<WebElement> driver) {
        super(driver);
        webDriverWait = new WebDriverWait(driver, 10);
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
