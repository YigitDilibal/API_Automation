package tests;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

public class P08_JsonPathKullanimi {

    /*
    {
"firstName":"Ahmet",
"lastName":"Bulut",
"address":{
    "streetAddress":"Kurtulus cad.",
    "city":"Ankara",
    "postalCode":"06100" },
"age":49,
"phoneNumbers":[
    {
    "number":"532-555 55 55",
    "type":"cep" },
    {
    "number":"0312-123 4567",
    "type":"ev" }
]
}
     */

    @Test
    public void test01(){

        JSONObject cepTel = new JSONObject();
        JSONObject evTel = new JSONObject();

        cepTel.put("type", "cep");
        cepTel.put("number", "532-555 55 55");

        evTel.put("type", "ev");
        evTel.put("number", "0312-123 4567");

        JSONArray phoneNumbers = new JSONArray();

        phoneNumbers.put(0, cepTel);
        phoneNumbers.put(1, evTel);

        JSONObject address = new JSONObject();

        address.put("streetAddress", "Kurtulus cad.");
        address.put("city", "Ankara");
        address.put("postalCode", "06100");

        JSONObject data = new JSONObject();

        data.put("firstName", "Ahmet");
        data.put("lastName", "Bulut");
        data.put("age", 49);
        data.put("address", address);
        data.put("phoneNumbers", phoneNumbers);

        System.out.println("isim: " + data.get("firstName"));
        System.out.println("soyisim: " + data.get("lastName"));
        System.out.println("yas: " + data.get("age"));
        System.out.println("sokak adi: " + data.getJSONObject("address").get("streetAddress"));
        System.out.println("Sehir adi: " + data.getJSONObject("address").get("city"));
        System.out.println("Posta kodu : " + data.getJSONObject("address").get("postalCode"));
        System.out.println("cep no: " + data
                .getJSONArray("phoneNumbers")
                .getJSONObject(0).get("number")) ;

        System.out.println("type: " + data
                .getJSONArray("phoneNumbers")
                .getJSONObject(0).get("type")) ;


        System.out.println("ev no: " + data
                .getJSONArray("phoneNumbers")
                .getJSONObject(1).get("number")) ;

        System.out.println("type: " + data
                .getJSONArray("phoneNumbers")
                .getJSONObject(1).get("type")) ;



    }


}
