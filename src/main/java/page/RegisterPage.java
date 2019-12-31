package page;

import com.sun.istack.internal.NotNull;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.testng.Assert;

import java.text.DecimalFormat;
import java.util.Random;

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

    public RegisterPage(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

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

    @NotNull
    private static String createCode() {
        Random rand = new Random();
        int number = rand.nextInt(10000);
        DecimalFormat decimalFormat = new DecimalFormat("0000");
        String code = decimalFormat.format(number);

        return code;
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
