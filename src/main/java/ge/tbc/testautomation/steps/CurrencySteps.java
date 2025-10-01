package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Page;
import ge.tbc.testautomation.data.Constants;
import ge.tbc.testautomation.pages.CurrencyPage;

import static org.testng.Assert.assertEquals;

public class CurrencySteps {
    Page page;
    CurrencyPage currencyPage;

    public CurrencySteps(Page page) {
        this.page = page;
        this.currencyPage = new CurrencyPage(page);
    }

    //checkConvertedAmount
    public CurrencySteps clearInput() {
        currencyPage.currencyInput.clear();
        return this;
    }

    public CurrencySteps fillInput() {
        currencyPage.currencyInput.fill(Constants.CURRENCY_INPUT);
        return this;
    }

    public CurrencySteps checkInputValues() {
        String usdText = currencyPage.USDCurrency.textContent().trim();
        double usdRate = Double.parseDouble(usdText);
        double inputAmount = Double.parseDouble(Constants.CURRENCY_INPUT);
        double expected = inputAmount * usdRate;
        double actual = Double.parseDouble(currencyPage.totalAmount.inputValue().trim());
        assertEquals(expected, actual, 0.2);
        return  this;
    }
}
