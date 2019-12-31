package page;

import com.sun.istack.internal.NotNull;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.Waiters;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.Random;

import static java.lang.Thread.sleep;
import static org.testng.AssertJUnit.assertEquals;

/**
 * The class MainPage.
 */
@SuppressWarnings("PMD.BeanMembersShouldSerialize")
public class MainPage extends PageObject {

    private static final String FIRST_NAME = "Hello";

    private static final String NAME = "Hello";

    private static final String MIDDLE_NAME = "Hello";

    private static final String BIRTH = "18.10.1999";

    private static final String SMS_WITH_CODE = "Смс с кодом";

    private static final String NOT_CODE = "Неправильный код";

    @AndroidFindBy(id = "com.sebbia.delivery:id/positiveButton")
    private AndroidElement regionOK;

    @AndroidFindBy(id = "com.sebbia.delivery:id/loginView")
    private AndroidElement loginField;

    @AndroidFindBy(id = "com.sebbia.delivery:id/regView")
    private AndroidElement registerField;

    public MainPage(AndroidDriver<WebElement> driver) {
        super(driver);
    }

    public MainPage selectRegion() {
        regionOK.click();
        return this;
    }

    public LoginPage clickLogin() {
        loginField.click();
        return new LoginPage(driver);
    }

    public RegisterPage clickRegister() {
        registerField.click();
        return new RegisterPage(driver);
    }


}
