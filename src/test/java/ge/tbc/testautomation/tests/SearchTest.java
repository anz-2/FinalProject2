package ge.tbc.testautomation.tests;

import ge.tbc.testautomation.runners.BaseTest;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test(priority = 1)
    public void openUrl(){
       homeSteps.openURL();
    }

    @Test(priority = 2)
    public void openSearch(){
        homeSteps.checkSearchBtn()
                .clickOnSearchBtn();
    }

    @Test(priority = 3)
    public void validateSearchList(){
        homeSteps.fillSearchInput()
                .checkSearchResults();
    }
}
