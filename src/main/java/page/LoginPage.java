package page;

import com.sun.istack.internal.NotNull;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.testng.Assert;
import utils.Waiters;

import java.text.DecimalFormat;
import java.util.Random;

public class LoginPage extends PageObject {

    @AndroidFindBy(id = "com.sebbia.delivery:id/editText")
    private AndroidElement phoneField;

    @AndroidFindBy(id = "com.sebbia.delivery:id/passwordEditText")
    private AndroidElement passwordField;

    @AndroidFindBy(id = "com.sebbia.delivery:id/forgotPasswordButton")
    private AndroidElement forgotPasswordField;

    @AndroidFindBy(id = "com.sebbia.delivery:id/messageView")
    private AndroidElement assertText;

    @AndroidFindBy(id = "com.sebbia.delivery:id/positiveButton")
    private AndroidElement positiveButton;

    @AndroidFindBy(className = "android.widget.ImageView")
    private AndroidElement backButton;

    @AndroidFindBy(id = "com.sebbia.delivery:id/signInButton")
    private AndroidElement sigInButton;

    private static final String SMS_WITH_CODE = "Смс с кодом";

    private static final String NOT_CODE = "Неправильный код";

    private static final String PASSWORD = "qwerty123456";

    public LoginPage(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }


    public LoginPage checkLoginPage() {
        phoneField.sendKeys(createPhoneNumber());
        passwordField.sendKeys(PASSWORD);
        forgotPasswordField.click();
        return this;
    }

    public LoginPage checkAssertMessage() {
        Waiters waiters = new Waiters(driver);
        Assert.assertTrue(assertText.getText().contains(SMS_WITH_CODE));
        waiters.waitForVisibilityOf(positiveButton).click();
        waiters.waitForVisibilityOf(sigInButton).click();
        Assert.assertTrue(assertText.getText().contains(NOT_CODE));
        positiveButton.click();
        backButton.click();

        return this;
    }

    @NotNull
    private static String createPhoneNumber() {
        Random rand = new Random();
        int firstNumber = (rand.nextInt(7) + 1) * 100 + (rand.nextInt(8) * 10) + rand.nextInt(8);
        int secondNumber = rand.nextInt(743);
        int thirdNumber = rand.nextInt(10000);

        DecimalFormat decimalFormatThreeElements = new DecimalFormat("000");
        DecimalFormat decimalFormatFourElements = new DecimalFormat("0000");

        String phoneNumber = decimalFormatThreeElements.format(firstNumber) + "-" + decimalFormatThreeElements.format(secondNumber) + "-" + decimalFormatFourElements.format(thirdNumber);

        return phoneNumber;
    }
}
