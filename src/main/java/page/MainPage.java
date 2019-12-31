package page;

import com.sun.istack.internal.NotNull;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
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

    @AndroidFindBy(id = "com.sebbia.delivery:id/editText")
    private AndroidElement phoneField;

    @AndroidFindBy(id = "com.sebbia.delivery:id/passwordEditText")
    private AndroidElement passwordField;

    @AndroidFindBy(id = "com.sebbia.delivery:id/forgotPasswordButton")
    private AndroidElement forgotPasswordField;

    @AndroidFindBy(id = "com.sebbia.delivery:id/messageView")
    private AndroidElement assertText;

    @AndroidFindBy(id = "com.sebbia.delivery:id/signInButton")
    private AndroidElement sigInButton;

    @AndroidFindBy(className = "android.widget.ImageView")
    private AndroidElement backButton;

    @AndroidFindBy(id = "com.sebbia.delivery:id/sendPhoneConfirmationCodeButton")
    private AndroidElement codeField;

    @AndroidFindBy(id = "com.sebbia.delivery:id/termsCheckbox")
    private AndroidElement agreeCheckBox;

    @AndroidFindBy(id = "com.sebbia.delivery:id/phoneConfirmationCodeField")
    private AndroidElement confirmationField;

    @AndroidFindBy(id = "com.sebbia.delivery:id/nextButton")
    private AndroidElement nextButton;

    @AndroidFindBy(id = "com.sebbia.delivery:id/surnameEditText")
    private AndroidElement surnameField;

    @AndroidFindBy(id = "com.sebbia.delivery:id/nameEditText")
    private AndroidElement nameField;

    @AndroidFindBy(id = "com.sebbia.delivery:id/middleNameEditText")
    private AndroidElement middleNameField;

    @AndroidFindBy(id = "com.sebbia.delivery:id/birthDateEditText")
    private AndroidElement dateOfBirth;

    @AndroidFindBy(id = "com.sebbia.delivery:id/emailEditText")
    private AndroidElement emailField;

    @AndroidFindBy(id = "com.sebbia.delivery:id/uploadFacePlaceholder")
    private AndroidElement uploadFile;

    @AndroidFindBy(id = "android:id/button1")
    private AndroidElement accept;

    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
    private AndroidElement allow;

    @AndroidFindBy(className = "android.widget.RadioButton")
    private AndroidElement typeOfDelivery;

    @AndroidFindBy(id = "com.sebbia.delivery:id/take_picture")
    private AndroidElement takePhoto;

    public MainPage(AndroidDriver<AndroidElement> driver) {
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

    public RegisterPage clickRegister(){
        registerField.click();
        return new RegisterPage(driver);
    }

    public MainPage checkAssertMessage() {
        Waiters waiters = new Waiters(driver);
        Assert.assertTrue(assertText.getText().contains(SMS_WITH_CODE));
        waiters.waitForVisibilityOf(regionOK).click();
        waiters.waitForVisibilityOf(sigInButton).click();
        Assert.assertTrue(assertText.getText().contains(NOT_CODE));
        regionOK.click();
        backButton.click();
        return this;
    }

    public MainPage registerUser() {
        phoneField.sendKeys(createPhoneNumber());
        codeField.click();
        Assert.assertTrue(assertText.getText().contains(SMS_WITH_CODE));
        regionOK.click();
        confirmationField.sendKeys(createCode());
        agreeCheckBox.click();
        nextButton.click();
        return this;
    }

    public MainPage enterRegisterData() throws IOException {
        surnameField.sendKeys(FIRST_NAME);
        nameField.sendKeys(NAME);
        middleNameField.sendKeys(MIDDLE_NAME);
        dateOfBirth.sendKeys(BIRTH);
        emailField.sendKeys(createEmail());
        nextButton.click();
        uploadFile.click();
        accept.click();
        allow.click();
        allow.click();
        takePhoto.click();
        backButton.click();
        nextButton.click();
        typeOfDelivery.click();
        return this;
    }

    /**
     * Generate random email.
     *
     * @return the authorization page
     */
    @NotNull
    private static String createEmail() {
        final String todayData = String.valueOf(new Date().getTime());

        return "hf_test" + todayData + "@qa.team";
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

    @NotNull
    private static String createCode() {
        Random rand = new Random();
        int number = rand.nextInt(10000);
        DecimalFormat decimalFormat = new DecimalFormat("0000");
        String code = decimalFormat.format(number);

        return code;
    }


}
