package login;

import base.BaseClass;
import org.testng.annotations.Test;
import page.MainPage;

public class LoginTest extends BaseClass {

    @Test(description = "Check that user can login in application.")
    public void openSignIn() {
        new MainPage(getDriver())
                .selectRegion()
                .clickLogin()
                .checkLoginPage()
                .checkAssertMessage();
    }
}
