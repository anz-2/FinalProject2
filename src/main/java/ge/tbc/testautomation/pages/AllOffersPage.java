package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class AllOffersPage {
    public Locator allOffersPageTitle;
    public Locator houseCheckbox;
    public Locator offers;
    public Locator offerName;
    public Locator clearBtn;

    public AllOffersPage(Page page){
        this.allOffersPageTitle = page.locator("//h2[normalize-space()='შეთავაზებები']");
        this.houseCheckbox = page.locator("//div[@class='filter-item ng-star-inserted' and normalize-space()='სახლი']");
        this.offers = page.locator("//div[@class='tbcx-pw-card tbcx-pw-card--background-visible ng-star-inserted']");
        this.offerName = page.locator("//h3[@class='tbcx-pw-card__title tbcx-pw-title ng-star-inserted']");
        this.clearBtn = page.locator("//div[h3[normalize-space(text())='კატეგორია']]/button");
    }
}
