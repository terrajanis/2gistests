package providers;

import org.testng.annotations.DataProvider;

public class CountryCodeProvider {

    @DataProvider(name = "negativeCountryCodeProvider")
    public Object[][] negativeCountryCodeProvider() {
        return new Object[][]{
                {"by"},
                {"ру"},
                {""}
        };
    }
}
