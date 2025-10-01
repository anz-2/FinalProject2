package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import ge.tbc.testautomation.data.Constants;
import ge.tbc.testautomation.pages.ConsumerPage;
import ge.tbc.testautomation.utils.ScreenHelper;


import java.nio.file.Path;
import java.nio.file.Paths;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.testng.Assert.assertEquals;

public class ConsumerSteps {
    Page page;
    public ConsumerPage consumerPage;
    ScreenHelper screenHelper;

    public ConsumerSteps(Page page) {
        this.page = page;
        this.consumerPage = new ConsumerPage(page);
        this.screenHelper = new ScreenHelper();
    }


    //checkTitle
    public ConsumerSteps checkTitle() {
        assertThat(consumerPage.pageTitle).isVisible();
        return this;
    }

    //validateBreadcrumbTexts
    public ConsumerSteps validateBreadcrumbTexts(String[] expectedTexts) {

        if (screenHelper.getWidth() == Constants.MOBILE_WIDTH && screenHelper.getHeight() == Constants.MOBILE_HEIGHT) {
            assertThat(consumerPage.pageTitle).isVisible();
            assertThat(consumerPage.breadcrumbsMobile).isVisible();
        }else{
            assertEquals(consumerPage.breadcrumb.count(), expectedTexts.length);
            for (int i = 0; i < expectedTexts.length; i++) {
                String actualText = consumerPage.breadcrumb.nth(i).textContent().trim();
                assertEquals(actualText, expectedTexts[i]);
            }
        }
        return this;
    }


    public ConsumerSteps validateConsumerPageVisual() {
        assertThat(consumerPage.pageTitle).isVisible();

        Path screenshotPath = Paths.get("screenshots", "consumer_page_title.png");
        consumerPage.pageTitle.screenshot(
                new Locator.ScreenshotOptions()
                        .setPath(screenshotPath)
        );
        return this;
    }
}
