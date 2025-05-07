package tests;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import javax.swing.plaf.PanelUI;

public class P03_JsonObjectCreate {

    /*
     Asagidaki JSON Objesini olusturup konsolda yazdirin.
               {
               "title":"Ahmet",
               "body":"Merhaba",
               "userId":1
               }
    */

    @Test
    public void test01(){

        JSONObject jsonData = new JSONObject();
        jsonData.put("title", "Ahmet");
        jsonData.put("body","Merhaba");
        jsonData.put("userId","1");

        System.out.println("JSON Data: " + jsonData);

    }

    /*
Asagidaki JSON Objesini olusturup konsolda yazdirin.
{
    "firstname":"Jim",
    "lastname":"Brown",
    "bookingdates": {
            "checkin":"2018-01-01",
            "checkout":"2019-01-01"
                     },
     "totalprice":111,
    "depositpaid":true,
    "additionalneeds":"Breakfast"
 }
*/

    @Test
    public void test02(){

        JSONObject innerData = new JSONObject();

        innerData.put("checkin","2018-01-01");
        innerData.put("checkout","2019-01-01");

        JSONObject data = new JSONObject(); //Map<String,Object> gibi

        data.put("firstname","Jim");
        data.put("lastname","Brown");
        data.put("bookingdates",innerData);
        data.put("totalprice",111);
        data.put("depositpaid",true);
        data.put("additionalneeds","Breakfast");

        System.out.println(data);
    }




}
