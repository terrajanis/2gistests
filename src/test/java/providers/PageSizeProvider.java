package providers;

import org.testng.annotations.DataProvider;

public class PageSizeProvider {


    @DataProvider(name = "negativePageSizeProvider")
    public Object[][] negativePageProvider() {
        return new Object[][]{
                {0},
                {-1},
                {16},
                {4}
        };
    }

    @DataProvider(name = "negativeIntegerPageSizeProvider")
    public Object[][] negativeIntegerPageProvider() {
        return new Object[][]{
                {""},
                {1.5},
                {"абв"}
        };
    }
}
