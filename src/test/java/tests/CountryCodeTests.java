package tests;

import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.testng.annotations.Test;
import providers.CountryCodeProvider;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class CountryCodeTests extends TestBase {


    @Test
    public void checkRuCountryCode() {

        ValidatableResponse response = given().
                param("country_code", "ru").
                when().
                get(baseUrl).
                then();

        response.statusCode(200);
        response.body("$", hasKey("total"));
        response.body("items[0]", hasKey("id"));
        response.body("items[0]", hasKey("name"));
        response.body("items[0]", hasKey("code"));
        response.body("items[0].country", hasKey("name"));
        response.body("items[0].country", hasKey("code"));

        List<String> codes = response.extract().jsonPath().getList("items.country.code");
        Assert.assertTrue(ccHelper.checkRuCodes(codes));

    }

    @Test
    public void checkKzCountryCode() {

        ValidatableResponse response = given().
                param("country_code", "kz").
                when().
                get(baseUrl).
                then();

        response.statusCode(200);
        response.body("$", hasKey("total"));
        response.body("items[0]", hasKey("id"));
        response.body("items[0]", hasKey("name"));
        response.body("items[0]", hasKey("code"));
        response.body("items[0].country", hasKey("name"));
        response.body("items[0].country", hasKey("code"));

        List<String> codes = response.extract().jsonPath().getList("items.country.code");
        Assert.assertTrue(ccHelper.checkKzCodes(codes));

    }

    @Test
    public void checkKgCountryCode() {

        ValidatableResponse response = given().
                param("country_code", "kg").
                when().
                get(baseUrl).
                then();

        response.statusCode(200);
        response.body("$", hasKey("total"));
        response.body("items[0]", hasKey("id"));
        response.body("items[0]", hasKey("name"));
        response.body("items[0]", hasKey("code"));
        response.body("items[0].country", hasKey("name"));
        response.body("items[0].country", hasKey("code"));

        List<String> codes = response.extract().jsonPath().getList("items.country.code");
        Assert.assertTrue(ccHelper.checkKgCodes(codes));

    }

    @Test
    public void checkCzCountryCode() {

        ValidatableResponse response = given().
                param("country_code", "cz").
                when().
                get(baseUrl).
                then();

        response.statusCode(200);
        response.body("$", hasKey("total"));
        response.body("items[0]", hasKey("id"));
        response.body("items[0]", hasKey("name"));
        response.body("items[0]", hasKey("code"));
        response.body("items[0].country", hasKey("name"));
        response.body("items[0].country", hasKey("code"));

        List<String> codes = response.extract().jsonPath().getList("items.country.code");
        Assert.assertTrue(ccHelper.checkCzCodes(codes));

    }

    @Test(dataProvider = "negativeCountryCodeProvider", dataProviderClass = CountryCodeProvider.class)
    public void negativeCountryCodeTest(String value) {

        given().
                param("country_code", value).
                when().
                get(baseUrl).
                then().
                statusCode(400).
                body("error.message", equalTo("Параметр 'country_code' может быть одним из следующих значений: ru, kg, kz, cz"));


    }
}
