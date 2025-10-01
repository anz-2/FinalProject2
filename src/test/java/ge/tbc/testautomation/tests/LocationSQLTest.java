package ge.tbc.testautomation.tests;

import ge.tbc.testautomation.data.LocationDataProvider;
import ge.tbc.testautomation.runners.BaseTest;
import org.testng.annotations.*;

public class LocationSQLTest extends BaseTest {
    @Test(priority = 1)
    public void openURL() {
        homeSteps.openURL();
    }

    @Test(priority = 2)
    public void navigateToAddressPage() {
        homeSteps.detectDevice()
                .clickOnAddressBtn();
    }

    @Test(priority = 3, dataProvider = "locationData", dataProviderClass = LocationDataProvider.class)
    public void validateLocations(String area, Integer expectedMinResults) {
        addressSteps.fillLocationInput(area)
                .checkAddressTab()
                .checkLocationList(area, expectedMinResults)
                .checkLocationMarkers();
    }
}
