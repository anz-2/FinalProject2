package ge.tbc.testautomation.runners;

import com.microsoft.playwright.*;
import ge.tbc.testautomation.steps.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.Arrays;
import java.util.Collections;


public class BaseTest {
    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext browserContext;
    protected Page page;
    protected AddressSteps addressSteps;
    protected AllOffersSteps allOffersSteps;
    protected ConsumerSteps consumerSteps;
    protected CurrencySteps currencySteps;
    protected HomeSteps homeSteps;
    protected OffersSteps offersSteps;

    int width;
    int height;


    @BeforeClass
    @Parameters({"browserType", "width", "height"})
    public void setUp(String browserType,
                      @Optional("1920") int width,
                      @Optional("1080") int height) {
        this.width = width;
        this.height = height;

        playwright = Playwright.create();
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
        launchOptions.setArgs(Arrays.asList("--no-sandbox", "--disable-gpu", "--disable-extensions"));
        launchOptions.setHeadless(false);
        launchOptions.setSlowMo(1000);
        launchOptions.setTimeout(20000);

        if (browserType.equals("chromium")){
            browser = playwright.chromium().launch(launchOptions);
        } else if (browserType.equals("firefox")) {
            browser = playwright.firefox().launch(launchOptions);
        } else {
            browser = playwright.webkit().launch(launchOptions);
        }

        browserContext = browser.newContext(new Browser.NewContextOptions()
                .setViewportSize(width, height)
                .setPermissions(Collections.emptyList())
        );
        page = browserContext.newPage();
        page.setDefaultTimeout(10000);
        addressSteps = new AddressSteps(page);
        allOffersSteps = new AllOffersSteps(page);
        consumerSteps = new ConsumerSteps(page);
        currencySteps = new CurrencySteps(page);
        homeSteps = new HomeSteps(page);
        offersSteps = new OffersSteps(page);
    }


     @AfterClass
     public void tearDown() {
         page.close();
         browserContext.close();
         browser.close();
         playwright.close();
     }
}
