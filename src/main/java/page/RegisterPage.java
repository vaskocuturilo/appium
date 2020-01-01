package page;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static utils.Code.createCode;
import static utils.Phone.createPhoneNumber;


/**
 * The class RegisterPage.
 */
public class RegisterPage extends PageObject {

    @AndroidFindBy(id = "com.sebbia.delivery:id/editText")
    private AndroidElement phoneField;

    @AndroidFindBy(id = "com.sebbia.delivery:id/sendPhoneConfirmationCodeButton")
    private AndroidElement codeField;

    @AndroidFindBy(id = "com.sebbia.delivery:id/positiveButton")
    private AndroidElement positiveButton;

    @AndroidFindBy(id = "com.sebbia.delivery:id/phoneConfirmationCodeField")
    private AndroidElement confirmationField;

    @AndroidFindBy(id = "com.sebbia.delivery:id/messageView")
    private AndroidElement assertText;

    @AndroidFindBy(id = "com.sebbia.delivery:id/termsCheckbox")
    private AndroidElement agreeCheckBox;

    @AndroidFindBy(id = "com.sebbia.delivery:id/nextButton")
    private AndroidElement nextButton;

    private static final String SMS_WITH_CODE = "Смс с кодом";

    /**
     * Instantiates a new Register page.
     *
     * @param driver the driver
     */
    public RegisterPage(AndroidDriver<WebElement> driver) {
        super(driver);
    }

    /**
     * Register user register page.
     *
     * @return the register page
     */
    public RegisterPage registerUser() {
        phoneField.sendKeys(createPhoneNumber());
        codeField.click();
        Assert.assertTrue(assertText.getText().contains(SMS_WITH_CODE));
        positiveButton.click();
        confirmationField.sendKeys(createCode());
        agreeCheckBox.click();
        nextButton.click();
        return this;
    }
}
