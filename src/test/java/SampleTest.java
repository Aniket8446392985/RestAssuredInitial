import Base_util.Apache_Util;
import Rest.Rest_Post_Hit;
import io.restassured.*;
import io.restassured.response.Response;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleTest
{

    public static void main(String[] args)
    {
        System.out.println(Apache_Util.CreateJsonString("src/test/Test_Data/Post_Request.json"));
        //Rest_Post_Hit.baseurl();


        RestAssured.given().body(Apache_Util.CreateJsonString("src/test/Test_Data/Post_Request.json")).
                when().post("https://reqres.in/api/users").
                then().statusCode(201).log().all();
    }

}


