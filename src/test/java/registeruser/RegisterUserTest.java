package registeruser;

import base.BaseClass;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import page.MainPage;

public class RegisterUserTest extends BaseClass {

    @Test(description = "Check that user can register.")
    public void testRegister() {
        new MainPage((AndroidDriver<WebElement>) getDriver())
                .selectRegion()
                .clickRegister()
                .registerUser()
                .checkRequiredField()
                .addedRegisterData("userData");
    }
}
