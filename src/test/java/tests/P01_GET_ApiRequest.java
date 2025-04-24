package tests;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;


import static io.restassured.path.json.JsonPath.given;

public class P01_GET_ApiRequest {
        /*
    https://restful-booker.herokuapp.com/booking/10 url’ine
    bir GET request gonderdigimizde donen Response’un,
 	status code’unun 200,
	ve content type’inin application/json; charset=utf-8,
	ve Server isimli Header’in degerinin Cowboy,
	ve status Line’in HTTP/1.1 200 OK
	ve response suresinin 5 sn’den kisa oldugunu manuel olarak test ediniz.

     */

    /*
            Tüm API Sorguları dört aşamada yapılır
                1-EndPoint ve requestBody hazırlama
                2-Soruda verilmişse expected Data hazırlanır
                3-Dönen response değeri bir obje içine kaydedilir
                4-Assertion işlemleri yapılır
     */
    @Test
    public void test01(){
        //1-EndPoint ve requestBody hazırlama
        String url="https://restful-booker.herokuapp.com/booking/10";

        //2-Soruda verilmişse expected Data hazırlanır
        //Soruda verilmemiş

        //3-Dönen response değeri bir obje içine kaydedilir
        Response response=given().when().get(url);

        // 4-Assertion işlemleri yapılır
        //Otomasyonla Kontrol
        //response.then().assertThat().statusCode(200)
        //                            .contentType("application/json; charset=utf-8")
        //                            .header("Server","Cowboy")
        //                            .statusLine("HTTP/1.1 200 OK");
        //                             System.out.println(response.getTime()+" ms");

        //Manuel Kontrol
        // response.prettyPrint(); //cevabın içeriğini yazdırır
        //  response.prettyPeek();

        System.out.println("Process Time:"+response.getTime());
        System.out.println("Status Code:"+response.getStatusCode());
        System.out.println("Status Line: "+response.getStatusLine());
        System.out.println("Server Header:"+response.getHeader("Server"));
        System.out.println("Content Type: "+response.getContentType());


    }



}
