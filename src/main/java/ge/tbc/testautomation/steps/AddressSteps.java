package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import ge.tbc.testautomation.data.Constants;
import ge.tbc.testautomation.pages.AddressPage;
import org.testng.Assert;

import java.util.List;
import java.util.regex.Pattern;

public class AddressSteps {
    Page page;
    AddressPage addressPage;

    public  AddressSteps(Page page){
        this.page = page;
        this.addressPage = new AddressPage(page);
    }

    public AddressSteps checkAddressPageTitle() {
        PlaywrightAssertions.assertThat(addressPage.pageTitle).isVisible();
        return this;
    }

    // validateBranch
    public AddressSteps validateBranchBtn(){
        PlaywrightAssertions.assertThat(addressPage.branchBtn).hasClass(Pattern.compile(".*active.*"));
        PlaywrightAssertions.assertThat(addressPage.branchBtn).hasCSS("border-bottom-color", Constants.ACTIVE_STATE_COLOR);
        return this;
    }

    public AddressSteps validateAddressTab(){
        PlaywrightAssertions.assertThat(addressPage.addressTab).isVisible();
        PlaywrightAssertions.assertThat(addressPage.addressTab).isEnabled();
        return this;
    }

    // checkPageTitle
    public AddressSteps checkPageTitle(){
        PlaywrightAssertions.assertThat(addressPage.pageTitle).isVisible();
        return this;
    }

    // verifyMapShowsTbilisi
    public AddressSteps verifyMapShowsTbilisi() {
        PlaywrightAssertions.assertThat(addressPage.mapLink).isVisible();
        PlaywrightAssertions.assertThat(addressPage.mapLink).hasAttribute("href", Pattern.compile(".*41\\.7.*44\\.6.*"));
        return this;
    }

    // validateLocations
    public AddressSteps fillLocationInput(){
        addressPage.locationInput.fill(Constants.LOCATION_INPUT);
        return this;
    }

    public AddressSteps checkAddressTab(){
        PlaywrightAssertions.assertThat(addressPage.addressTab).isVisible();
        return this;
    }

    public AddressSteps checkLocationList(){
        List<String> actualLocations = addressPage.locationList.allTextContents();
        boolean found = actualLocations.stream().anyMatch(loc -> loc.contains(Constants.LOCATION_INPUT));
        Assert.assertTrue(found);
        return this;
    }

    public AddressSteps checkLocationMarkers(){
        addressPage.locationMarkers.first().waitFor();
        int markerCount = addressPage.locationMarkers.count();
        for (int i = 0; i < markerCount; i++) {
            PlaywrightAssertions.assertThat(addressPage.locationMarkers.nth(i))
                    .isVisible();
        }
        return this;
    }


    public AddressSteps fillLocationInput(String area){
        addressPage.locationInput.fill(area);
        return this;
    }

    public AddressSteps checkLocationList(String area, int expectedMinResults){
        List<String> actualLocations = addressPage.locationList.allTextContents();
        boolean found = actualLocations.stream().anyMatch(loc -> loc.contains(area));
        Assert.assertTrue(found);
        Assert.assertTrue(actualLocations.size() >= expectedMinResults);
        return this;
    }

}
