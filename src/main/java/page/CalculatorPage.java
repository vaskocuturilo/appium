package page;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import static org.testng.AssertJUnit.assertEquals;

/**
 * The type Calculator page.
 */
@SuppressWarnings("PMD.BeanMembersShouldSerialize")
public class CalculatorPage extends PageObject {

    /**
     * FindBy numberNine.
     */
    @AndroidFindBy(id = "com.android.calculator2:id/digit_9")
    private AndroidElement numberNine;

    /**
     * FindBy buttonPlus.
     */
    @AndroidFindBy(id = "com.android.calculator2:id/op_add")
    private AndroidElement buttonPlus;

    /**
     * FindBy numberThree.
     */
    @AndroidFindBy(id = "com.android.calculator2:id/digit_3")
    private AndroidElement numberThree;

    /**
     * FindBy buttonEquals.
     */
    @AndroidFindBy(id = "com.android.calculator2:id/eq")
    private AndroidElement buttonEquals;

    /**
     * FindBy resultForm.
     */
    @AndroidFindBy(id = "com.android.calculator2:id/result")
    private AndroidElement resultForm;

    /**
     * Instantiates a new Calculator page.
     *
     * @param driver the driver
     */
    public CalculatorPage(final AndroidDriver<AndroidElement> driver) {
        super(driver);
    }


    /**
     * Add numbers calculator page.
     *
     * @return the calculator page
     */
    public CalculatorPage addNumbers() {
        numberNine.click();
        buttonPlus.click();
        numberThree.click();
        buttonEquals.click();

        return this;
    }

    /**
     * Assert result calculator page.
     *
     * @return the calculator page
     */
    public CalculatorPage assertResult() {
        assertEquals("12", resultForm.getText());
        return this;
    }

}
