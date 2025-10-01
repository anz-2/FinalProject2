package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomePage {
    public Locator dropdownMenu;
    public Locator addressBtn;
    public Locator currencyBtn;
    public Locator searchBtn;
    public Locator searchInput;
    public Locator errorMessage;
    public Locator searchResult;
    public Locator consumerBtn;
    public Locator offersBtn;
    public Locator menuBtn;
    public Locator consumerSectionBtn;
    public Locator searchIcon;

    public HomePage(Page page){
        this.dropdownMenu = page.locator("//div[@tbcxpwlinklabel and normalize-space()='ჩემთვის']");
        this.addressBtn = page.locator("//span[normalize-space()='მისამართები']");
        this.currencyBtn = page.locator("//span[normalize-space()='ვალუტის კურსები']");
        this.searchBtn = page.locator("//div[contains(@class,'tbcx-pw-header__actions__row')]//button[contains(@class,'tbcx-pw-search__button')]");
        this.errorMessage = page.locator("//p[@class='global-search__bottom-content__container__not-fount-result__title tbcx-pw-title']");
        this.searchInput = page.locator("//input[@class='input ng-pristine ng-valid ng-touched']");
        this.searchResult = page.locator("//div[contains(@class, 'global-search__top-content__searchbar')]//input[@type='text']");
        this.consumerBtn = page.locator("//span[normalize-space(text())='სამომხმარებლო']");
        this.offersBtn = page.locator("//span[normalize-space()='შეთავაზებები']");
        this.menuBtn = page.locator("//div[contains(@class,'tbcx-pw-hamburger-menu')]//button[contains(@class,'tbcx-pw-hamburger-menu__button')]");
        this.consumerSectionBtn = page.locator("//span[text()='სესხები']");
        this.searchIcon = page.locator("//div[@class='lead-slot-wrapper lead-slot-exists']");
    }
}
