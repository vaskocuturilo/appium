package tests;

import base.BaseClass;
import org.testng.annotations.Test;
import page.CalculatorPage;

public class AppiumTest extends BaseClass {

    @Test(description = "Test example for android application calculator.")
    public void openCalculator() {
        CalculatorPage calculatorPage = new CalculatorPage(getDriver());
        calculatorPage.addNumbers();
    }


}
