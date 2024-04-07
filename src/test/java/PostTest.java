import org.json.simple.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class PostTest {
    public static JSONObject header= new JSONObject();
    public static JSONObject requets = new JSONObject();
    public static JSONObject ReqHeader= new JSONObject();
    @BeforeTest
    public void Request_Creation()
    {
        baseURI="https://ssgpreprod.serviceurl.in/hdfc-core";

        // request body creation

        header.put("sReqType","application/json");
        header.put("sAppSource", "OD_ESIGN 2.03.03");
        header.put("sSourceID","GNG_HDFC_OVERDRAFT");
        header.put("sAppID", "");
        header.put("sProduct", "OVERDRAFT");
        header.put("dtSubmit", "2024-04-06T06:15:25.689Z");
        header.put("sCroId", "default");
        header.put("sDsaId", "default");
        header.put("sInstID", "4010");
        header.put("sBranchCode", null);
        header.put("sLoginId", "FOS_LENTRA");
        header.put("sLoginRole", "FOS");
        header.put("instituteName", "HDFC");
        header.put("sDealerId", "Inhouse");

        requets.put("Header",header);
        requets.put("sPANNo","YTHPU7766Y");
        requets.put("sAcknowledementId","6610e8a3ee4284422ecd02a0");
        requets.put("sApplicantName","tdkjdjasdsa");
        requets.put("sApplicantDOB","2024-03-31T18:30:00.000Z");

        // Request Headers creation

        ReqHeader.put("Sourceid","GNG_HDFC_OVERDRAFT");
        ReqHeader.put("Content-Type","application/json");
        ReqHeader.put("Role","FOS");
        ReqHeader.put("Institutionid","4010");
    }
    @Test
    public void PostAPI()
    {
        given().body(requets.toJSONString()).log().all().headers(ReqHeader).
                when().post("/pan/validation").
                then().statusCode(500);

    }












}
