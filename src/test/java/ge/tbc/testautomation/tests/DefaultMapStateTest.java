package ge.tbc.testautomation.tests;

import ge.tbc.testautomation.runners.BaseTest;
import org.testng.annotations.Test;

public class DefaultMapStateTest extends BaseTest {
    @Test(priority = 1)
    public void openURL() {
        homeSteps.openURL();
    }

    @Test(priority = 2)
    public void navigateToAddressPage() {
        homeSteps.detectDevice()
                .clickOnAddressBtn();
        addressSteps.checkAddressPageTitle();
    }

    @Test(priority = 3)
    public void validateBranch() {
        addressSteps.validateBranchBtn()
                .validateAddressTab();
    }

    @Test(priority = 4)
    public void verifyMapCenteredOnTbilisiOrUser() {
        addressSteps.verifyMapShowsTbilisi();
    }
}
