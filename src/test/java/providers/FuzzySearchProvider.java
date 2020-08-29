package providers;

import org.testng.annotations.DataProvider;

public class FuzzySearchProvider {

    @DataProvider(name = "positiveProviderMagnitogorsk")
    public Object[][] fuzzySearchPositiveProviderForMagnitogorsk() {
        return new Object[][]{
                {"маг"},
                {"орск"},
                {"нитог"},
                {"Магнитогорск"},
                {"магнитогорск"},
                {"МАГНИТОГОРСК"}
        };
    }

    @DataProvider(name = "positiveProviderTwoCities")
    public Object[][] fuzzySearchPositiveProviderForTwoCities() {
        return new Object[][]{
                {"вла"}
        };
    }

    @DataProvider(name = "positiveProviderHyphen")
    public Object[][] fuzzySearchPositiveProviderForHyphen() {
        return new Object[][]{
                {"Усть-Каменогорск"},
                {"ть-кам"}
        };
    }
    @DataProvider(name = "positiveProviderSpace")
    public Object[][] fuzzySearchPositiveProviderForSpace() {
        return new Object[][]{
                {"Нижний Новгород"},
                {"ий нов"}
        };
    }

    @DataProvider(name = "providerEmptyResponse")
    public Object[][] fuzzySearchEmptyResponseProvider() {
        return new Object[][]{
                {"Magnitogorsk"},
                {"ррррььь"},
                {"$$$$"}
        };
    }

    @DataProvider(name = "negativeProvider")
    public Object[][] fuzzySearchNegativeProvider() {
        return new Object[][]{
                {""},
                {"м"},
                {"ма"}
        };
    }


}
