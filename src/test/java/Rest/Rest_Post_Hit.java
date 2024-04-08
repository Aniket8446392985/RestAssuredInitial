package Rest;

import Base_util.Apache_Util;
import Base_util.Json_util;
import io.restassured.RestAssured;
import io.restassured.http.*;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.*;



public class Rest_Post_Hit extends Json_util {
    public static void baseurl()
    {
        baseURI="https://reqres.in/";
    }
    public static void Create_Post_Request(String jsonPath)
    {
        given().body(Apache_Util.CreateJsonString(jsonPath));
    }
    public static void hit_Post_request()
    {
      //  baseURI="https://reqres.in/";
        when().post("api/users").
        then().statusCode(201).log().all();
    }

}
