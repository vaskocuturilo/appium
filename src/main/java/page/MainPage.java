package page;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

/**
 * The class MainPage.
 */
@SuppressWarnings("PMD.BeanMembersShouldSerialize")
public class MainPage extends PageObject {

    /**
     * The findBy regionOK.
     */
    @AndroidFindBy(id = "com.sebbia.delivery:id/positiveButton")
    private AndroidElement regionOK;

    /**
     * The findBy loginField.
     */
    @AndroidFindBy(id = "com.sebbia.delivery:id/loginView")
    private AndroidElement loginField;

    /**
     * The findBy registerField.
     */
    @AndroidFindBy(id = "com.sebbia.delivery:id/regView")
    private AndroidElement registerField;

    /**
     * The constructor.
     *
     * @param driver the driver
     */
    public MainPage(final AndroidDriver<WebElement> driver) {
        super(driver);
    }

    /**
     * The method selectRegion.
     *
     * @return the main page
     */
    public MainPage selectRegion() {
        regionOK.click();
        return this;
    }

    /**
     * The method clickLogin.
     *
     * @return the login page
     */
    public LoginPage clickLogin() {
        loginField.click();
        return new LoginPage(driver);
    }

    /**
     * The method clickRegister.
     *
     * @return the register page
     */
    public RegisterPage clickRegister() {
        registerField.click();
        return new RegisterPage(driver);
    }
}
