package login;

import base.AppiumDriverFactory;
import base.BaseClass;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import page.MainPage;

public class LoginTest extends BaseClass {

    @Test(description = "Check that user can login in application.")
    public void openSignIn() {
        new MainPage((AndroidDriver<WebElement>) getDriver())
                .selectRegion()
                .clickLogin()
                .checkLoginPage()
                .checkAssertMessage();
    }
}
