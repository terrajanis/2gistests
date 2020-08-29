package tests;

import org.testng.annotations.Test;
import providers.PageSizeProvider;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PageSizeTests extends TestBase {

    @Test
    public void CheckFivePageSize() {

        given().
                param("page_size", 5).
                when().
                get(baseUrl).
                then().
                statusCode(200).
                body("total", equalTo(5)).
                body("items.size()", equalTo(5)).
                body("items[0]", hasKey("id")).
                body("items[0]", hasKey("name")).
                body("items[0]", hasKey("code")).
                body("items[0].country", hasKey("name")).
                body("items[0].country", hasKey("code"));

    }

    @Test
    public void CheckTenPageSize() {

        given().
                param("page_size", 5).
                when().
                get(baseUrl).
                then().
                statusCode(200).
                body("total", equalTo(10)).
                body("items.size()", equalTo(10)).
                body("items[0]", hasKey("id")).
                body("items[0]", hasKey("name")).
                body("items[0]", hasKey("code")).
                body("items[0].country", hasKey("name")).
                body("items[0].country", hasKey("code"));

    }

    @Test
    public void CheckFifteenPageSize() {

        given().
                param("page_size", 15).
                when().
                get(baseUrl).
                then().
                statusCode(200).
                body("total", equalTo(15)).
                body("items.size()", equalTo(15)).
                body("items[0]", hasKey("id")).
                body("items[0]", hasKey("name")).
                body("items[0]", hasKey("code")).
                body("items[0].country", hasKey("name")).
                body("items[0].country", hasKey("code"));

    }

    @Test(dataProvider = "negativePageSizeProvider", dataProviderClass = PageSizeProvider.class)
    public void negativePageTest(Object value) {

        given().
                param("page_size", value).
                when().
                get(baseUrl).
                then().
                statusCode(400).
                body("error.message", equalTo("Параметр 'page_size' может быть одним из следующих значений: 5, 10, 15"));

    }

    @Test(dataProvider = "negativeIntegerPageSizeProvider", dataProviderClass = PageSizeProvider.class)
    public void negativeIntegerPageTest(Object value) {

        given().
                param("page_size", value).
                when().
                get(baseUrl).
                then().
                statusCode(400).
                body("error.message", equalTo("Параметр 'page_size' должен быть целым числом"));

    }

}
