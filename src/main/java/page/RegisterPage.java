package page;

import com.google.gson.Gson;
import data.RegisterUserData;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.PropertiesReader;

import static java.lang.String.format;
import static utils.Code.createCode;
import static utils.Phone.createPhoneNumber;

/**
 * The class RegisterPage.
 */
public class RegisterPage extends PageObject {
    /**
     * The findBy phoneField.
     */
    @AndroidFindBy(id = "com.sebbia.delivery:id/editText")
    private AndroidElement phoneField;

    /**
     * The findBy getCode.
     */
    @AndroidFindBy(id = "com.sebbia.delivery:id/sendPhoneConfirmationCodeButton")
    private AndroidElement getCode;

    /**
     * The findBy okButtonOnConfirmationForm.
     */
    @AndroidFindBy(id = "com.sebbia.delivery:id/positiveButton")
    private AndroidElement okButtonOnConfirmationForm;

    /**
     * The findBy addCode.
     */
    @AndroidFindBy(id = "com.sebbia.delivery:id/phoneConfirmationCodeField")
    private AndroidElement addCode;

    /**
     * The findBy contentText.
     */
    @AndroidFindBy(id = "com.sebbia.delivery:id/messageView")
    private AndroidElement contentText;

    /**
     * The findBy agreeWithTerms.
     */
    @AndroidFindBy(id = "com.sebbia.delivery:id/termsCheckbox")
    private AndroidElement agreeWithTerms;

    /**
     * The findBy nextPage.
     */
    @AndroidFindBy(id = "com.sebbia.delivery:id/nextButton")
    private AndroidElement nextPage;

    /**
     * The findBy lastName.
     */
    @AndroidFindBy(id = "com.sebbia.delivery:id/surnameEditText")
    private MobileElement lastName;

    /**
     * The findBy firstName.
     */
    @AndroidFindBy(id = "com.sebbia.delivery:id/nameEditText")
    private MobileElement firstName;

    /**
     * The findBy middleName.
     */
    @AndroidFindBy(id = "com.sebbia.delivery:id/middleNameEditText")
    private MobileElement middleName;

    /**
     * The findBy birthDate.
     */
    @AndroidFindBy(id = "com.sebbia.delivery:id/birthDateEditText")
    private MobileElement birthDate;

    /**
     * The findBy email.
     */
    @AndroidFindBy(id = "com.sebbia.delivery:id/emailEditText")
    private MobileElement email;

    /**
     * The constructor.
     *
     * @param driver the driver
     */
    public RegisterPage(final AndroidDriver<WebElement> driver) {
        super(driver);
    }

    /**
     * The method registerUser.
     *
     * @return the register page
     */
    public RegisterPage registerUser() {
        phoneField.sendKeys(createPhoneNumber());
        addCode.sendKeys(createCode());
        agreeWithTerms.click();
        nextPage.click();

        return this;
    }

    /**
     * The method clickRegisterButton.
     *
     * @return the register page
     */
    public RegisterPage clickRegisterButton() {
        phoneField.setValue(createPhoneNumber());
        getCode.click();
        Assert.assertTrue(contentText.isDisplayed());
        okButtonOnConfirmationForm.click();
        addCode.setValue(createCode());
        agreeWithTerms.click();
        nextPage.click();


        return this;
    }


    /**
     * The method checkRequiredField.
     *
     * @return the register page.
     */
    public RegisterPage checkRequiredField() {
        nextPage.click();
        Assert.assertTrue(contentText.isDisplayed());
        okButtonOnConfirmationForm.click();

        return this;
    }


    /**
     * The method addedRegisterData.
     *
     * @param jsonFileName the json file name.
     * @return the register page.
     */
    public RegisterPage addedRegisterData(final String jsonFileName) {
        final RegisterUserData registerUserData = getJsonData(jsonFileName);
        lastName.setValue(registerUserData.getLastName());
        firstName.setValue(registerUserData.getFirstName());
        middleName.setValue(registerUserData.getMiddleName());
        birthDate.setValue(registerUserData.getBirthDate());
        email.setValue(registerUserData.getEmail());
        nextPage.click();

        return this;
    }

    /**
     * The method getJsonData.
     *
     * @param jsonFileName path to file.
     * @return new Gson.
     */
    private static RegisterUserData getJsonData(final String jsonFileName) {
        final String pathToFolder = PropertiesReader.getResourceAsString(format("user/%s.json", jsonFileName));

        return new Gson().fromJson(pathToFolder, RegisterUserData.class);
    }
}
