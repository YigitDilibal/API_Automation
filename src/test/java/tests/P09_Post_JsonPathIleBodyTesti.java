package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class P09_Post_JsonPathIleBodyTesti {

    /*

https://restful-booker.herokuapp.com/booking url’ine asagidaki body'ye sahip bir POST
request gonderdigimizde

{
"firstname" : "Ahmet",
"lastname" : “Bulut",
"totalprice" : 500,
"depositpaid" : false,
"bookingdates" : {
                "checkin" : "2021-06-01",
                "checkout" : "2021-06-10"
                  },
"additionalneeds" : "wi-fi"
}

donen Response’un,
status code’unun 200,
ve content type’inin application-json,
ve response body’sindeki
"firstname“in,"Ahmet",
ve "lastname“in, "Bulut",
ve "totalprice“in,500,
ve "depositpaid“in,false,
ve "checkin" tarihinin 2021-06-01
ve "checkout" tarihinin 2021-06-10
ve "additionalneeds“in,"wi-fi"
oldugunu test edin


     */


    @Test
    public void test01(){

        // 1- endpoint and reqbody

        String url = "https://restful-booker.herokuapp.com/booking";

        JSONObject bookingDates = new JSONObject();

        bookingDates.put("checkin", "2021-06-01");
        bookingDates.put("checkout" , "2021-06-10");

        JSONObject booking = new JSONObject();

        booking.put("firstname" , "Ahmet");
        booking.put("lastname" , "Bulut");
        booking.put("totalprice" , 500);
        booking.put("depositpaid" , false);
        booking.put("additionalneeds" , "wi-fi");
        booking.put("bookingdates" , bookingDates);

        // 2- Expected data

        // 3- Response

        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .body(booking.toString())
                .post(url);

        // 4- Assert

        response.then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("booking.firstname", equalTo("Ahmet"),
                        "booking.lastname", equalTo("Bulut"),
                        "booking.totalprice",equalTo(500),
                        "booking.depositpaid",equalTo(false),
                        "booking.additionalneeds", equalTo("wi-fi"),
                        "booking.bookingdates.checkin", equalTo("2021-06-01"),
                        "booking.bookingdates.checkout", equalTo("2021-06-10"));


    }
}
