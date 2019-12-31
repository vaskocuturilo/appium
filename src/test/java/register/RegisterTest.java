package register;

import base.BaseClass;
import org.testng.annotations.Test;
import page.MainPage;

public class RegisterTest extends BaseClass {
    @Test
    public void testRegister() {
        new MainPage(getDriver())
                .selectRegion()
                .clickRegister()
                .registerUser();
    }

}
