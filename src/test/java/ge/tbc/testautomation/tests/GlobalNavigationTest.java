package ge.tbc.testautomation.tests;

import ge.tbc.testautomation.data.DataSupplier;
import ge.tbc.testautomation.runners.BaseTest;
import org.testng.annotations.Test;

public class GlobalNavigationTest extends BaseTest {
    @Test(priority = 1)
    public void openUrl(){
        homeSteps.openURL();
    }

    @Test(priority = 2, dataProvider = "breadcrumbData", dataProviderClass = DataSupplier.class)
    public void breadcrumbTest(String[] expectedTexts ){
        homeSteps.navigateToConsumerPage();
        consumerSteps.checkTitle()
                .validateBreadcrumbTexts(expectedTexts);
    }

}

