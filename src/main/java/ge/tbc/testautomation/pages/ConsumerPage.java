package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;


public class ConsumerPage {
    public Locator breadcrumb;
    public Locator breadcrumbsMobile;
    public Locator pageTitle;

    public ConsumerPage(Page page){
        this.breadcrumb = page.locator("ul.tbcx-pw-breadcrumbs__items li.tbcx-pw-breadcrumbs__item a");
        this.breadcrumbsMobile = page.locator("//a[contains(normalize-space(text()), 'სესხები')]");
        this.pageTitle = page.locator("//h1[normalize-space(text())='სამომხმარებლო სესხი']");
    }
}
