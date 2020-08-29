package providers;

import org.testng.annotations.DataProvider;

public class PageProvider {

    @DataProvider(name = "negativePageProvider")
    public Object[][] negativePageProvider() {
        return new Object[][]{
                {""},
                {"1.5"},
                {"абв"},
        };
    }

    @DataProvider(name = "lessThanZeroPageProvider")
    public Object[][] lessThanZeroPageProvider() {
        return new Object[][]{
                {0},
                {-1}
        };
    }
}
