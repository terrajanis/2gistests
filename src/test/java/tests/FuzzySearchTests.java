package tests;

import org.testng.annotations.Test;
import providers.FuzzySearchProvider;
import providers.MultiParametersProvider;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class FuzzySearchTests extends TestBase {


    @Test(dataProvider = "positiveProviderMagnitogorsk", dataProviderClass = FuzzySearchProvider.class)
    public void fuzzySearchPositiveTest(String value) {

        given().
                param("q", value).
                when().
                get(baseUrl).
                then().
                statusCode(200).
                body("total", equalTo(1)).
                body("items[0]", hasKey("id")).
                body("items[0].name", equalTo("Магнитогорск")).
                body("items[0].code", equalTo("magnitogorsk")).
                body("items[0].country.name", equalTo("Россия")).
                body("items[0].country.code ", equalTo("ru"));

    }

    @Test(dataProvider = "positiveProviderTwoCities", dataProviderClass = FuzzySearchProvider.class)
    public void fuzzySearchTwoCitiesTest(String value) {

        given().
                param("q", value).
                when().
                get(baseUrl).
                then().
                statusCode(200).
                body("total", equalTo(2)).
                body("items.name", hasItem("Владикавказ")).
                body("items.name", hasItem("Владивосток"));

    }

    @Test(dataProvider = "positiveProviderHyphen", dataProviderClass = FuzzySearchProvider.class)
    public void fuzzySearchHyphenTest(String value) {

        given().
                param("q", value).
                when().
                get(baseUrl).
                then().
                statusCode(200).
                body("total", equalTo(1)).
                body("items[0]", hasKey("id")).
                body("items[0].name", equalTo("Усть-Каменогорск")).
                body("items[0].code", equalTo("ustkam")).
                body("items[0].country.name", equalTo("Казахстан")).
                body("items[0].country.code ", equalTo("kz"));

    }

    @Test(dataProvider = "positiveProviderSpace", dataProviderClass = FuzzySearchProvider.class)
    public void fuzzySearchSpaceTest(String value) {

        given().
                param("q", value).
                when().
                get(baseUrl).
                then().
                statusCode(200).
                body("total", equalTo(1)).
                body("items[0]", hasKey("id")).
                body("items[0].name", equalTo("Нижний Новгород")).
                body("items[0].code", equalTo("n_novgorod")).
                body("items[0].country.name", equalTo("Россия")).
                body("items[0].country.code ", equalTo("ru"));

    }

    @Test(dataProvider = "providerEmptyResponse", dataProviderClass = FuzzySearchProvider.class)
    public void fuzzySearchEmptyResponseTest(String value) {

        given().
                param("q", value).
                when().
                get(baseUrl).
                then().
                statusCode(200).
                body("total", equalTo(0)).
                body("items.size()", equalTo(0));

    }

    @Test(dataProvider = "negativeProvider", dataProviderClass = FuzzySearchProvider.class)
    public void fuzzySearchNegativeTest(String value) {

        given().
                param("q", value).
                when().
                get(baseUrl).
                then().
                statusCode(400);
    }

    @Test(dataProvider = "fuzzySearchCountryCodeMultiProvider", dataProviderClass = MultiParametersProvider.class)
    public void fuzzySearchCountryCodeTest(String value1, String value2) {

        given().
                param("q", value1).
                param("country_code", value2).
                when().
                get(baseUrl).
                then().
                statusCode(200).
                body("total", equalTo(1)).
                body("items[0]", hasKey("id")).
                body("items[0].name", equalTo("Магнитогорск")).
                body("items[0].code", equalTo("magnitogorsk")).
                body("items[0].country.name", equalTo("Россия")).
                body("items[0].country.code ", equalTo("ru"));
    }

    @Test(dataProvider = "fuzzySearchPageMultiProvider", dataProviderClass = MultiParametersProvider.class)
    public void fuzzySearchPageTest(String value1, int value2) {

        given().
                param("q", value1).
                param("page", value2).
                when().
                get(baseUrl).
                then().
                statusCode(200).
                body("total", equalTo(1)).
                body("items[0]", hasKey("id")).
                body("items[0].name", equalTo("Магнитогорск")).
                body("items[0].code", equalTo("magnitogorsk")).
                body("items[0].country.name", equalTo("Россия")).
                body("items[0].country.code ", equalTo("ru"));
    }

    @Test(dataProvider = "fuzzySearchPageSizeMultiProvider", dataProviderClass = MultiParametersProvider.class)
    public void fuzzySearchPageSizeTest(String value1, int value2) {

        given().
                param("q", value1).
                param("page_size", value2).
                when().
                get(baseUrl).
                then().
                statusCode(200).
                body("total", equalTo(1)).
                body("items[0]", hasKey("id")).
                body("items[0].name", equalTo("Магнитогорск")).
                body("items[0].code", equalTo("magnitogorsk")).
                body("items[0].country.name", equalTo("Россия")).
                body("items[0].country.code ", equalTo("ru"));
    }
}
