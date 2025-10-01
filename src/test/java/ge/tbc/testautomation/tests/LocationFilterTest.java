package ge.tbc.testautomation.tests;

import ge.tbc.testautomation.runners.BaseTest;
import org.testng.annotations.Test;

public class LocationFilterTest extends BaseTest {
    @Test(priority = 1)
    public void openURL(){
        homeSteps.openURL();
    }

    @Test(priority = 2)
    public void navigateToAddressPage(){
        homeSteps.detectDevice()
                .clickOnAddressBtn();
    }

    @Test(priority = 3)
    public void validateLocations(){
        addressSteps.fillLocationInput()
                .checkAddressTab()
                .checkLocationList()
                .checkLocationMarkers();
    }
}
