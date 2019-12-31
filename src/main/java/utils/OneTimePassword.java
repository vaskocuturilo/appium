package utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import page.PageObject;


/**
 * The class OneTimePassword.
 */
public class OneTimePassword extends PageObject {

    @AndroidFindBy(xpath = "//*[contains(@text,'Your OTP is')]")
    private WebElement otpCode;

    /**
     * Instantiates a new One time password.
     *
     * @param driver the driver
     */
    public OneTimePassword(AndroidDriver<WebElement> driver) {
        super(driver);
    }

    /**
     * Read otp from notification one time password.
     *
     * @return the one time password
     */
    public  OneTimePassword readOtpFromNotification() {
        driver.openNotifications();
        String oneTimePassword = String.valueOf(otpCode.getText().split("is"));
        driver.navigate().back();

        return this;
    }
}
