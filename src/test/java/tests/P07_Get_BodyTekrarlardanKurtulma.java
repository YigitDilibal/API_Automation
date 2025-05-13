package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class P07_Get_BodyTekrarlardanKurtulma {

    /*
    https://restful-booker.herokuapp.com/booking/10 url’ine bir GET request gonderdigimizde
donen Response’un,
status code’unun 200,
ve content type’inin application-json,
ve response body’sindeki
"firstname“in, "Mary",
ve "lastname“in, "Brown",
ve "totalprice“in, 975,
ve "depositpaid“in, false,
ve "additionalneeds“in, "Breakfast"
oldugunu test edin

     */


    @Test
    public void test01(){
        // 1- Endpoint reqbody
        String url = "https://restful-booker.herokuapp.com/booking/10";

        // 2- ExpectedData

        // 3- Response

        Response response = given().when().get(url);

        // response.prettyPrint();

        response.then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname", equalTo("Mary"),
                        "lastname", equalTo("Brown"),
                        "totalprice", equalTo(975),
                        "depositpaid", equalTo(false),
                        "additionalneeds", equalTo("Breakfast"));

    }






}
