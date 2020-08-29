package providers;

import org.testng.annotations.DataProvider;

public class MultiParametersProvider {

    @DataProvider(name = "fuzzySearchCountryCodeMultiProvider")
    public Object[][] fuzzySearchCountryCodeMultiProvider() {
        return new Object[][]{
                {"Магнитогорск", "ru"},
                {"Магнитогорск", "kz"},
                {"Магнитогорск", "kg"},
                {"Магнитогорск", "cz"}
        };
    }

    @DataProvider(name = "fuzzySearchPageMultiProvider")
    public Object[][] fuzzySearchPageMultiProvider() {
        return new Object[][]{
                {"Магнитогорск", -1},
                {"Магнитогорск", 0},
                {"Магнитогорск", 1},
                {"Магнитогорск", 5}
        };
    }

    @DataProvider(name = "fuzzySearchPageSizeMultiProvider")
    public Object[][] fuzzySearchPageSizeMultiProvider() {
        return new Object[][]{
                {"Магнитогорск", -1},
                {"Магнитогорск", 0},
                {"Магнитогорск", 5},
                {"Магнитогорск", 10},
                {"Магнитогорск", 15},
                {"Магнитогорск", 25}
        };
    }

}
