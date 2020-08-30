package tests;

import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.testng.annotations.Test;
import providers.PageProvider;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class PageTests extends TestBase {

    @Test
    public void checkTwoPages() {

        ValidatableResponse response1 = given().
                param("page", 1).
                when().
                get(baseUrl).
                then();

        response1.statusCode(200);
        response1.body("total", equalTo(response1.extract().jsonPath().getList("items").size()));
        response1.body("items.size()", equalTo(15));
        response1.body("items[0]", hasKey("id"));
        response1.body("items[0]", hasKey("name"));
        response1.body("items[0]", hasKey("code"));
        response1.body("items[0].country", hasKey("name"));
        response1.body("items[0].country", hasKey("code"));


        List<String> names1 = response1.extract().jsonPath().getList("items.name");

        ValidatableResponse response2 = given().
                param("page", 2).
                when().
                get(baseUrl).
                then();

        response2.statusCode(200);
        response2.body("total", equalTo(response1.extract().jsonPath().getList("items").size()));
        response2.body("items.size()", equalTo(15));
        response2.body("items[0]", hasKey("id"));
        response2.body("items[0]", hasKey("name"));
        response2.body("items[0]", hasKey("code"));
        response2.body("items[0].country", hasKey("name"));
        response2.body("items[0].country", hasKey("code"));

        List<String> names2 = response2.extract().jsonPath().getList("items.name");

        Assert.assertFalse(nameHelper.compareLists(names1, names2));

    }

    @Test(dataProvider = "negativePageProvider", dataProviderClass = PageProvider.class)
    public void negativePageTest(String value) {

        given().
                param("page", value).
                when().
                get(baseUrl).
                then().
                statusCode(400).
                body("error.message", equalTo("Параметр 'page' должен быть целым числом"));


    }

    @Test(dataProvider = "lessThanZeroPageProvider", dataProviderClass = PageProvider.class)
    public void lessThanZeroPageTest(int value) {

        given().
                param("page", value).
                when().
                get(baseUrl).
                then().
                statusCode(400).
                body("error.message", equalTo("Параметр 'page' должен быть больше 0"));


    }


}
