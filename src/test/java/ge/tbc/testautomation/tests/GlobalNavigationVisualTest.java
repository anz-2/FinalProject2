package ge.tbc.testautomation.tests;

import ge.tbc.testautomation.runners.BaseTest;
import org.testng.annotations.Test;

public class GlobalNavigationVisualTest extends BaseTest {
    @Test(priority = 1)
    public void openUrl() {
        homeSteps.openURL();
    }

    @Test(priority = 2)
    public void breadcrumbVisualTest() {
        homeSteps.navigateToConsumerPage();
        consumerSteps.validateConsumerPageVisual();
    }

}
