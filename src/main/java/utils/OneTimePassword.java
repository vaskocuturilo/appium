package utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import page.PageObject;


/**
 * The class OneTimePassword.
 */
public class OneTimePassword extends PageObject {

    /**
     * The findBy otpCode.
     */
    @AndroidFindBy(xpath = "//*[contains(@text,'Код:')]")
    private WebElement otpCode;

    /**
     * The constructor.
     *
     * @param driver the driver
     */
    public OneTimePassword(final AndroidDriver<WebElement> driver) {
        super(driver);
    }

    /**
     * The method readOtpFromNotification.
     *
     * @return the one time password
     */
    public OneTimePassword readOtpFromNotification() {
        driver.openNotifications();
        String oneTimePassword = String.valueOf(otpCode.getText().split("[^\\d]+"));
        driver.navigate().back();

        return this;
    }
}
