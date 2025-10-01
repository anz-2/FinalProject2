package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import ge.tbc.testautomation.data.Constants;
import ge.tbc.testautomation.pages.AddressPage;
import ge.tbc.testautomation.pages.HomePage;
import ge.tbc.testautomation.pages.OffersPage;
import ge.tbc.testautomation.utils.ScreenHelper;

public class HomeSteps {
    HomePage homePage;
    Page page;
    ScreenHelper screenHelper;
    AddressPage addressPage;
    OffersPage offersPage;

    public HomeSteps(Page page) {
        this.page = page;
        this.homePage = new HomePage(page);
        this.screenHelper = new ScreenHelper();
        this.addressPage = new AddressPage(page);
        this.offersPage = new OffersPage(page);
    }

    //openURL
    public HomeSteps openURL() {
        page.navigate(Constants.TBC_URL);
        return this;
    }


    //devise detect func
    public HomeSteps detectDevice() {
        screenHelper.getHelperFunc().run(
                () -> homePage.menuBtn.click(),
                () -> homePage.dropdownMenu.hover()
        );
        return this;
    }

    //navigateToAddressPage
    public HomeSteps clickOnAddressBtn() {
        homePage.addressBtn.click();
        return this;
    }

    /*public HomeSteps checkAddressPageTitle() {
        PlaywrightAssertions.assertThat(addressPage.pageTitle).isVisible();
        return this;
    }*/

    //navigateToCurrencyPage
    public HomeSteps clickOnCurrencyBtn() {
        homePage.currencyBtn.click();
        return this;
    }

    /*public HomeSteps checkCurrencyBtn() {
        PlaywrightAssertions.assertThat(homePage.currencyBtn).isVisible();
        return this;
    }*/

    //openSearch
    public HomeSteps checkSearchBtn() {
        PlaywrightAssertions.assertThat(homePage.searchBtn).isVisible();
        return this;
    }

    public HomeSteps clickOnSearchBtn() {
        homePage.searchBtn.click();
        return this;
    }
    public HomeSteps checkSearchInput() {
        PlaywrightAssertions.assertThat(homePage.searchInput).isVisible();
        return this;
    }

    //validateSearchList
    public HomeSteps fillSearchInput() {
        homePage.searchIcon.click();
        homePage.searchInput.fill(Constants.SEARCH_INPUT_TEXT);
        return  this;
    }

    public HomeSteps checkSearchResults() {
        if (homePage.searchResult.count() == 0) {
            PlaywrightAssertions.assertThat(homePage.errorMessage).isVisible();
        } else {
            PlaywrightAssertions.assertThat(homePage.searchResult.nth(0)).isVisible();
            int count = homePage.searchResult.count();
            for (int i = 0; i < count; i++) {
                PlaywrightAssertions.assertThat(homePage.searchResult.nth(i)).isVisible();
            }
        }
        return this;
    }

    //navigateToConsumerPage
    public HomeSteps clickMenuBtnMobile() {
        homePage.menuBtn.click();
        return this;
    }
    public HomeSteps checkConsumerSectionBtn() {
        PlaywrightAssertions.assertThat(homePage.consumerSectionBtn).isVisible();
        return this;
    }
    public HomeSteps clickConsumerSectionBtn() {
        homePage.consumerSectionBtn.click();
        return this;
    }
    public HomeSteps checkConsumerBtn() {
        PlaywrightAssertions.assertThat(homePage.consumerBtn).isVisible();
        return this;
    }
    public HomeSteps clickConsumerBtn() {
        homePage.consumerBtn.click();
        return this;
    }
    public HomeSteps hoverDropdownMenuDesktop() {
        homePage.dropdownMenu.hover();
        return this;
    }

    public HomeSteps navigateToConsumerPage() {
        screenHelper.getHelperFunc().run(
                () -> clickMenuBtnMobile()
                        .checkConsumerSectionBtn()
                        .clickConsumerSectionBtn()
                        .checkConsumerBtn()
                        .clickConsumerBtn(),
                () -> hoverDropdownMenuDesktop()
                        .checkConsumerBtn()
                        .clickConsumerBtn()
        );

        return this;
    }


    //navigateToOffersPage
    public HomeSteps clickOnOffersBtn() {
        homePage.offersBtn.click();
        return this;
    }

    public HomeSteps checkOffersPageTitle() {
        PlaywrightAssertions.assertThat(offersPage.offersPageTitle).isVisible();
        return this;
    }
}
