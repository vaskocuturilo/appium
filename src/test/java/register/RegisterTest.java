package register;

import base.BaseClass;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import page.MainPage;

public class RegisterTest extends BaseClass {
    @Test(description = "Check that user can click register button")
    public void testRegister() {
        new MainPage((AndroidDriver<WebElement>) getDriver())
                .selectRegion()
                .clickRegister()
                .clickRegisterButton();
    }

}
