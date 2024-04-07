import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleTest
{ @Test
    public void test1 ()
    {
        Response response=RestAssured.get("https://dummy.restapiexample.com/api/v1/employees");

        System.out.println(response.statusCode());
        System.out.println(response.contentType());
        System.out.println(response.getHeaders());
        System.out.println(response.getTime());

        Assert.assertEquals(response.statusCode(),200);
    }
}


