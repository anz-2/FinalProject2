package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Page;
import ge.tbc.testautomation.pages.AllOffersPage;

import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class AllOffersSteps {
    Page page;
    AllOffersPage allOffersPage;

    public AllOffersSteps(Page page){
        this.page = page;
        this.allOffersPage = new AllOffersPage(page);
    }

    //validateHouseOffers
    public AllOffersSteps clickHouseCheckbox(){
        allOffersPage.houseCheckbox.click();
        return this;
    }

    public void checkOffers(){
        int offerCount = allOffersPage.offers.count();
        for (int i = 0; i < offerCount; i++) {
            assertThat(allOffersPage.offers.nth(i)).isVisible();
        }
    }

    public AllOffersSteps validateHouseOfferName(String[] expectedTitles){
        checkOffers();
        List<String> offerNamesOnPage = allOffersPage.offerName.allTextContents();
        for (String expectedTitle : expectedTitles) {
            assertTrue(offerNamesOnPage.stream().anyMatch(text -> text.contains(expectedTitle)));
        }
        return this;
    }

    public AllOffersSteps checkClearedOffers(String[] expectedTitles) {
        checkOffers();
        List<String> offerNamesOnPage = allOffersPage.offerName.allTextContents();
        for (String expectedTitle : expectedTitles) {
            assertFalse(offerNamesOnPage.stream().anyMatch(text -> text.contains(expectedTitle)));
        }
        return this;
    }

    public AllOffersSteps clickClearOffersBtn(){
        allOffersPage.clearBtn.click();
        return this;
    }

    /*public AllOffersSteps checkOffersAreCleared (){
        int offerCount = allOffersPage.offers.count();
        for (int i = 0; i < offerCount; i++) {
            assertThat(allOffersPage.offers.nth(i)).isVisible();
        }
        return this;
    }*/

}
