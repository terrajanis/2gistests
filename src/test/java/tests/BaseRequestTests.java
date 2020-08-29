package tests;

import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class BaseRequestTests extends TestBase {

    @Test
    public void defaultRequestTest() {

        ValidatableResponse response = given().
                when().
                get(baseUrl).
                then();

        response.statusCode(200);
        response.body("total", equalTo(response.extract().jsonPath().getList("items").size()));
        response.body("items.size()", equalTo(15));
        response.body("items[0]", hasKey("id"));
        response.body("items[0]", hasKey("name"));
        response.body("items[0]", hasKey("code"));
        response.body("items[0].country", hasKey("name"));
        response.body("items[0].country", hasKey("code"));

        List<String> codes = response.extract().jsonPath().getList("items.country.code");
        Assert.assertTrue(ccHelper.checkAllCodes(codes));

    }

    @Test
    public void checkRequestWithParams() {

        ValidatableResponse response = given().
                param("country_code", "ru").
                param("page", 1).
                param("page_size", "5").
                when().
                get(baseUrl).
                then();

        response.statusCode(200);
        response.body("total", equalTo(response.extract().jsonPath().getList("items").size()));
        response.body("items.size()", equalTo(5));
        response.body("items[0]", hasKey("id"));
        response.body("items[0]", hasKey("name"));
        response.body("items[0]", hasKey("code"));
        response.body("items[0].country", hasKey("name"));
        response.body("items[0].country", hasKey("code"));

        List<String> codes = response.extract().jsonPath().getList("items.country.code");
        Assert.assertTrue(ccHelper.checkRuCodes(codes));

    }

}
