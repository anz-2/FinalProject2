package ge.tbc.testautomation.tests;

import ge.tbc.testautomation.runners.BaseTest;
import org.testng.annotations.Test;

public class CurrencyExchangeTest extends BaseTest {
    @Test(priority = 1)
    public void openURL(){
        homeSteps.openURL();
    }

    @Test(priority = 2)
    public void navigateToCurrencyPage(){
        homeSteps.detectDevice()
                .clickOnCurrencyBtn();
    }

    @Test(priority = 3)
    public void validateCurrencyInput(){
        currencySteps.clearInput()
                .fillInput()
                .checkInputValues();
    }
}
