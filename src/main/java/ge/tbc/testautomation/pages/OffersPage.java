package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;


public class OffersPage {
    public Locator offersPageTitle;
    public Locator allOffersBtn;

    public OffersPage(Page page){
        this.offersPageTitle = page.locator("//h2[normalize-space()='ისარგებლე ახალი თიბისი ბარათების შეთავაზებებით']");
        this.allOffersBtn = page.locator("//div[contains(@class, 'tbcx-pw-hero-slider-section__slide-content')]//button[text()='ვრცლად']");
    }
}
