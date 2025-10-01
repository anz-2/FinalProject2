package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import ge.tbc.testautomation.pages.AllOffersPage;
import ge.tbc.testautomation.pages.OffersPage;


public class OffersSteps {
    Page page;
    OffersPage offersPage;
    AllOffersPage allOffersPage;

    public OffersSteps(Page page) {
        this.page = page;
        this.offersPage = new OffersPage(page);
        this.allOffersPage = new AllOffersPage(page);
    }


    //navigateToAllOffers
    public OffersSteps navigateToAllOffers() {
        offersPage.allOffersBtn.click();
        return this;
    }

    public OffersSteps checkOfferPageTitle() {
        PlaywrightAssertions.assertThat(allOffersPage.allOffersPageTitle).isVisible();
        return this;
    }


}
