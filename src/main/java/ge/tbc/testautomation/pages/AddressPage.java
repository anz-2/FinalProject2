package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;


public class AddressPage {
    public com.microsoft.playwright.Locator branchBtn;
    public Locator addressTab;
    public Locator pageTitle;
    public Locator mapLink;
    public Locator locationInput;
    public Locator locationMarkers;
    public Locator locationList;

    public AddressPage(Page page){
        this.branchBtn = page.locator("//button[span[text()='ყველა']]");
        this.addressTab = page.locator("//div[@class='tbcx-pw-atm-branches-section__list-wrapper']");
        this.pageTitle = page.locator("//h2[@class='tbcx-pw-atm-branches-section__title tbcx-pw-title']");
        this.mapLink = page.locator("a[title*='Google Maps']");
        this.locationInput = page.locator("//input[@placeholder='მიუთითე სასურველი ლოკაცია']");
        this.locationMarkers = page.locator("//gmp-advanced-marker[@class='yNHHyP-marker-view']");
        this.locationList = page.locator("//div[@class='tbcx-pw-atm-branches-section__list-item-title tbcx-pw-title']");
    }


}
