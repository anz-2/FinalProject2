package ge.tbc.testautomation.tests;

import ge.tbc.testautomation.data.DataSupplier;
import ge.tbc.testautomation.runners.BaseTest;
import org.testng.annotations.Test;

public class OffersTest extends BaseTest {
    @Test(priority = 1)
    public void openUrl(){
        homeSteps.openURL();
    }

    @Test(priority = 2)
    public void navigateToOffersPage(){
        homeSteps.detectDevice()
                .clickOnOffersBtn()
                .checkOffersPageTitle();
    }

    @Test(priority = 3)
    public void navigateToAllOffersPage(){
        offersSteps.navigateToAllOffers()
                .checkOfferPageTitle();
    }

    @Test(priority = 4, dataProvider = "houseOffers", dataProviderClass = DataSupplier.class)
    public void testHouseOffers(String[] expectedTitles){
        allOffersSteps.clickHouseCheckbox()
                .validateHouseOfferName(expectedTitles);
    }

    @Test(priority = 5, dataProvider = "houseOffers", dataProviderClass = DataSupplier.class)
    public void testClearBtn(String[] expectedTitles){
        allOffersSteps.clickClearOffersBtn()
                .checkClearedOffers(expectedTitles);
    }
}
