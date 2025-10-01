package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;

public class CurrencyPage {
    public Locator currencyInput;
    public Locator USDCurrency;
    public Locator totalAmount;

    public CurrencyPage(Page page){
        this.currencyInput = page.locator("//tbcx-input-with-selector[@formcontrolname='iso1']//input[@type='number']");
        this.USDCurrency = page.locator("//tbcx-pw-popular-currency-item[.//div[normalize-space()='USD']]//div[normalize-space()='ყიდვა']/following-sibling::div[@class='tbcx-pw-popular-currencies__body']");
        this.totalAmount = page.locator("//tbcx-input-with-selector[@formcontrolname='iso2']//input[@type='number']");
    }
}
