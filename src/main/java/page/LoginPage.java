package page;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.Waiters;

import static utils.Phone.createPhoneNumber;

/**
 * The class LoginPage.
 */
public class LoginPage extends PageObject {

    /**
     * The findBy phoneField.
     */
    @AndroidFindBy(id = "com.sebbia.delivery:id/editText")
    private AndroidElement phoneField;

    /**
     * The findBy passwordField.
     */
    @AndroidFindBy(id = "com.sebbia.delivery:id/passwordEditText")
    private AndroidElement passwordField;

    /**
     * The findBy forgotPasswordField.
     */
    @AndroidFindBy(id = "com.sebbia.delivery:id/forgotPasswordButton")
    private AndroidElement forgotPasswordField;

    /**
     * The findBy assertText.
     */
    @AndroidFindBy(id = "com.sebbia.delivery:id/messageView")
    private AndroidElement assertText;

    /**
     * The findBy positiveButton.
     */
    @AndroidFindBy(id = "com.sebbia.delivery:id/positiveButton")
    private AndroidElement positiveButton;

    /**
     * The findBy backButton.
     */
    @AndroidFindBy(className = "android.widget.ImageView")
    private AndroidElement backButton;

    /**
     * The findBy sigInButton.
     */
    @AndroidFindBy(id = "com.sebbia.delivery:id/signInButton")
    private AndroidElement sigInButton;

    /**
     * The constant PASSWORD.
     */
    private static final String PASSWORD = "qwerty123456";

    /**
     * The constructor.
     *
     * @param driver the driver
     */
    public LoginPage(final AndroidDriver<WebElement> driver) {
        super(driver);
    }


    /**
     * The method checkLoginPage.
     *
     * @return the login page.
     */
    public LoginPage checkLoginPage() {
        phoneField.sendKeys(createPhoneNumber());
        passwordField.sendKeys(PASSWORD);
        forgotPasswordField.click();

        return this;
    }

    /**
     * The method checkAssertMessage.
     *
     * @return the login page.
     */
    public LoginPage checkAssertMessage() {
        final Waiters waiters = new Waiters(driver);
        Assert.assertTrue(assertText.isDisplayed());
        waiters.waitForVisibilityOf(positiveButton).click();
        waiters.waitForVisibilityOf(sigInButton).click();
        Assert.assertTrue(assertText.isDisplayed());
        positiveButton.click();
        backButton.click();

        return this;
    }
}
