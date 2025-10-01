package ge.tbc.testautomation.data;

import org.testng.annotations.DataProvider;

public class DataSupplier {
    @DataProvider(name = "breadcrumbData")
    public static Object[][] breadcrumbData() {
        return new Object[][]{
                {new String[]{"მთავარი", "სესხები", "სამომხმარებლო სესხი"}}
        };
    }

    @DataProvider(name = "houseOffers")
    public Object[][] houseOffers() {
        return new Object[][] {
                {new String[]{"არომაკო", "ბერგჰოფ", "ბრენდ არ"}}
        };
    }
}
