import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GetTest {
    @BeforeTest
    public void Base(){
        baseURI="https://ssgqa.serviceurl.in/hdfc-core";
    }

    @Test(priority=1)
    public void Check_sStatus()
    {
        given().get("/get-captcha-assisted").
                then().statusCode(200)
                .body("oStatus.sStatus",equalTo("OK"));
    }

    @Test(priority=2)
    public void Check_Captcha_1(){
        given().get("/get-captcha-assisted").
                then().statusCode(200).
                body("oBody.payLoad.iFirstCaptcha", notNullValue());
    }

    @Test(priority=3)
    public void Check_Captcha_2(){
        given().get("/get-captcha-assisted").
                then().statusCode(200).
                body("oBody.payLoad.iSecondCaptcha",notNullValue());
    }

    @AfterTest
    public void TestComplted()
    {
        System.out.println("Test has been completed");
    }

}
